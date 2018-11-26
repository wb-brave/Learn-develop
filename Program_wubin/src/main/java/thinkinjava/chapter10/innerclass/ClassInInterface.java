package thinkinjava.chapter10.innerclass;

/**
 * @author wubin
 * @Description
 * @project Learn-develop
 * @package thinkinjava.chapter10.innerclass
 * @email wubin326@qq.com
 * @date 2018/11/23
 * Modification History:
 * Date              Author           Version              Description
 * ----------------------------------------------------------------------
 * 2018/11/23        wubin            0.0.1
 */
public interface ClassInInterface {

    void f();

    /**
     * 可以在接口中定义嵌套类(就是static内部类)
     * 默认是public static 修饰的
     */
    class test{
        public static void main(String[] args) {
            System.out.println("oh my god, i am in a interface!!!!" + test.class.getName());
        }
    }

}
