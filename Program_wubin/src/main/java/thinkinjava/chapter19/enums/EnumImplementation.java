package thinkinjava.chapter19.enums;

import java.util.Random;

/**
 * @author wubin
 * @Description enum继承与Enum类
 * 所以它不可以在继承其他的类
 * 但允许实现一个或多个接口
 * @project Learn-develop
 * @package thinkinjava.chapter19.enums
 * @email wubin326@qq.com
 * @date 2018/10/24
 * Modification History:
 * Date              Author           Version              Description
 * ----------------------------------------------------------------------
 * 2018/10/24        wubin            0.0.1
 */
public class EnumImplementation {

    public static <W> void printNext(CartoonCharacter cartoonCharacter) {
        System.out.println(cartoonCharacter.next());
    }

    public static void main(String[] args) {
        CartoonCharacter cartoonCharacter = CartoonCharacter.BOB;
        for (int i = 0; i < 10; i++) {
            printNext(cartoonCharacter);
        }
    }

}

enum CartoonCharacter {
    SLAPPY, SPANKY, PUNCHY, SILLY, BOUNCY, NUTTY, BOB;
    private static Random random = new Random(47);

    public static CartoonCharacter next() {
        return values()[random.nextInt(values().length)];
    }
}
