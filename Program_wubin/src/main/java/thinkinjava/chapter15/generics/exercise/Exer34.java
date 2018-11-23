package thinkinjava.chapter15.generics.exercise;

/**
 * @author wubin
 * @Description
 * @project Learn-develop
 * @package thinkinjava.chapter15.generics.exercise
 * @email wubin326@qq.com
 * @date 2018/11/21
 * Modification History:
 * Date              Author           Version              Description
 * ----------------------------------------------------------------------
 * 2018/11/21        wubin            0.0.1
 */
public abstract class Exer34<T extends Exer34<T>> {

    abstract T getT();

    void f(){
        System.out.println(getT().getClass().getSimpleName());
    }

    public static void main(String[] args) {
        Subclass subclass = new Subclass();
        subclass.f();
    }
}

class Subclass extends Exer34<Subclass>{
    @Override
    Subclass getT() {
        return this;
    }
}