package thinkinjava.chapter18.file.eightonezero;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author wubin
 * @Description
 *
 * 目录的检查以及创建
 * @project Learn-develop
 * @package thinkinjava.chapter18.file.eightonezero
 * @email wubin326@qq.com
 * @date 2018/10/09
 */
public class MakeDirectories {

    private static void usage(){
        System.err.println(
                "Usage:MakeDirectories path1 ...\n" +
                        "Creates each path\n" +
                        "Usage:MakeDirectories -d path1 ...\n" +
                        "Deletes each path\n" +
                        "Usage:MakeDirectories -r path1 path2\n" +
                        "Renames from path1 to path2");
        System.exit(1);
    }

    private static void fileData(File f){

        System.out.println(
                "Absolute path: " + f.getAbsolutePath() +
                        "\n Can read: " + f.canRead() +
                        "\n Can write: " + f.canWrite() +
                        "\n getName: " + f.getName() +
                        "\n getParent: " + f.getParent() +
                        "\n getPath: " + f.getPath() +
                        "\n length: " + f.length() +
                        "\n lastModified: " + new SimpleDateFormat("YYYY-mm-dd hh:MM:ss").format(new Date(f.lastModified())));
        if(f.isFile())
            System.out.println("It's a file");
        else if(f.isDirectory())
            System.out.println("It's a directory");
        else
            System.out.println("nothing");
    }

    public static void main(String[] args) {
        if(args.length < 1) usage();
        if(args[0].equals("-r")) {
            if(args.length != 3) usage();
            File
                    old = new File(args[1]),
                    rname = new File(args[2]);
            /**
             * renamTo使用说明
             第一种场景：同一路径下文件重命名【文件重命名】
             第二种场景：将文件从一个路径移动另一个路径下，并且移动的文件进行重命名【文件移动重命名】
             第三种场景：修改文件夹的名称，文件夹里面没有文件的时候修改成功！
             */
            old.renameTo(rname);
            fileData(old);
            fileData(rname);
            return; // Exit main
        }
        int count = 0;
        boolean del = false;
        if(args[0].equals("-d")) {
            count++;
            del = true;
        }
        count--;
        while(++count < args.length) {
            File f = new File(args[count]);
            if(f.exists()) {
                System.out.println(f + " exists");
                if(del) {
                    System.out.println("deleting..." + f);
                    f.delete();
                }
            }
            else { // Doesn't exist
                if(!del) {
                    f.mkdirs();
                    System.out.println("created " + f);
                }
            }
            fileData(f);
        }
    }
}
