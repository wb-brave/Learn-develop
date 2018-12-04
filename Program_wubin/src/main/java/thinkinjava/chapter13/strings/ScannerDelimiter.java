package thinkinjava.chapter13.strings;

import java.util.Scanner;

/**
 * @author wubin
 * @Description
 * @project Learn-develop
 * @package thinkinjava.chapter13.strings
 * @email wubin326@qq.com
 * @date 2018/12/04
 * Modification History:
 * Date              Author           Version              Description
 * ----------------------------------------------------------------------
 * 2018/12/04        wubin            0.0.1
 */
public class ScannerDelimiter {

    public static void main(String[] args) {
        final Scanner scanner = new Scanner("15,54,65,32,87,91,122,5");
        scanner.useDelimiter("\\s*,\\s*");
        while (scanner.hasNext()){
            System.out.println(scanner.next());
        }
    }
}
