package thinkinjava.chapter15.generics;

import thinkinjava.chapter15.generics.coffee.*;
import thinkinjava.chapter19.enums.enumofenum.Food;
import util.generator.Generator;

import java.util.ArrayList;
import java.util.Collection;

/**
 * @author wubin
 * @Description 使用适配器模式来仿真潜在类型机制
 * 使用接口是完成适配的关键，因为接口使用泛型，可以保持参数类型的一致性
 * @project Learn-develop
 * @package thinkinjava.chapter15.generics
 * @email wubin326@qq.com
 * @date 2018/11/22
 * Modification History:
 * Date              Author           Version              Description
 * ----------------------------------------------------------------------
 * 2018/11/22        wubin            0.0.1
 */
public class Fill2 {
    /**
     * 指定类的填充
     *
     * @param addable
     * @param classToken
     * @param size
     * @param <T>
     */
    public static <T> void fill(Addable<T> addable, Class<? extends T> classToken, int size) {
        for (int i = 0; i < size; i++) {
            try {
                addable.add(classToken.newInstance());
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 使用迭代接口生成的类
     *
     * @param addable
     * @param classToken
     * @param size
     * @param <T>
     */
    public static <T> void fill(Addable<T> addable, Generator<T> generator, int size) {
        for (int i = 0; i < size; i++) {
            addable.add(generator.next());
        }
    }
}

interface Addable<T> {
    void add(T t);
}

//自动捕捉类型
class Adapter {
    public static <T> Addable<T> collectionAdapter(Collection<T> collection) {
        return new AddableCollectionAdapter<>(collection);
    }
}

//为了适配一个基本类型，必须使用组合。
//使用组合来创建任何可添加的集合：
class AddableCollectionAdapter<T> implements Addable<T> {

    private Collection<T> collection;

    public AddableCollectionAdapter(Collection<T> collection) {
        this.collection = collection;
    }

    @Override
    public void add(T t) {
        collection.add(t);
    }
}

class AddableSimpleQueue<T> extends SimpleQueue<T> implements Addable<T> {
    @Override
    public void add(T item) {
        super.add(item);
    }
}

class Fill2Test {

    public static void main(String[] args) {
        ArrayList<Coffee> coffees = new ArrayList<>();
        //适配一个集合类
        Fill2.fill(new AddableCollectionAdapter<Coffee>(coffees),Coffee.class,3);

        //这样使用可以不用显示的将泛华类型显示的指定，有了一层包装，使代码更加优雅
        Fill2.fill(Adapter.collectionAdapter(coffees), Latte.class,2);
        for (Coffee coffee : coffees) {
            System.out.println(coffee);
        }
        System.out.println("==========================");
        //使用适配的类 具体类型
        AddableSimpleQueue<Coffee> simpleQueue = new AddableSimpleQueue<>();
        Fill2.fill(simpleQueue, Mocha.class,2);
        Fill2.fill(simpleQueue, Cappuccino.class,1);
        for (Coffee coffee : simpleQueue) {
            System.out.println(coffee);
        }
    }
}