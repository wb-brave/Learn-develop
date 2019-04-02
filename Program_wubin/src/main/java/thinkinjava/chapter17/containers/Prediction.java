package thinkinjava.chapter17.containers;

import java.util.Random;

/**
 * @author wubin
 * @Description
 * @project Learn-develop
 * @package thinkinjava.chapter17.containers
 * @email wubin326@qq.com
 * @date 2018/12/17
 * Modification History:
 * Date              Author           Version              Description
 * ----------------------------------------------------------------------
 * 2018/12/17        wubin            0.0.1
 */
public class Prediction {

    private static Random rand = new Random(47);
    private boolean shadow = rand.nextDouble() > 0.5;

    @Override
    public String toString() {
        if (shadow){
            return "Six more weeks of winter";
        }
        return "Early spring";
    }
}
