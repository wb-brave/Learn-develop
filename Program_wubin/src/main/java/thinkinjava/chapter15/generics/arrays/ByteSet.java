package thinkinjava.chapter15.generics.arrays;

import java.util.*;

/**
 * @author wubin
 * @Description
 * @project Learn-develop
 * @package thinkinjava.chapter15.generics.arrays
 * @email wubin326@qq.com
 * @date 2018/11/21
 * Modification History:
 * Date              Author           Version              Description
 * ----------------------------------------------------------------------
 * 2018/11/21        wubin            0.0.1
 */
public class ByteSet {

    Byte[] b = {1,2,3,4,5,6,7,8};
    Set<Byte> byteSet = new HashSet<>(Arrays.asList(b));
    // Set<Byte> byteSet = new HashSet<>(Arrays.<Byte>asList(1,2,3,4,5,6,7)); //不会应用自动包装机智
}
