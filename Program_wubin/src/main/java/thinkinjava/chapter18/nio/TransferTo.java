package thinkinjava.chapter18.nio;

import java.io.*;
import java.nio.channels.FileChannel;

/**
 * @author wubin
 * @Description
 * @project Learn-develop
 * @package thinkinjava.chapter18.nio
 * @email wubin326@qq.com
 * @date 2018/10/18
 * Modification History:
 * Date              Author           Version              Description
 * ----------------------------------------------------------------------
 * 2018/10/18        wubin            0.0.1
 */
public class TransferTo {

    public static void main(String[] args) throws IOException {
        if (args.length != 2) {
            System.out.println("arguments: sourceFile destFile");
            System.exit(1);
        }

        FileChannel in = new FileInputStream(args[0]).getChannel();
        FileChannel out = new FileOutputStream(args[1]).getChannel();
        // in.transferTo(0,in.size(),out);
        out.transferFrom(in,0,in.size());
    }
}
