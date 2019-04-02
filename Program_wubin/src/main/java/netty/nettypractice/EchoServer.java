package netty.nettypractice;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;

import java.net.InetSocketAddress;

/**
 * @author wubin
 * @Description
 * @project Learn-develop
 * @package netty.nettypractice
 * @email wubin326@qq.com
 * @date 2019/01/15
 * Modification History:
 * Date              Author           Version              Description
 * ----------------------------------------------------------------------
 * 2019/01/15        wubin            0.0.1
 */
public class EchoServer {
    private final int port;

    public EchoServer(int port) {
        this.port = port;
    }

    public static void main(String[] args) throws Exception {
        if (args.length != 1) {
            System.err.println(
                    "Usage: " + EchoServer.class.getSimpleName() +
                            " <port>");
        }
        int port = Integer.parseInt(args[0]);
        new EchoServer(port).start();
    }

    public void start() throws Exception {
        final EchoServerHandler echoServerHandler = new EchoServerHandler();
        EventLoopGroup group = new NioEventLoopGroup();
        try {
            ServerBootstrap serverBootstrap = new ServerBootstrap();
            serverBootstrap.group(group)
                    //指定使用NIO的channel
                    .channel(NioServerSocketChannel.class)
                    //指定端口设置套接字地址
                    .localAddress(new InetSocketAddress(port))
                    /**添加一个 EchoServerHandler 到子 Channel 的 ChannelPip
                     * 每创建一个新的channel都使用echoServerHandler实例进行初始化
                     */
                    .childHandler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel socketChannel) {
                            //echoServerHandler使用了注解@sharable，所以所有客户端都是使用同一个channelHandler
                            socketChannel.pipeline().addLast(echoServerHandler);
                        }
                    });
            //异步绑定服务器，调用sync()方法一直阻塞到绑定成功
            ChannelFuture future = serverBootstrap.bind(port).sync();
            //获取 Channel 的 CloseFuture,并且阻塞当前线程直到它完成
            future.channel().closeFuture().sync();
        } finally {
            // 关闭 EventLoopGroup, 释放所有的资源
            group.shutdownGracefully().sync();
        }
    }
}
