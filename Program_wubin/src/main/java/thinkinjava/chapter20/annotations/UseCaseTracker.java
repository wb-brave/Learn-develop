package thinkinjava.chapter20.annotations;

import java.lang.reflect.Method;
import java.util.*;

/**
 * @author wubin
 * @Description
 * @project Learn-develop
 * @package thinkinjava.chapter20.annotations
 * @email wubin326@qq.com
 * @date 2018/12/29
 * Modification History:
 * Date              Author           Version              Description
 * ----------------------------------------------------------------------
 * 2018/12/29        wubin            0.0.1
 */
public class UseCaseTracker {

    public static void trackUseCase(List<Integer> useCases, Class<?> cl) {
        for (Method method : cl.getDeclaredMethods()) {
            UseCase uc = method.getAnnotation(UseCase.class);
            if (uc != null) {
                System.out.println("Found use case: " + uc.id() + " " + uc.desc());
                useCases.remove(new Integer(uc.id()));
            }
        }
        for (Integer useCase : useCases) {
            System.out.println("warning missing use case-" + useCase);
        }
    }

    public static void main(String[] args) {
        ArrayList<Integer> integers = new ArrayList<>();
        Collections.addAll(integers,47,48,49,50);
        trackUseCase(integers,PasswordUtils.class);
    }
}
