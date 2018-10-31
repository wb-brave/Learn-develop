package netty.demo;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;

/**
 * 应用规则
 *
 * @author wubin
 * @Description 丢弃任何进入的数据 启动服务端的DiscardServerHandler
 * @project Learn-develop
 * @package netty.demo
 * @email wubin326@qq.com
 * @date 2018/09/28
 */
public class DiscardServer {

    private int port;

    public DiscardServer(int port) {
        this.port = port;
    }

    public void run() throws Exception {

        EventLoopGroup bossGroup = new NioEventLoopGroup();
        EventLoopGroup workerGroup = new NioEventLoopGroup();
        System.out.println("准备运行端口：" + port);
        try {
            ServerBootstrap serverBootstrap = new ServerBootstrap();
            serverBootstrap =
                    /**
                     * 这一步是必须的，如果没有设置group将会报java.lang.IllegalStateException: group not
                     * set异常
                     */
                    serverBootstrap.group(bossGroup, workerGroup)
                    /***
                     * ServerSocketChannel以NIO的selector为基础进行实现的，用来接收新的连接
                     * 这里告诉Channel如何获取新的连接.
                     */
                    .channel(NioServerSocketChannel.class)
                    /***
                     * 这里的事件处理类经常会被用来处理一个最近的已经接收的Channel。 ChannelInitializer是一个特殊的处理类，
                     * 他的目的是帮助使用者配置一个新的Channel。
                     * 也许你想通过增加一些处理类比如NettyServerHandler来配置一个新的Channel
                     * 或者其对应的ChannelPipeline来实现你的网络程序。 当你的程序变的复杂时，可能你会增加更多的处理类到pipline上，
                     * 然后提取这些匿名类到最顶层的类上。
                     */
                    .childHandler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel socketChannel) throws Exception {
                            socketChannel.pipeline().addLast(new DiscardServerHandler());
                        }
                    })
                    /***
                     * 你可以设置这里指定的通道实现的配置参数。 我们正在写一个TCP/IP的服务端，
                     * 因此我们被允许设置socket的参数选项比如tcpNoDelay和keepAlive。
                     * 请参考ChannelOption和详细的ChannelConfig实现的接口文档以此可以对ChannelOptions的有一个大概的认识。
                     */
                    .option(ChannelOption.SO_BACKLOG, 128)
                    /**
                     * option()是提供给NioServerSocketChannel用来接收进来的连接。
                     * childOption()是提供给由父管道ServerChannel接收到的连接，
                     * 在这个例子中也是NioServerSocketChannel。
                     */
                    .childOption(ChannelOption.SO_KEEPALIVE, true)
            ;
            /**
             *绑定端口并启动去接收进来的连接
             */
            ChannelFuture f = serverBootstrap.bind(port).sync();
            /**
             *一直等待，知道socket被关闭
             */
            f.channel().closeFuture().sync();

        } finally {
            workerGroup.shutdownGracefully();
            bossGroup.shutdownGracefully();
        }
    }

    public static void main(String[] args) throws Exception{
        int port;
        if (args.length>0){
            port = Integer.parseInt(args[0]);
        }else{
            port=8080;
        }
        new DiscardServer(port).run();
        System.out.println("server:run()");
    }
}
