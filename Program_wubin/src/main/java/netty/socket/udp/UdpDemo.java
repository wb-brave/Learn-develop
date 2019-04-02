package netty.socket.udp;

import java.io.IOException;
import java.net.*;
import java.util.concurrent.CountDownLatch;

/**
 * @author wubin
 * @Description 简单练习下udp的使用
 * udp面向无连接，不可靠，限制大小64k
 * @project Learn-develop
 * @package netty.socket.udp
 * @email wubin326@qq.com
 * @date 2019/03/01
 * Modification History:
 * Date              Author           Version              Description
 * ----------------------------------------------------------------------
 * 2019/03/01        wubin            0.0.1
 */
public class UdpDemo {

    public static void main(String[] args) throws IOException {
        DatagramSocket datagramSocket = new DatagramSocket();
        String msg = "我发送了，不管啦啦不管啦啦不管啦啦不管啦啦不管啦啦不管啦啦啦啦啦哦";
        DatagramPacket packet = new DatagramPacket(msg.getBytes(), msg.getBytes().length, InetAddress.getByName("127.0.0.1"), 6666);
        datagramSocket.send(packet);
        datagramSocket.close();

    }
}

class UdpServer{
    public static void main(String[] args) throws IOException, InterruptedException {
        DatagramSocket uds = new DatagramSocket(6666);
        //服务端接收数据竟然还要指定长度
        byte[] pack = new byte[64];
        DatagramPacket datagramPacket = new DatagramPacket(pack,pack.length);
        uds.receive(datagramPacket);
        //获取一个字节数组的指定长度
        System.out.println(String.format("%s",new String(datagramPacket.getData(),0,datagramPacket.getLength())));
    }
}
