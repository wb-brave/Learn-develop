package thinkinjava.chapter12.exceptions;

import java.io.*;

/**
 * @author wubin
 * @Description 在构造器中的异常有丢失的风险
 * @project Learn-develop
 * @package thinkinjava.chapter12.exceptions
 * @email wubin326@qq.com
 * @date 2018/11/28
 * Modification History:
 * Date              Author           Version              Description
 * ----------------------------------------------------------------------
 * 2018/11/28        wubin            0.0.1
 */
public class InputFile {
    private BufferedReader br;

    public InputFile(String fname) throws Exception {
        try {
            br = new BufferedReader(new FileReader(fname));
        } catch (FileNotFoundException e) {
            System.out.println("Could not open " + fname);
            // Wasn't open, so don't close it
            throw e;
        } catch (Exception e) {
            // All other exceptions must close it
            try {
                br.close();
            } catch (IOException e2) {
                System.out.println("in.close() unsuccessful");
            }
            throw e; // Rethrow
        } finally {
            /*
            设计目的希望在InputFile的整个生命周期输入流都是打开的
            除非是发生了异常，才关闭流
             */
            // Don't close it here!!!
        }
    }

    public String getLine() {
        String s;
        try {
            s = br.readLine();
        } catch (IOException e) {
            throw new RuntimeException("readLine() failed");
        }
        return s;
    }

    public void dispose() {
        try {
            br.close();
            System.out.println("dispose() successful");
        } catch (IOException e2) {
            throw new RuntimeException("in.close() failed");
        }
    }
}
