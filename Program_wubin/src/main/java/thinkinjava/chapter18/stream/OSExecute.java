package thinkinjava.chapter18.stream;

import thinkinjava.chapter18.exception.OSExecuteException;

import java.io.*;

/**
 * @author wubin
 * @Description 需要使用特定的异常
 * @project Learn-develop
 * @package thinkinjava.chapter18.stream
 * @email wubin326@qq.com
 * @date 2018/10/18
 * Modification History:
 * Date              Author           Version              Description
 * ----------------------------------------------------------------------
 * 2018/10/18        wubin            0.0.1                 关于进程控制
 */
public class OSExecute {

    /**
     * 使用junit测试会出异常 具体请看test目录下的信息OSExecuteTest
     * @param command 是具体的命令字符串 eq："javap OSExecuteTest"
     */
    public static void command(String command) {
        boolean err = false;
        try {

            ProcessBuilder processBuilder = new ProcessBuilder(command.split(" "));
            Process start = processBuilder.start();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(start.getInputStream()));
            String s;
            while ((s = bufferedReader.readLine()) != null) {
                System.out.println(s);
            }
            BufferedReader bufferedReader1 = new BufferedReader(new InputStreamReader(start.getErrorStream()));
            while ((s = bufferedReader1.readLine()) != null) {
                System.out.println(s);
                err = true;
            }

        } catch (IOException e) {
            if (!command.startsWith("CMD /C")) {
                command("CMD /C " + command);
            } else {
                throw new RuntimeException(e);
            }
        }
        if (err){
            throw new OSExecuteException("ERRORS EXECUTING " + command);
        }
    }
}
