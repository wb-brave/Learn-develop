package thinkinjava.chapter18.serializable;

import util.MyConst;

import java.io.*;
import java.util.Arrays;
import java.util.Random;

/**
 * @author wubin
 * @Description
 *
 * 序列化==>初始探索
 * 实现Serializable
 * 在反序列化的时候是完全根据它存储的
 * 二进制的位为基础进行构造的
 *
 * @project Learn-develop
 * @package thinkinjava.chapter18.serializable
 * @email wubin326@qq.com
 * @date 2018/10/22
 * Modification History:
 * Date              Author           Version              Description
 * ----------------------------------------------------------------------
 * 2018/10/22        wubin            0.0.1
 */
class Data implements Serializable {
    private int i;

    public Data(int i) {
        this.i = i;
    }

    @Override
    public String toString() {
        return Integer.toString(i);
    }
}

public class Worm implements Serializable {

    private static Random rand = new Random(47);

    private Data[] ds = {
            new Data(rand.nextInt(10)),
            new Data(rand.nextInt(10)),
            new Data(rand.nextInt(10))
    };
    private Worm next;
    private char c;

    public Worm(int i, char x) {
        System.out.println("worm constructor: " + i);
        this.c = x;
        if (--i > 0) {
            next = new Worm(i, (char) (x + 1));
        }

    }

    public Worm() {
        System.out.println("default constructor");
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(":");
        sb.append(c)
                .append("(");
        for (Data d : ds
                ) {
            sb.append(d);
        }
        sb.append(")");
        if (next != null) {
            sb.append(next);
        }
        return sb.toString();
    }

    public static void main(String[] args) throws Exception {
        String filename = MyConst.FileConst.FILEPATH_DESKTOP + "worm.out";
        Worm worm = new Worm(6, 'a');
        System.out.println("worm = " + worm);
        /**
         * 将文件序列化输出
         */
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(filename));
        objectOutputStream.writeObject("worm storage\n");
        objectOutputStream.writeObject(worm);
        objectOutputStream.close();

        /**
         * 反序列化文件
         */
        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(filename));
        String s = (String) objectInputStream.readObject();
        Worm w = (Worm) objectInputStream.readObject();
        System.out.println(s + " w = " + w);

        ByteArrayOutputStream byos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(byos);
        oos.writeObject("worm storage\n");
        oos.writeObject(w);
        oos.flush();

        ObjectInputStream ois = new ObjectInputStream(new ByteArrayInputStream(byos.toByteArray()));
        s = (String) ois.readObject();
        Worm w1 = (Worm) ois.readObject();
        System.out.println(s + " w1 = " + w1);
    }
}




