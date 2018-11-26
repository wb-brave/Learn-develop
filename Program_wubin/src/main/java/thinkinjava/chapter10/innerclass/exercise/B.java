package thinkinjava.chapter10.innerclass.exercise;

import java.util.Objects;

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
public class B {
    private U[] us;
    private static int count = 0;
    private final int index = count++;

    public B(int size) {
        this.us = new U[size];
    }

    public void addU(U u) {
        us[index] = u;
    }

    public void remove(int index) {
        us[index] = null;
    }

    public void forEach() {
        for (int i = 0; i < us.length; i++) {
            if (Objects.nonNull(us[i])){
                System.out.println(us[i].getClass() + "[" + i + "]");
            }
        }
    }

    public static void main(String[] args) {
        A[] as = new A[5];
        B b = new B(5);
        for (int i = 0; i < 5; i++) {
            as[i] = new A();
            b.us[i] = as[i].D();
        }
        b.forEach();
        b.remove(3);
        b.forEach();

    }
}
