package netty.socket.bio;

import java.io.*;
import java.net.*;
import java.nio.charset.Charset;

/**
 * @author wubin
 * @Description
 * @project Learn-develop
 * @package netty.socket.bio
 * @email wubin326@qq.com
 * @date 2019/01/14
 * Modification History:
 * Date              Author           Version              Description
 * ----------------------------------------------------------------------
 * 2019/01/14        wubin            0.0.1
 */
public class ServerSocketDemo {

    public static void main(String[] args) {
        ServerSocket serverSocket;
        try {
            serverSocket = new ServerSocket(9999);
            for (; ; ) {
                //这句不能放在线程启动里面，不然直接内存溢出
                Socket clientSocket = serverSocket.accept();
                System.out.println("connect: " + ServerSocketDemo.class.getSimpleName());
                //没接收一个客户端，启动一个新的线程处理
                new Thread(() -> {
                    OutputStream outputStream = null;
                    BufferedReader br = null;
                    try {
                        // BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                        // String input;
                        // while ((input = bufferedReader.readLine()) != null) {
                        //     if (input.equals("out")) {
                        //         break;
                        //     }
                        //     // PrintWriter printWriter = new PrintWriter(new OutputStreamWriter(clientSocket.getOutputStream()));
                        //     // printWriter.println(input);
                        //     System.out.println(input);
                        // }
                        outputStream = clientSocket.getOutputStream();
                        outputStream.write("吴彬".getBytes(Charset.forName("utf8")));
                        outputStream.flush();
                        br = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                        System.out.println(br.readLine());
                        // BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()));
                        // bufferedWriter.write("回复");
                        // bufferedWriter.flush();
                        // bufferedWriter.write("我回你了啊！");
                    } catch (IOException e) {
                        e.printStackTrace();
                    } finally {
                        try {
                            outputStream.close();
                            br.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
