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
public class GroundDog2 extends GroundDog {


    public GroundDog2(int number) {
        super(number);
    }

    @Override
    public int hashCode() {
        return number;
    }

    @Override
    public boolean equals(Object obj) {
        //注意强转的括号
        return obj instanceof GroundDog2 && number == ((GroundDog2) obj).number;
    }
}
