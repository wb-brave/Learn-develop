package netty.socket.nio;

import sun.tools.tree.ShiftLeftExpression;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.util.Iterator;
import java.util.Set;

/**
 * @author wubin
 * @Description
 * @project Learn-develop
 * @package netty.socket.nio
 * @email wubin326@qq.com
 * @date 2019/01/15
 * Modification History:
 * Date              Author           Version              Description
 * ----------------------------------------------------------------------
 * 2019/01/15        wubin            0.0.1
 */
public class ServerSocketChannelDemo {

    public static void main(String[] args) throws IOException {
        //打开一个channel来进行网络传输
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        //异步
        serverSocketChannel.configureBlocking(false);
        /**
         * 创建一个ServerSocketAdaptor保存在serverSocketChannel本地变量中
         * 并返回这个变量
         */
        ServerSocket socket = serverSocketChannel.socket();
        InetSocketAddress inetSocketAddress = new InetSocketAddress(9999);
        socket.bind(inetSocketAddress);
        /** 使用selector来处理channel
         * 会打开两个通道
         */
        Selector selector = Selector.open();
        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
        final ByteBuffer msg = ByteBuffer.wrap("Hi!\r\n".getBytes());
        for (; ; ) {
            selector.select();
            Set<SelectionKey> selectionKeys = selector.selectedKeys();
            Iterator<SelectionKey> iterator = selectionKeys.iterator();
            while (iterator.hasNext()){
                SelectionKey selectionKey = iterator.next();
                /**
                 * 必须要删除不然一直会存在这个客户端
                 */
                iterator.remove();
                try {
                    if (selectionKey.isAcceptable()) {
                        ServerSocketChannel channel = (ServerSocketChannel) selectionKey.channel();
                        SocketChannel accept = channel.accept();
                        accept.configureBlocking(false);
                        accept.register(selector, SelectionKey.OP_READ | SelectionKey.OP_WRITE, msg.duplicate());
                        System.out.println("accepted connect from " + accept);
                    }
                    if (selectionKey.isWritable()) {
                        SocketChannel channel = (SocketChannel) selectionKey.channel();
                        ByteBuffer bf = (ByteBuffer) selectionKey.attachment();
                        while (bf.hasRemaining()){
                            if (channel.write(bf)==0){
                                break;
                            }
                        }
                        channel.close();
                    }
                }catch (IOException io){
                    selectionKey.cancel();
                    selectionKey.channel().close();
                }
            }
        }
    }
}
