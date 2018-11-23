package thinkinjava.chapter15.generics.chachu;

/**
 * @author wubin
 * @Description
 * @project Learn-develop
 * @package thinkinjava.chapter15.generics.chachu
 * @email wubin326@qq.com
 * @date 2018/11/19
 * Modification History:
 * Date              Author           Version              Description
 * ----------------------------------------------------------------------
 * 2018/11/19        wubin            0.0.1
 */
public class Manipulation {

    public static void main(String[] args) {
        HasF hasF = new HasF();
        Manipulator<HasF> hasFManipulator = new Manipulator<HasF>(hasF);
        hasFManipulator.manipulate();
    }
}

class Manipulator<T extends HasF>{
    private T obj;

    public Manipulator(T obj) {
        this.obj = obj;
    }

    public void manipulate(){
        /**
         *  <T> 因为java的擦除特性，这样是编译不通过的，jvm并不知道T的类型
         *  <T extends [Object]> 需要像这样指定一个类的边界值
         */
        obj.f();
    }
}

