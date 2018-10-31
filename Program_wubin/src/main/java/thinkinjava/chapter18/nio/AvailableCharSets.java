package thinkinjava.chapter18.nio;

import io.netty.util.internal.SocketUtils;

import java.nio.charset.Charset;
import java.util.*;

/**
 * @author wubin
 * @Description
 * @project Learn-develop
 * @package thinkinjava.chapter18.nio
 * @email wubin326@qq.com
 * @date 2018/10/19
 * Modification History:
 * Date              Author           Version              Description
 * ----------------------------------------------------------------------
 * 2018/10/19        wubin            0.0.1
 */
public class AvailableCharSets {

    public static void main(String[] args) {
        /**
         * 获取到所有的可用编码格式
         */
        SortedMap<String, Charset> sortedMap = Charset.availableCharsets();

        Iterator<String> iterator = sortedMap.keySet().iterator();

        while (iterator.hasNext()) {
            String csName = iterator.next();
            System.out.print(csName);
            Iterator<String> alias = sortedMap.get(csName).aliases().iterator();
            if (alias.hasNext()) {
                System.out.print(": ");
            }
            while (alias.hasNext()) {
                System.out.print(alias.next());
                if (alias.hasNext()) {
                    System.out.print(". ");
                }
            }
            System.out.println();
        }
    }
}
