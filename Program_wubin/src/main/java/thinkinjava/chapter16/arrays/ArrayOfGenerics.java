package thinkinjava.chapter16.arrays;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wubin
 * @Description 创建非泛型数组然后对他转型
 * @project Learn-develop
 * @package thinkinjava.chapter16.arrays
 * @email wubin326@qq.com
 * @date 2018/12/06
 * Modification History:
 * Date              Author           Version              Description
 * ----------------------------------------------------------------------
 * 2018/12/06        wubin            0.0.1
 */
public class ArrayOfGenerics {

    public static void main(String[] args) {
        /**
         * 因为擦除的原因不能直接在new 数组的时候进行泛华
         * 因为数组是在编译的时候就需要确定数据类型的
         * 但是擦除将类型变成object，会有冲突
         * final ArrayList<String>[] arrayLists = new ArrayList<String>[10];
         *
         * 但是如果只是定义一个引用，这又是允许的
         */
        List<String>[] ls;
        final List[] lists = new List[10];
        ls = lists;
        ls[0] = new ArrayList<>();
        //因为已经确定了是什么类型的集合
        // ls[1] = new ArrayList<Integer>();

        Object[] oa = ls;
        oa[0] = new ArrayList<Integer>();

        final List<BerylliumSphere>[] lists1 = new List[10];
        for (int i = 0; i < lists1.length; i++){
            lists1[i] = new ArrayList<BerylliumSphere>();
        }
    }

}

