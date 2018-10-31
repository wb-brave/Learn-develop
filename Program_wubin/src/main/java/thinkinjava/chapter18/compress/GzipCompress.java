package thinkinjava.chapter18.compress;

import util.MyConst;

import java.io.*;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

/**
 * @author wubin
 * @Description
 * @project Learn-develop
 * <p>
 * 使用gzip进行简单的压缩
 * @package thinkinjava.chapter18.compress
 * @email wubin326@qq.com
 * @date 2018/10/19
 * Modification History:
 * Date              Author           Version              Description
 * ----------------------------------------------------------------------
 * 2018/10/19        wubin            0.0.1
 */
public class GzipCompress {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(MyConst.FileConst.FILEPATH_DESKTOP + "data1.txt"));
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new GZIPOutputStream(new FileOutputStream(MyConst.FileConst.FILEPATH_DESKTOP + "/data2.gz")));
        System.out.println("writeing file");
        int c;
        /**
         * 写入压缩文件
         */
        while ((c = br.read()) != -1) {
            bufferedOutputStream.write(c);
        }
        br.close();
        bufferedOutputStream.close();
        System.out.println("reading file");
        /**
         * 从压缩文件中读取数据
         */
        BufferedReader br1 = new BufferedReader(new InputStreamReader(new GZIPInputStream(new FileInputStream(MyConst.FileConst.FILEPATH_DESKTOP + "data2.gz"))));
        String s;
        while ((s = br1.readLine()) != null) {
            System.out.println(s);
        }
    }
}
