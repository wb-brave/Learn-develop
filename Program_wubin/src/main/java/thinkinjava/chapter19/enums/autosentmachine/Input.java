package thinkinjava.chapter19.enums.autosentmachine;

import Thread.chapter04.condition123.Run;
import thinkinjava.chapter19.enums.util.Enums;

import java.util.Random;

/**
 * @author wubin
 * @Description
 * @project Learn-develop
 * @package thinkinjava.chapter19.enums.autosentmachine
 * @email wubin326@qq.com
 * @date 2018/10/25
 * Modification History:
 * Date              Author           Version              Description
 * ----------------------------------------------------------------------
 * 2018/10/25        wubin            0.0.1
 */
public enum Input {
    NICKEL(5), DIME(10), QUARTER(25), DOLLAR(100), TOOTHPASTE(200), CHIPS(75), SODA(100), SOAP(50),

    ABORT_TRANSACTION(200) {
        public int amount() {
            throw new RuntimeException("abort.amount()");
        }
    },
    STOP {
        public int amount() {
            throw new RuntimeException("SHUT_DOWN.AMOUNT()");
        }
    };

    int value;

    Input(int value) {
        this.value = value;
    }

    Input() {
    }

    int amount() {
        return value;
    }

    static Random rand = new Random(66);

    public static Input randomSelection() {
        return values()[rand.nextInt(values().length - 1)];
    }
}
