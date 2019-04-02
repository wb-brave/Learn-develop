package netty.socket.bio;

import java.io.*;
import java.net.*;

/**
 * @author wubin
 * @Description
 * @project Learn-develop
 * @package netty.socket.bio
 * @email wubin326@qq.com
 * @date 2019/03/01
 * Modification History:
 * Date              Author           Version              Description
 * ----------------------------------------------------------------------
 * 2019/03/01        wubin            0.0.1
 */
public class ThreadsTcp {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("127.0.0.1", 9999);
        byte[] msg="我爱上的可能脚本".getBytes();
        OutputStream outputStream = socket.getOutputStream();
        outputStream.write(msg);
        outputStream.flush();
        socket.close();
    }
}

class multiServer {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(9999);
        while (true) {
            Socket accept = serverSocket.accept();
            new Thread(() -> {
                BufferedInputStream bi = null;
                try {
                    try {
                        byte[] bytes = new byte[1024];
                        bi = new BufferedInputStream(accept.getInputStream());
                        int read = bi.read(bytes);
                        System.out.println(new String(bytes, 0, read));
                    } catch (IOException e) {
                        e.printStackTrace();
                    } finally {
                        accept.close();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    try {
                        bi.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        }
    }
}
