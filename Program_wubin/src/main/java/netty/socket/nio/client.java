package netty.socket.nio;

import java.io.*;
import java.net.ServerSocket;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.ServerSocketChannel;

/**
 * @author wubin
 * @Description
 * @project Learn-develop
 * @package netty.socket.nio
 * @email wubin326@qq.com
 * @date 2019/01/16
 * Modification History:
 * Date              Author           Version              Description
 * ----------------------------------------------------------------------
 * 2019/01/16        wubin            0.0.1
 */
public class client {

    public static void main(String[] args) {
        ServerSocketChannel serverSocketChannel = null;
        try {
            serverSocketChannel = ServerSocketChannel.open();
            ServerSocket socket = serverSocketChannel.socket();
            // serverSocketChannel.
            FileChannel channel = new FileInputStream("asdasd").getChannel();
            channel.read(ByteBuffer.allocate(1024));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
