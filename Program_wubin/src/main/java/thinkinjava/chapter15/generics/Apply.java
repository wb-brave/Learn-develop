package thinkinjava.chapter15.generics;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;

/**
 * @author wubin
 * @Description
 * @project Learn-develop
 * @package thinkinjava.chapter15.generics
 * @email wubin326@qq.com
 * @date 2018/11/22
 * Modification History:
 * Date              Author           Version              Description
 * ----------------------------------------------------------------------
 * 2018/11/22        wubin            0.0.1
 */
public class Apply {
    public static <S extends Iterable<T>, T> void apply(S seq, Method m, Object... args) {
        for (T t : seq) {
            try {
                m.invoke(t, args);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
        }

    }
}

class Shape {
    public void rotate() {
        System.out.println(this + " rotate.");
    }

    public void resize(int newSize) {
        System.out.println(" to be newSize : " + newSize);
    }
}

class Square extends Shape {

}

class FilledList<T> extends ArrayList<T> {
    public FilledList(Class<? extends T> type, int size) {
        for (int i = 0; i < size; i++) {
            try {
                add(type.newInstance());
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
    }
}

class ApplyTest {
    public static void main(String[] args) {
        List<Shape> shapes = new ArrayList<>();
        List<Square> squares = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            shapes.add(new Shape());
            squares.add(new Square());
        }
        try {
            Apply.apply(shapes, Shape.class.getMethod("rotate"));
            Apply.apply(shapes, Shape.class.getMethod("resize", int.class), 6);

            Apply.apply(squares, Square.class.getMethod("rotate"));
            Apply.apply(squares, Square.class.getMethod("resize", int.class), 5);

            Apply.apply(new FilledList<Shape>(Square.class,2),Shape.class.getMethod("rotate"));
            Apply.apply(new FilledList<Shape>(Square.class,2),Square.class.getMethod("rotate"));

            SimpleQueue<Shape> shapesQ = new SimpleQueue<Shape>();
            for (int i=0;i<2;i++){
                shapesQ.add(new Shape());
                shapesQ.add(new Square());
            }
            Apply.apply(shapesQ,Shape.class.getMethod("rotate"));
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }
}

class SimpleQueue<T> implements Iterable<T>{

    private LinkedList<T> storage = new LinkedList<>();
    @Override
    public Iterator<T> iterator() {
        return storage.iterator();
    }
    public void get(){
        storage.poll();
    }

    public void add(T item){
        storage.offer(item);
    }
}