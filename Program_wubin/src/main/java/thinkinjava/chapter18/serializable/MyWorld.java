package thinkinjava.chapter18.serializable;

import util.MyConst;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author wubin
 * @Description
 *
 * 持久性
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
public class MyWorld {

    private static final String filename = MyConst.FileConst.FILEPATH_DESKTOP + "blip1.out";

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        House house = new House();
        ArrayList<Animal> animals = new ArrayList<>();
        animals.add(new Animal("zhangliang",house));
        animals.add(new Animal("daqiao",house));
        animals.add(new Animal("zahngyun",house));
        animals.add(new Animal("wangyunzhi",house));
        System.out.println("animals: " + animals);

        ByteArrayOutputStream baos1 = new ByteArrayOutputStream();
        ObjectOutputStream outputStream = new ObjectOutputStream(baos1);
        /**
         * 同一个对象输入到同一个序列化流
         * 即使写入多次，反序列化时都是一样的
         */
        outputStream.writeObject(animals);
        // 输出俩次
        outputStream.writeObject(animals);

        ByteArrayOutputStream baos2 = new ByteArrayOutputStream();
        ObjectOutputStream outputStream1 = new ObjectOutputStream(baos2);
        outputStream1.writeObject(animals);

        ByteArrayInputStream bais = new ByteArrayInputStream(baos1.toByteArray());
        ObjectInputStream inputStream = new ObjectInputStream(bais);

        ByteArrayInputStream bais1 = new ByteArrayInputStream(baos2.toByteArray());
        ObjectInputStream inputStream1 = new ObjectInputStream(bais1);

        List l = (List) inputStream.readObject();
        List l1 = (List) inputStream.readObject();
        List l2 = (List) inputStream1.readObject();

        System.out.println("animals: " + l);
        System.out.println("animals1: " + l1);
        System.out.println("animals2: " + l2);
    }
}

class House implements Serializable{}

class Animal implements Serializable{
    private String name;
    private House preHouse;

    public Animal(String name, House preHouse) {
        this.name = name;
        this.preHouse = preHouse;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "name='" + name + '\'' +
                ", preHouse=" + preHouse +
                '}';
    }
}