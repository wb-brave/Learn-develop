package thinkinjava.chapter14.classobject;

/**
 * @author wubin
 * @Description
 * @project Learn-develop
 * @package thinkinjava.chapter5.classobject
 * @email wubin326@qq.com
 * @date 2018/11/01
 * Modification History:
 * Date              Author           Version              Description
 * ----------------------------------------------------------------------
 * 2018/11/01        wubin            0.0.1
 */
class Candy {
    static { System.out.println("Loading Candy"); }
}

class Gum {
    static { System.out.println("Loading Gum"); }
}

class Cookie {
    static { System.out.println("Loading Cookie"); }
}

public class SweetShop {
    public static void main(String[] args) {
        System.out.println("inside main");
        new Candy();
        System.out.println("After creating Candy");
        try {
            Class.forName("thinkinjava.chapter14.classobject.Gum");
        } catch(ClassNotFoundException e) {
            System.out.println("Couldn't find Gum");
        }
        /**
         * static成员只会在类第一次被加载时初始化
         */
        new Gum();
        System.out.println("After Class.forName(\"Gum\")");
        new Cookie();
        System.out.println("After creating Cookie");
    }
}
