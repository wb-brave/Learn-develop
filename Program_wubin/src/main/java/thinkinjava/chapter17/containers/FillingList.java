package thinkinjava.chapter17.containers;

import java.util.ArrayList;
import java.util.Collections;

/**
 * @author wubin
 * @Description
 * @project Learn-develop
 * @package thinkinjava.chapter17.containers
 * @email wubin326@qq.com
 * @date 2018/12/10
 * Modification History:
 * Date              Author           Version              Description
 * ----------------------------------------------------------------------
 * 2018/12/10        wubin            0.0.1
 */
public class FillingList {

    public static void main(String[] args) {
        final ArrayList<StringAddress> stringAddresses = new ArrayList<>(
                Collections.nCopies(4, new StringAddress("wubin")));
        System.out.println(stringAddresses);
        Collections.fill(stringAddresses,new StringAddress("666"));
        System.out.println(stringAddresses);
    }
}

class StringAddress {
    private String s;

    public StringAddress(String s) {
        this.s = s;
    }

    @Override
    public String toString() {
        return "StringAddress{" +
                "s='" + s + '\'' +
                '}';
    }
}
