package thinkinjava.chapter18.file.eightonezero;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;

/**
 * @author wubin
 * @Description 目录实用工具
 * @project Learn-develop
 * @package thinkinjava.chapter18.file.eightonezero
 * @email wubin326@qq.com
 * @date 2018/10/08
 */
public final class Directory {

    public static File[] local(File dir, final String regex) {
        return dir.listFiles((dir1, name) ->
                Pattern.compile(regex).matcher(new File(name).getName()).matches());
    }

    public static File[] local(String path, final String regex) {

        return local(new File(path), regex);
    }

    public static class TreeInfo implements Iterable<File> {

        public List<File> files = new ArrayList<File>();
        public List<File> dirs = new ArrayList<File>();

        @Override
        public Iterator<File> iterator() {
            return files.iterator();
        }

        void addAll(TreeInfo treeInfo) {
            files.addAll(treeInfo.files);
            dirs.addAll(treeInfo.dirs);
        }

        @Override
        public String toString() {
            return "TreeInfo{" +
                    "dirs=" + PPrint.pformat(dirs) +
                    "\n\nfiles=" + PPrint.pformat(files) +
                    '}';
        }
    }

    public static TreeInfo walk(String start, String regex) {

        return recurseDirs(new File(start), regex);
    }

    public static TreeInfo walk(File start, String regex) {

        return recurseDirs(start, regex);
    }

    public static TreeInfo walk(String start) {

        return recurseDirs(new File(start), ".*");
    }

    public static TreeInfo walk(File start) {

        return recurseDirs(start, ".*");
    }

    static TreeInfo recurseDirs(File startDir, String regex) {

        TreeInfo treeInfo = new TreeInfo();
        for (File item : startDir.listFiles()
                ) {
            if (item.isDirectory()) {
                treeInfo.dirs.add(item);
                //递归获取所有的匹配文件
                treeInfo.addAll(recurseDirs(item, regex));
            } else {
                if (item.getName().matches(regex)) {
                    treeInfo.files.add(item);
                }
            }
        }
        return treeInfo;
    }

    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println(walk("."));
        } else {
            for (String item : args
                    ) {
                System.out.println(walk(item));
            }
        }
    }

}
