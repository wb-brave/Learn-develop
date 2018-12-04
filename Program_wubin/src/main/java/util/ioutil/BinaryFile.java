package util.ioutil;

import java.io.*;

/**
 * @author wubin
 * @Description
 * @project Learn-develop
 * @package util.ioutil
 * @email wubin326@qq.com
 * @date 2018/12/03
 * Modification History:
 * Date              Author           Version              Description
 * ----------------------------------------------------------------------
 * 2018/12/03        wubin            0.0.1
 */
public class BinaryFile {

    public static byte[] readBinaryFile(File bfile) {
        byte[] data = null;
        try {
            final BufferedInputStream bufferedInputStream =
                    new BufferedInputStream(new FileInputStream(bfile));
            /**
             * 数据在上一步已经加载到缓存区了
             * 根据输入流中可达的最大长度初始化字节数数组
             * 之后将流中的数据读入字节数组中
             */
            data = new byte[bufferedInputStream.available()];
            bufferedInputStream.read(data);
            bufferedInputStream.close();
            return data;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return data;
    }
}
