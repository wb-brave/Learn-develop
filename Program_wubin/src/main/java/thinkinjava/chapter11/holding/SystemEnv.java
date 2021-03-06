package thinkinjava.chapter11.holding;

import java.util.Iterator;
import java.util.Map;

/**
 * @author wubin
 * @Description
 * @project Learn-develop
 * @package thinkinjava.chapter11.holding
 * @email wubin326@qq.com
 * @date 2018/12/28
 * Modification History:
 * Date              Author           Version              Description
 * ----------------------------------------------------------------------
 * 2018/12/28        wubin            0.0.1
 */
public class SystemEnv {

    public static void main(String[] args) {
        Iterator<Map.Entry<String, String>> iterator = System.getenv().entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, String> next = iterator.next();
            System.out.println(next.getKey() + " : " + next.getValue());
        }
    }
}
