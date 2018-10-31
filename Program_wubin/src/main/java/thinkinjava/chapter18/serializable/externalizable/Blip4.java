package thinkinjava.chapter18.serializable.externalizable;

import util.MyConst;

import java.io.*;

/**
 * @author wubin
 * @Description
 *
 * 完整保存和恢复一个Externalizable
 *
 * @project Learn-develop
 * @package thinkinjava.chapter18.serializable.externalizable
 * @email wubin326@qq.com
 * @date 2018/10/22
 * Modification History:
 * Date              Author           Version              Description
 * ----------------------------------------------------------------------
 * 2018/10/22        wubin            0.0.1
 */
public class Blip4 implements Externalizable {

    private int i;
    private String s;

    public Blip4() {
        System.out.println("Blips constructor");
    }

    public Blip4(int i, String s) {
        System.out.println("blip4(string,int)");
        this.i = i;
        this.s = s;
    }

    @Override
    public String toString() {
        return "Blip4{" +
                "i=" + i +
                ", s='" + s + '\'' +
                '}';
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        System.out.println("Blip4.writeExternal");
        /*
        必须执行下列代码
        因为默认构造方法没有赋值，
        反序列化的时候不会塞值
        需要在此方法中手动控制
         */
        out.writeObject(s);
        out.writeInt(i);
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        System.out.println("Blip4.readExternal");

        /**
         * 与writeExternal方法对应
         * 不然会报错，因为没有塞值
         */
        // s = (String) in.readObject();
        // i = in.readInt();
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Blip4 blip4 = new Blip4(666, "wubin");
        System.out.println(blip4);

        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(MyConst.FileConst.FILEPATH_DESKTOP + "blip1.out"));

        System.out.println("saving data");
        objectOutputStream.writeObject(blip4);
        objectOutputStream.close();

        /**
         * 反序列化的时候只会执行默认构造方法
         */
        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(MyConst.FileConst.FILEPATH_DESKTOP + "blip1.out"));
        System.out.println("recover b4");
        blip4 = (Blip4) objectInputStream.readObject();
        System.out.println(blip4);
    }
}
