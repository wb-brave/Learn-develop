package thinkinjava.chapter18.serializable;

import util.MyConst;

import java.io.*;

/**
 * @author wubin
 * @Description 对比类 Blip4 实现的接口不一样，查看反序列化的结果
 * <p>
 * 可以在实现了Serializable接口的类中
 * 手动实现俩个方法来达到与实现externalizable接口的类
 * 相同的效果
 * private void writeObject(ObjectOutputStream stream) throws IOException {}
 * private void readObject(ObjectInputStream stream) throws IOException, ClassNotFoundException {}
 * @project Learn-develop
 * @package thinkinjava.chapter18.serializable.externalizable
 * @email wubin326@qq.com
 * @date 2018/10/22
 * Modification History:
 * Date              Author           Version              Description
 * ----------------------------------------------------------------------
 * 2018/10/22        wubin            0.0.1
 */
public class Blip5 implements Serializable {

    private int i;
    private String s;

    public Blip5() {
        System.out.println("Blips constructor");
    }

    public Blip5(int i, String s) {
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

    /**
     * 加入这两个方法后
     * 这个类等同于实现了externalizable
     * 如果不手动输出与读取数据，则会默认没有赋值
     * @param stream
     * @throws IOException
     */
    private void writeObject(ObjectOutputStream stream) throws IOException {}
    private void readObject(ObjectInputStream stream) throws IOException, ClassNotFoundException {}

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Blip5 blip5 = new Blip5(666, "wubin");
        System.out.println(blip5);

        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(MyConst.FileConst.FILEPATH_DESKTOP + "blip1.out"));

        System.out.println("saving data");
        objectOutputStream.writeObject(blip5);
        objectOutputStream.close();

        /**
         * 反序列化的时候只会执行默认构造方法
         */
        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(MyConst.FileConst.FILEPATH_DESKTOP + "blip1.out"));
        System.out.println("recover b4");
        blip5 = (Blip5) objectInputStream.readObject();
        System.out.println(blip5);
    }

}
/**
 * blip4(string,int)
 * Blip4{i=666, s='wubin'}
 * saving data
 * recover b4
 * Blip4{i=666, s='wubin'}
 * 结果显示不走构造方法
 */