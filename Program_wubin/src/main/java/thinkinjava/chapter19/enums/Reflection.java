package thinkinjava.chapter19.enums;

import thinkinjava.chapter18.stream.OSExecute;

import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.Set;
import java.util.TreeSet;

/**
 * @author wubin
 * @Description
 * @project Learn-develop
 * @package thinkinjava.chapter19.enums
 * @email wubin326@qq.com
 * @date 2018/10/23
 * Modification History:
 * Date              Author           Version              Description
 * ----------------------------------------------------------------------
 * 2018/10/23        wubin            0.0.1
 */
public class Reflection {

    public static Set<String> analyze(Class<?> enumClass) {
        System.out.println("-----analyzing " + enumClass + " -----");
        System.out.println("interface");
        for (Type t : enumClass.getGenericInterfaces()) {
            System.out.println(t);
        }

        System.out.println("Base: " + enumClass.getSuperclass());
        
        System.out.println("method: ");
        TreeSet<String> set = new TreeSet<>();
        for (Method method: enumClass.getMethods()
             ) {
            set.add(method.getName());
        }

        System.out.println(set);
        return set;
    }

    public static void main(String[] args) {
        Set<String> enumMethods = analyze(Enum.class);
        Set<String> exploreMethods = analyze(Explore.class);
        System.out.println("Explore containsAll(Enum)? "
                +exploreMethods.containsAll(enumMethods));
        System.out.println("Explore removeAll(Enum)");
        exploreMethods.removeAll(enumMethods);
        System.out.println(exploreMethods);
        OSExecute.command("javap /Users/wufan/wubin/github/Learn-develop/Program_wubin/target/classes/thinkinjava/chapter19/enums/Explore.class");
    }
}

enum Explore{
    HERE,THERE
}