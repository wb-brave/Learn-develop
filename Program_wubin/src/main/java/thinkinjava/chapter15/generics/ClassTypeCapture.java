package thinkinjava.chapter15.generics;

import java.util.Map;
import java.util.Objects;

/**
 * @author wubin
 * @Description
 * @project Learn-develop
 * @package thinkinjava.chapter15.generics
 * @email wubin326@qq.com
 * @date 2018/11/19
 * Modification History:
 * Date              Author           Version              Description
 * ----------------------------------------------------------------------
 * 2018/11/19        wubin            0.0.1
 */
public class ClassTypeCapture<T> {

    private Class<T> kind;
    private Map<String, Class<?>> map;

    /**
     * 需要显示的将类型信息传进来，才能避免因为泛型擦除而出现空指针的问题
     *
     * @param kind
     */
    public ClassTypeCapture(Class<T> kind) {
        this.kind = kind;
    }

    public ClassTypeCapture(Class<T> kind, Map<String, Class<?>> map) {
        this.kind = kind;
        this.map = map;
    }

    // public ClassTypeCapture() {
    // }

    public void addType(String typename, Class<T> kind) {
        map.put(typename, kind);
    }

    public Object createNew(String typename) throws IllegalAccessException, InstantiationException {
        if (Objects.nonNull(typename)) {
            return map.containsKey(typename) ? map.get(typename).newInstance() : null;
        }else {
            return null;
        }
    }

    public boolean f(Object arg) {
        return kind.isInstance(arg);
    }

    public static void main(String[] args) {
        ClassTypeCapture<Building> capture = new ClassTypeCapture<>(Building.class);
        // ClassTypeCapture<Building> capture = new ClassTypeCapture<>();
        System.out.println(capture.f(new Building()));
        System.out.println(capture.f(new House()));

        ClassTypeCapture<House> capture1 = new ClassTypeCapture<>(House.class);
        // ClassTypeCapture<House> capture1 = new ClassTypeCapture<>();
        System.out.println(capture1.f(new Building()));
        System.out.println(capture1.f(new House()));

        
        System.out.println("==========================");
    }
}

class Building {
}

class House extends Building {
}
