package thinkinjava.chapter15.generics.arrays;

import java.lang.reflect.Array;

/**
 * @author wubin
 * @Description 使用类型标签进行限定
 * @project Learn-develop
 * @package thinkinjava.chapter15.generics
 * @email wubin326@qq.com
 * @date 2018/11/20
 * Modification History:
 * Date              Author           Version              Description
 * ----------------------------------------------------------------------
 * 2018/11/20        wubin            0.0.1
 */
public class GenericArrayWithTypeToken<T> {

    private T[] array;

    public GenericArrayWithTypeToken(Class<T> type, int size) {
        array = (T[]) Array.newInstance(type, size);
    }

    public void put(int index, T item) {
        array[index] = item;
    }

    public T get(int index) {
        return array[index];
    }

    public T[] rep() {
        return array;
    }

    public static void main(String[] args) {
        GenericArrayWithTypeToken<Integer> array = new GenericArrayWithTypeToken<Integer>(Integer.class, 10);

        for (int i=0;i<10;i++){
            array.put(i,i);
        }

        for (Integer integer : array.rep()) {
            System.out.print(" " + integer);
        }

    }
}
