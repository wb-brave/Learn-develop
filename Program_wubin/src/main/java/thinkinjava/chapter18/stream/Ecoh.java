package thinkinjava.chapter18.stream;

import java.io.*;

/**
 * @author wubin
 * @Description
 * @project Learn-develop
 * @package thinkinjava.chapter18.stream
 * @email wubin326@qq.com
 * @date 2018/10/18
 * Modification History:
 * Date              Author           Version              Description
 * ----------------------------------------------------------------------
 * 2018/10/18        wubin            0.0.1              直接回显输入的每一行
 */
public class Ecoh {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s;
        if ((s = reader.readLine()) != null && s.length() != 0) {
            System.out.println(s);
        }
    }
}
