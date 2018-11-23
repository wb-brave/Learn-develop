package thinkinjava.chapter15.generics.arrays;

/**
 * @author wubin
 * @Description 使用泛型数组出现的错误情况，不应该在创建数组的时候就使用强制转换为泛型（array = (T[])new Object[size];）
 * ，而是在真正使用的时候在进行强制转换具体看GenericArray1的演进,但是在数组转换为泛型的时候还是会出现错误
 * @project Learn-develop
 * @package thinkinjava.chapter15.generics
 * @email wubin326@qq.com
 * @date 2018/11/20
 * Modification History:
 * Date              Author           Version              Description
 * ----------------------------------------------------------------------
 * 2018/11/20        wubin            0.0.1
 */
public class GenericArray<T> {

    private T[] array;

    public GenericArray(int size) {
        array = (T[]) new Object[size];
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
        GenericArray<Integer> genericArray = new GenericArray<>(10);
        for (int i = 0; i < 10; i++) {
            genericArray.put(i,i);
        }
        for (int i = 0; i < 10; i++) {
            System.out.print(" " +  genericArray.get(i));
        }
        //<editor-fold desc="这样使用会出现默认强转类型的异常，因为擦除的特性，使用泛型时，真正的类型是object">
        Integer[] rep = genericArray.rep();
        //</editor-fold>
        for (Integer integer : rep) {
            System.out.printf(" " + integer);
        }

    }
}
