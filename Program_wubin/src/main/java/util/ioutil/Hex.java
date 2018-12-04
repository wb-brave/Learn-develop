package util.ioutil;

/**
 * @author wubin
 * @Description 将字节数组转换为十六进制
 * @project Learn-develop
 * @package util.ioutil
 * @email wubin326@qq.com
 * @date 2018/12/03
 * Modification History:
 * Date              Author           Version              Description
 * ----------------------------------------------------------------------
 * 2018/12/03        wubin            0.0.1
 */
public class Hex {

    public static String format(byte[] bytes) {
        final StringBuilder result = new StringBuilder();
        int n = 0;
        for (byte aByte : bytes) {
            if (n % 16 == 0) {
                result.append(String.format("%05X: ", n));
            }
            result.append(String.format("%02X: ", aByte));
            n++;
            if (n % 16 == 0) {
                result.append("\n");
            }
        }
        result.append("\n");
        return result.toString();
    }
}
