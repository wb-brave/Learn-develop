package thinkinjava.chapter19.enums.enumofenum.enumset;

import java.util.EnumSet;
import static thinkinjava.chapter19.enums.enumofenum.enumset.AlarmPoints.*;

/**
 * @author wubin
 * @Description
 * @project Learn-develop
 * @package thinkinjava.chapter19.enums.enumofenum.enumset
 * @email wubin326@qq.com
 * @date 2018/10/24
 * Modification History:
 * Date              Author           Version              Description
 * ----------------------------------------------------------------------
 * 2018/10/24        wubin            0.0.1
 */
public class EnumSets {

    public static void main(String[] args) {
        EnumSet<AlarmPoints> alarmPoints = EnumSet.noneOf(AlarmPoints.class);
        alarmPoints.add(BATHROOM);
        System.out.println(alarmPoints);

        alarmPoints.addAll(EnumSet.of(STAIR1,STAIR2,KITCHEN));
        System.out.println(alarmPoints);

        /**
         * 将AlarmPoints所有的枚举实例放入enumset中
         * 并返回
         */
        alarmPoints = EnumSet.allOf(AlarmPoints.class);
        alarmPoints.removeAll(EnumSet.of(STAIR1,STAIR2,KITCHEN));
        System.out.println(alarmPoints);

        /**
         * 将AlarmPoints指定的枚举实例放入enumset中
         * 并返回
         */
        alarmPoints.removeAll(EnumSet.of(OFFICE1,OFFICE4));
        System.out.println(alarmPoints);

        /**
         * 将枚举实例alarmPoints中已包含的枚举除外
         * 并将未包含的相反的枚举放入alarmPoints
         */
        alarmPoints = EnumSet.complementOf(alarmPoints);
        System.out.println(alarmPoints);
    }
}
