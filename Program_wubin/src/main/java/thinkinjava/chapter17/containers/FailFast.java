package thinkinjava.chapter17.containers;

import java.util.*;

/**
 * @author wubin
 * @Description
 * @project Learn-develop
 * @package thinkinjava.chapter17.containers
 * @email wubin326@qq.com
 * @date 2018/12/28
 * Modification History:
 * Date              Author           Version              Description
 * ----------------------------------------------------------------------
 * 2018/12/28        wubin            0.0.1
 */
public class FailFast {

    public static void main(String[] args) {
        Collection<String> c = new ArrayList<>();
        Iterator<String> it = c.iterator();
        c.add("An object");

        /**
         * 为什么会出现快速错误的异常
         * 因为容器在获取迭代器之后
         * 容器的其他部分操作修改了容器的内容
         * 导致容器的状态不一致
         */
        try {
            String s = it.next();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
