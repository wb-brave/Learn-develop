package thinkinjava.chapter17.containers;

/**
 * @author wubin
 * @Description
 * @project Learn-develop
 * @package thinkinjava.chapter17.containers
 * @email wubin326@qq.com
 * @date 2018/12/17
 * Modification History:
 * Date              Author           Version              Description
 * ----------------------------------------------------------------------
 * 2018/12/17        wubin            0.0.1
 */
public class GroundDog {

    protected int number;

    public GroundDog(int number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "GroundDog #" + number;
    }
}
