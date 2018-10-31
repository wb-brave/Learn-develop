package thinkinjava.chapter18.file.eightonezero;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Pattern;

/**
 * @author wubin
 * @Description 在目录中穿行，可以根据strategy对象处理目录中的文件
 *
 * 通过内置一个接口类，设计为策略模式。根据构造时实现接口的方法来执行不用的行为
 * @project Learn-develop
 * @package thinkinjava.chapter18.file.eightonezero
 * @email wubin326@qq.com
 * @date 2018/10/09
 */
public class ProcessFiles {
    public interface Strategy {
        void process(File file);
    }

    private Strategy strategy;
    private String ext;
    private String destName;
    private String destDate;

    public ProcessFiles(Strategy strategy, String ext) {
        this.strategy = strategy;
        this.ext = ext;
    }

    public ProcessFiles(Strategy strategy, String ext, String destName, String destDate) {
        this.strategy = strategy;
        this.ext = ext;
        this.destName = destName;
        this.destDate = destDate;
    }

    public void start(String[] args) {
        try {
            if (args.length == 0) {
                processDirectoryTree(new File("."));
            } else {

                for (String arg : args
                        ) {
                    File fileArg = new File("/Users/wufan/wubin/github/" + arg);
                    if (fileArg.isDirectory()) {
                        processDirectoryTree(fileArg,destDate);
                    } else {
//                        if (!arg.endsWith("."+ext)){
                        //使用正则表达式
                        if (!Pattern.compile("\\..*(" + ext + ").*").matcher(arg).matches()) {
                            arg += "." + ext;
                        }
                        strategy.process(new File(arg).getCanonicalFile());
                    }

                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void processDirectoryTree(File root) throws IOException {
        for (File file : Directory.walk(root.getAbsolutePath(), ".*\\..*(" + ext + ").*")
                ) {
            strategy.process(file.getCanonicalFile());
        }
    }

    //region 查找特定的目录下的所有某个特定日期之后的源代码文件
    private void processDirectoryTree(File root, String destDate) throws IOException, ParseException {
        for (File file : Directory.walk(root.getAbsolutePath(), ".*\\..*(" + ext + ").*")
                ) {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date date = simpleDateFormat.parse(destDate);
            long time = date.getTime();
            if (file.lastModified() > time) {
                strategy.process(file.getCanonicalFile());
            }
        }
    }
    //endregion

    public static void main(String[] args) {
//        new ProcessFiles(new ProcessFiles.Strategy(){
//            public void process(File file){
//                System.out.println(file);
//            }
//        },"cla").start(args);

        //region 查找特定的目录下的所有某个特定日期之后的源代码文件
        new ProcessFiles(new ProcessFiles.Strategy() {
            public void process(File file) {
                System.out.println(file);
            }
        }, "class", "Learn_develop", "2018-10-10 12:12:12").start(args);
        //endregion
    }
}
