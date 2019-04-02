package netty.nettypractice;

import io.netty.bootstrap.Bootstrap;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.util.CharsetUtil;

import java.net.InetSocketAddress;

/**
 * @author wubin
 * @Description
 * @project Learn-develop
 * @package netty.nettypractice
 * @email wubin326@qq.com
 * @date 2019/01/17
 * Modification History:
 * Date              Author           Version              Description
 * ----------------------------------------------------------------------
 * 2019/01/17        wubin            0.0.1
 */
public class CSUseOneEventLoop {

    public static void main(String[] args) {
        ServerBootstrap serverBootstrap = new ServerBootstrap();
        serverBootstrap.group(new NioEventLoopGroup(), new NioEventLoopGroup())
                .localAddress(9999)
                .channel(NioServerSocketChannel.class)
                /**
                 * 你可以使用initializeChannel类，也可以直接创建逻辑channelhandler
                 * 设置将被添加到已被接受的子 Channel 的 ChannelPipeline 中的 Channel- Handler。
                 * handler()方法和 childHandler()方法之间的区别是:前者所 添加的 ChannelHandler 由
                 * 接受子 Channel 的 ServerChannel 处理,而 childHandler()方法所添加的 ChannelHandler
                 * 将由已被接受的子 Channel 处理,其代表一个绑定到远程节点的套接字
                 */
                .childHandler(new SimpleChannelInboundHandler<ByteBuf>() {
                    ChannelFuture connectFuture;

                    @Override
                    public void channelActive(ChannelHandlerContext ctx) throws Exception {
                        /**
                         * 创建一个 Bootstrap 类的实例以连接 到远程主机
                         */
                        Bootstrap bootstrap = new Bootstrap();
                        bootstrap//.remoteAddress(new InetSocketAddress("127.0.0.1", 9998))
                                .channel(NioSocketChannel.class)
                                .handler(new SimpleChannelInboundHandler<ByteBuf>() {
                                    @Override
                                    protected void channelRead0(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf) {
                                        System.out.println("Recieved data!");
                                    }

                                    @Override
                                    public void channelActive(ChannelHandlerContext ctx) throws Exception {
                                        System.out.println("客户端被激活啦！");
                                        ctx.writeAndFlush(Unpooled.copiedBuffer("内置的client".getBytes(CharsetUtil.UTF_8)));
                                    }
                                });
                        bootstrap.group(ctx.channel().eventLoop());
                        connectFuture = bootstrap.connect(new InetSocketAddress("127.0.0.1",9999));
                    }

                    @Override
                    protected void channelRead0(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf) {
                        if (connectFuture.isDone()) {
                            System.out.println("不知道怎么发送数据啊！");
                        }
                    }
                });
        ChannelFuture channelFuture = serverBootstrap.bind();
        channelFuture.addListener((ChannelFutureListener) channelFuture1 -> {
            if (channelFuture1.isSuccess()) {
                System.out.println("Server Bound! ");
            } else {
                System.out.println("server boud fail! ");
                channelFuture1.channel().closeFuture();
                channelFuture1.cause().printStackTrace();
            }
        });
    }
}
