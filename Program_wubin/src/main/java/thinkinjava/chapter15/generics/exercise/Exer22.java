package thinkinjava.chapter15.generics.exercise;

/**
 * @author wubin
 * @Description
 * @project Learn-develop
 * @package thinkinjava.chapter15.generics.exercise
 * @email wubin326@qq.com
 * @date 2018/11/19
 * Modification History:
 * Date              Author           Version              Description
 * ----------------------------------------------------------------------
 * 2018/11/19        wubin            0.0.1
 */
public class Exer22 {

    public static Object create(Class<?> c) throws IllegalAccessException, InstantiationException {
        return c.newInstance();
    }

    public static void main(String[] args) throws InstantiationException, IllegalAccessException {
        create(TestCapture.class);
    }
}

class TestCapture{
    private int id = 1;

    public TestCapture() {
        System.out.println("====");
    }

    public TestCapture(int id) {
        this.id = id;
    }
}
