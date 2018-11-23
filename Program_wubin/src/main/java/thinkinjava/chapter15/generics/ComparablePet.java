package thinkinjava.chapter15.generics;

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
public class ComparablePet implements Comparable<ComparablePet>{

    @Override
    public int compareTo(ComparablePet o) {
        return 0;
    }
}

// class Cat extends ComparablePet implements Comparable<Cat>{ }