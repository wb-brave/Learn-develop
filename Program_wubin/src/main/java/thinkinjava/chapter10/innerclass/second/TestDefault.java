package thinkinjava.chapter10.innerclass.second;

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
public class TestDefault extends ContainInner{

    void g() {
        f();
    }

    public static void main(String[] args) {
        ContainInner containInner = new ContainInner();
        containInner.f();
    }
}
