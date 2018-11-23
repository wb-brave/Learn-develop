package thinkinjava.chapter14.initialize;

/**
 * @author wubin
 * @Description 初始化顺序
 * @project Learn-develop
 * @package thinkinjava.chapter5.initialize
 * @email wubin326@qq.com
 * @date 2018/09/26
 */
public class SortedInitialize {

    public static void main(String args[]) {
        House house = new House();
        house.f();
    }
}

class Window {
    Window(int marker) {
        System.out.println("window " + marker + ";");
    }
}

class House {
    Window w1 = new Window(1);

    House() {
        System.out.println("house " + ";");
        w3 = new Window(33);
    }

    Window w2 = new Window(2);

    void f() {
        System.out.println("f()");
    }

    Window w3 = new Window(3);
}
/* 输出结果
window 1;
window 2;
window 3;
house ;
window 33;
f()
=======================结果解释
在类的内部，无论变量定义在什么位置，他们仍旧会在 任何 方法（包括构造器）被调用之前初始化
 */