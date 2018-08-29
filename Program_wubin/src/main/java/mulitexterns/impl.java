package mulitexterns;

import mulitexterns.interfaces.Monkey;

/**
 * @author wubin
 * @Description
 * @project Learn-develop
 * @package mulitexterns
 * @email wubin326@qq.com
 * @date 2018/08/23
 */
public class impl implements Monkey{
    @Override
    public String code() {
        return "coding";
    }

    @Override
    public String eat() {
        return "eating";
    }
}
