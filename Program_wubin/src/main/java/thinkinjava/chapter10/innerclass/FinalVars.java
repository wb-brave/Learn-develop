package thinkinjava.chapter10.innerclass;


/**
 * @author wubin
 * @Description
 * @project Learn-develop
 * @package thinkinjava.chapter10.innerclass
 * @email wubin326@qq.com
 * @date 2018/11/23
 * Modification History:
 * Date              Author           Version              Description
 * ----------------------------------------------------------------------
 * 2018/11/23        wubin            0.0.1
 */
public class FinalVars {

    public Destination destination(String lable){
        return new Destination() {
            private String dest = lable;
            @Override
            public String readLable() {
                return dest;
            }
        };
    }
}
