package thinkinjava.chapter19.enums.multiroad;

/**
 * @author wubin
 * @Description
 * @project Learn-develop
 * @package thinkinjava.chapter19.enums.multiroad
 * @email wubin326@qq.com
 * @date 2018/10/31
 * Modification History:
 * Date              Author           Version              Description
 * ----------------------------------------------------------------------
 * 2018/10/31        wubin            0.0.1
 */
public interface Competitor<T extends Competitor<T>> {
    OutCome compete(T competitor);
}
