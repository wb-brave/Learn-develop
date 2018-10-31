package thinkinjava.chapter19.enums.enumofenum.enumsmap;

import thinkinjava.chapter19.enums.enumofenum.enumset.AlarmPoints;

import static thinkinjava.chapter19.enums.enumofenum.enumset.AlarmPoints.*;

import java.util.EnumMap;
import java.util.Map;

/**
 * @author wubin
 * @Description 使用了命令设计模式（需要一个只有一个方法的接口，然后子类实现这个方法产生不同的行为）
 * enummap中的键值必须来自于同一个enum 在new的时候会存放一个keytype；之后没次存放值得时候都回去trycheck
 * @project Learn-develop
 * @package thinkinjava.chapter19.enums.enumofenum.enumsmap
 * @email wubin326@qq.com
 * @date 2018/10/24
 * Modification History:
 * Date              Author           Version              Description
 * ----------------------------------------------------------------------
 * 2018/10/24        wubin            0.0.1
 */
public class EnumMaps {

    public static void main(String[] args) {
        EnumMap<AlarmPoints, Command> enumMap = new EnumMap<>(AlarmPoints.class);
        enumMap.put(KITCHEN, new Command() {
            @Override
            public void action() {
                System.out.println("kitchen fired!!!");
            }
        });

        enumMap.put(BATHROOM, new Command() {
            @Override
            public void action() {
                System.out.println("bathroom alert!!!");
            }
        });

        for (Map.Entry<AlarmPoints, Command> entry : enumMap.entrySet()) {
            System.out.print(entry.getKey() + ": ");
            entry.getValue().action();
        }
        try {
            enumMap.get(UTILITY).action();
        } catch (Exception e) {
            System.out.println(e);
        }

    }
}

interface Command {
    void action();
}
