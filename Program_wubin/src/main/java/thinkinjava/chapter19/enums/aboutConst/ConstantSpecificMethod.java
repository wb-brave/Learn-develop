package thinkinjava.chapter19.enums.aboutConst;

import java.text.DateFormat;
import java.time.LocalDate;
import java.util.Date;

/**
 * @author wubin
 * @Description enum允许在m枚举实例中编写方法（来自于enum中的抽象方法）来产生不同的行为
 * @project Learn-develop
 * @package thinkinjava.chapter19.enums.aboutConst
 * @email wubin326@qq.com
 * @date 2018/10/24
 * Modification History:
 * Date              Author           Version              Description
 * ----------------------------------------------------------------------
 * 2018/10/24        wubin            0.0.1
 */
enum  ConstantSpecificMethod {

    DATE_TIME{
        String getInfo(){
            return DateFormat.getInstance().format(new Date());
        }
    },
    CLASSPATH{
        @Override
        String getInfo() {
            return System.getenv("CLASSPATH");
        }
    },
    VERSION{
        @Override
        String getInfo() {
            return System.getProperty("java.version");
        }
    };
    abstract String getInfo();

    public static void main(String[] args) {
        for (ConstantSpecificMethod method : values()) {
            System.out.println(method.getInfo());
        }
    }
}
