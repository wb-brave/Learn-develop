package thinkinjava.chapter11.holding;

/**
 * @author wubin
 * @Description 对于queue的练习
 * @project Learn-develop
 * @package thinkinjava.chapter11.holding
 * @email wubin326@qq.com
 * @date 2018/12/28
 * Modification History:
 * Date              Author           Version              Description
 * ----------------------------------------------------------------------
 * 2018/12/28        wubin            0.0.1
 */
public class Command {

    private String s;

    public Command(String s) {
        this.s = s;
    }

    public void operation(){
        System.out.println(s);
    }
}
