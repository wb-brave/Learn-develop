package thinkinjava.chapter15.generics.arrays;

/**
 * @author wubin
 * @Description 虽然在创建数组的时候使用object的类型，在使用的时候再进行强制转换，但是仍然存在问题
 * 我们需要使用类型标记来解决这个问题，使用Arrays.newInstance来创建数组
 * @project Learn-develop
 * @package thinkinjava.chapter15.generics
 * @email wubin326@qq.com
 * @date 2018/11/20
 * Modification History:
 * Date              Author           Version              Description
 * ----------------------------------------------------------------------
 * 2018/11/20        wubin            0.0.1
 */
public class GenericArray1<T> {

    private Object[] array;

    public GenericArray1(int size) {
        array = new Object[size];
    }

    public void put(int index, T item) {
        array[index] = item;
    }

    public T get(int index) {
        return (T) array[index];
    }

    public T[] rep() {
        return (T[]) array;
    }

    public static void main(String[] args) {
        GenericArray1<Integer> genericArray = new GenericArray1<>(10);
        for (int i = 0; i < 10; i++) {
            genericArray.put(i, i);
        }
        for (int i = 0; i < 10; i++) {
            System.out.print(" " + genericArray.get(i));
        }
        //<editor-fold desc="这样使用会出现默认强转类型的异常，因为擦除的特性，使用泛型时，真正的类型是object">
        Integer[] rep = genericArray.rep();
        //</editor-fold>

    }
}
