package util.sets;

import java.util.AbstractList;

/**
 * @author wubin
 * @Description 可以具有任意尺寸的list
 * @project Learn-develop
 * @package util.sets
 * @email wubin326@qq.com
 * @date 2018/12/11
 * Modification History:
 * Date              Author           Version              Description
 * ----------------------------------------------------------------------
 * 2018/12/11        wubin            0.0.1
 */
public class CountingIntegerList extends AbstractList<Integer> {

    private int size;

    public CountingIntegerList(int size) {
        // size > 0 ? this.size = size : 0; 错误的写法
        this.size = size > 0 ? size : 0;
    }

    @Override
    public Integer get(int index) {
        /**
         * 根据下标直接返回值
         */
        return Integer.valueOf(index);
    }

    @Override
    public int size() {
        return this.size;
    }

    public static void main(String[] args) {
        System.out.println(new CountingIntegerList(20));
    }
}
