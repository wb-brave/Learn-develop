package thinkinjava.chapter10.innerclass.thrid;

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
public class PrivateClass {

    private int i;

    private int getI() {
        return i;
    }

    class Innerclass1 {
        private String name = "wubin";
        public boolean accessI() {
            return i != 0;
        }

        public int setI() {
            return i = 666;
        }

        public int f(){
            return getI();
        }
    }

    public void createInner(){
        Innerclass1 innerclass1 = new Innerclass1();
        innerclass1.setI();
    }
}
