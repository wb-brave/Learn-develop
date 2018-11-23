package thinkinjava.chapter15.generics;

import com.sun.javafx.css.Size;

/**
 * @author wubin
 * @Description
 * @project Learn-develop
 * @package thinkinjava.chapter15.generics
 * @email wubin326@qq.com
 * @date 2018/11/21
 * Modification History:
 * Date              Author           Version              Description
 * ----------------------------------------------------------------------
 * 2018/11/21        wubin            0.0.1
 */
public class GenericCast {

    public static final int SIZE = 10;

    public static void main(String[] args) {
        FixedSizeStack<String> sizeStack = new FixedSizeStack<>(SIZE);
        String[] strings = "A,B,C,D,E,F,G,H,I,J".split(",");
        for (String s : strings) {
            sizeStack.push(s);
        }
        for (int i = 0; i < SIZE; i++) {
            System.out.print(sizeStack.pop() + " ");
        }
    }
}

class FixedSizeStack<T> {
    private int index = 0;
    private Object[] storage;

    public FixedSizeStack(int index) {
        storage = new Object[index];
    }

    public void push(T item) {
        storage[index++] = item;
    }

    public T pop() {
        /**
         * 擦除的效果来看其实就是Object对Object的强转
         */
        return (T) storage[--index];
    }
}
