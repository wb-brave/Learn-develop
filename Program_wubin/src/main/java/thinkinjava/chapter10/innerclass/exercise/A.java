package thinkinjava.chapter10.innerclass.exercise;

/**
 * @author wubin
 * @Description
 * @project Learn-develop
 * @package thinkinjava.chapter10.innerclass.exercise
 * @email wubin326@qq.com
 * @date 2018/11/23
 * Modification History:
 * Date              Author           Version              Description
 * ----------------------------------------------------------------------
 * 2018/11/23        wubin            0.0.1
 */
public class A {

    public U D(){
        return new U() {
            @Override
            public void a() {

            }

            @Override
            public void b() {

            }

            @Override
            public void c() {

            }
        };
    }

}
