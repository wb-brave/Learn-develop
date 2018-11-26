package thinkinjava.chapter10.innerclass.second;

import thinkinjava.chapter10.innerclass.first.TestInner;

/**
 * @author wubin
 * @Description
 * @project Learn-develop
 * @package thinkinjava.chapter10.innerclass.second
 * @email wubin326@qq.com
 * @date 2018/11/23
 * Modification History:
 * Date              Author           Version              Description
 * ----------------------------------------------------------------------
 * 2018/11/23        wubin            0.0.1
 */
public class ContainInner {

    protected class InnerImpl implements TestInner{
        public InnerImpl() {
        }

        @Override
        public int value() {
            return 666;
        }

        @Override
        public TestInner inner() {
            return null;
        }
    }

    public InnerImpl getInner(){
        return new InnerImpl();
    }

    /**
     * default
     * 只能是他的同一个包下的类能访问
     */
    void f(){
        System.out.println("sadasdasd");
    }
}
