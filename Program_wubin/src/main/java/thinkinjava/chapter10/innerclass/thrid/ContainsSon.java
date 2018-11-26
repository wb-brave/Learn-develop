package thinkinjava.chapter10.innerclass.thrid;

import thinkinjava.chapter10.innerclass.Parcel11;
import thinkinjava.chapter10.innerclass.first.TestInner;
import thinkinjava.chapter10.innerclass.second.ContainInner;

/**
 * @author wubin
 * @Description
 * @project Learn-develop
 * @package thinkinjava.chapter10.innerclass.thrid
 * @email wubin326@qq.com
 * @date 2018/11/23
 * Modification History:
 * Date              Author           Version              Description
 * ----------------------------------------------------------------------
 * 2018/11/23        wubin            0.0.1
 */
public class ContainsSon extends ContainInner {

    // public TestInner f(){
    //     return getInner();
    // }
    TestInner g(){
        /**
         * 这个其实还是根据内部类的构造方法来进行实例化对象
         * 如果父类中的protected内部类没有 显示的指明构造器是public
         * 下面的语句就回有错误
         * 没有权限访问
         */
        return this.new InnerImpl();
    }

    public static void main(String[] args) {
    }
}
