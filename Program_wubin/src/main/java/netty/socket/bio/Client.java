package netty.socket.bio;

import java.io.*;
import java.net.Socket;
import java.nio.charset.Charset;

/**
 * @author wubin
 * @Description
 * @project Learn-develop
 * @package netty.socket.bio
 * @email wubin326@qq.com
 * @date 2019/01/16
 * Modification History:
 * Date              Author           Version              Description
 * ----------------------------------------------------------------------
 * 2019/01/16        wubin            0.0.1
 */
public class Client {
    public static void main(String[] args) {
        OutputStream outputStream = null;
        InputStream inputStream = null;
        try {
            Socket socket = new Socket("127.0.0.1", 9999);
            outputStream = socket.getOutputStream();
            outputStream.write("发送小爱心！".getBytes(Charset.forName("utf8")));
            outputStream.flush();
            inputStream = socket.getInputStream();
            byte[] bytes = new byte[1024];
            int recisize= 0;
            while ((recisize=inputStream.read(bytes)) != -1) {
                System.out.println(new String(bytes,0,recisize));
            }
            // System.out.println(br.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                outputStream.close();
                // br.close();、
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
