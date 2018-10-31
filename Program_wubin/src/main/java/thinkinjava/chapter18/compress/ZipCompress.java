package thinkinjava.chapter18.compress;

import util.MyConst;

import java.io.*;
import java.util.Enumeration;
import java.util.zip.*;

/**
 * @author wubin
 * @Description
 * @project Learn-develop
 * @package thinkinjava.chapter18.compress
 * @email wubin326@qq.com
 * @date 2018/10/22
 * Modification History:
 * Date              Author           Version              Description
 * ----------------------------------------------------------------------
 * 2018/10/22        wubin            0.0.1
 */
public class ZipCompress {

    public static void main(String[] args) throws IOException {
        String filename = MyConst.FileConst.FILEPATH_DESKTOP + "data1.txt";
        String zipFilename = MyConst.FileConst.FILEPATH_DESKTOP + "test.zip";
        FileOutputStream outputStream = new FileOutputStream(zipFilename);
        /**
         * 以Adler32格式进行压缩
         * 速度快
         *
         * 将输出目标文件，定向到zip输出流中
         */
        CheckedOutputStream checkedOutputStream = new CheckedOutputStream(outputStream, new Adler32());
        ZipOutputStream zipOutputStream = new ZipOutputStream(checkedOutputStream);

        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(zipOutputStream);
        zipOutputStream.setComment("a test of java 压缩");
        BufferedReader reader = new BufferedReader(new FileReader(filename));
        zipOutputStream.putNextEntry(new ZipEntry(filename));
        int c;
        /**
         * 将数据从文件中读取出，
         * 并迭代写入压缩文件
         */
        while ((c = reader.read()) != -1) {
            bufferedOutputStream.write(c);
        }

        reader.close();
        bufferedOutputStream.flush();
        bufferedOutputStream.close();

        System.out.println("checksum: " + checkedOutputStream.getChecksum().getValue());

        System.out.println("reading file");
        FileInputStream fileInputStream = new FileInputStream(zipFilename);
        CheckedInputStream checkedInputStream = new CheckedInputStream(fileInputStream, new Adler32());
        ZipInputStream zipInputStream = new ZipInputStream(checkedInputStream);
        BufferedInputStream bufferedInputStream = new BufferedInputStream(zipInputStream);
        ZipEntry ze;
        while ((ze = zipInputStream.getNextEntry()) != null) {
            System.out.println("reading file " + ze);
            int x;
            while ((x = bufferedInputStream.read()) != -1) {
                System.out.write(x);
            }
        }
        bufferedInputStream.close();

        // /**
        //  * 另一种读取方式
        //  */
        // ZipFile zipFile = new ZipFile(zipFilename);
        // Enumeration<? extends ZipEntry> entries = zipFile.entries();
        // while (entries.hasMoreElements()){
        //     ZipEntry zipEntry = entries.nextElement();
        //     System.out.println("file " + zipEntry);
        // }
    }
}
