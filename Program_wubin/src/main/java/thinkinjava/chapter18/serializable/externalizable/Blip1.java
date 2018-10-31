package thinkinjava.chapter18.serializable.externalizable;

import util.MyConst;

import java.io.*;

/**
 * @author wubin
 * @Description
 *
 * 序列化的控制
 * 实现externalizable这个接口的类
 * 进行反序列好的时候
 * 所有的普通默认构造器会被调用，然后再去调用
 * readExternal这个方法 不然会报错
 * （所以这里需要主要默认构造器的访问控制权限）
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
class Blip2 implements Externalizable{
    public Blip2() {
        System.out.println("Blip2 Constrouctor");
    }

    /**
     * 序列化的时候触发这个方法
     * @param out
     * @throws IOException
     */
    @Override
    public void writeExternal(ObjectOutput out) throws IOException {

        System.out.println("Blip2.writeExternal");
    }

    /**
     * 反序列化的时候触发这个方法
     * @param in
     * @throws IOException
     * @throws ClassNotFoundException
     */
    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {

        System.out.println("Blip2.readExternal");
    }
}

public class Blip1{

    public static void main(String[] args) throws IOException, ClassNotFoundException {

        System.out.println("Constroucting objects");
        Blip2 blip2 = new Blip2();
        Blip3 blip3 = new Blip3();

        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(MyConst.FileConst.FILEPATH_DESKTOP + "blip1"));

        System.out.println("saving data");
        objectOutputStream.writeObject(blip2);
        objectOutputStream.writeObject(blip3);
        objectOutputStream.close();

        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(MyConst.FileConst.FILEPATH_DESKTOP + "blip1"));
        System.out.println("recover b2");
        blip2 = (Blip2) objectInputStream.readObject();
        System.out.println("recover b3");
        blip3 = (Blip3) objectInputStream.readObject();

    }

}

class Blip3 implements Externalizable{
    public Blip3() {
        System.out.println("Blip3 Constrouctor");
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {

        System.out.println("Blip3.writeExternal");
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {

        System.out.println("Blip3.readExternal");
    }
}
