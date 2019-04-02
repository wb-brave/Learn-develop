package thinkinjava.chapter17.containers;

/**
 * @author wubin
 * @Description 测试容器的入参
 * @project Learn-develop
 * @package thinkinjava.chapter17.containers
 * @email wubin326@qq.com
 * @date 2018/12/21
 * Modification History:
 * Date              Author           Version              Description
 * ----------------------------------------------------------------------
 * 2018/12/21        wubin            0.0.1
 */
public class TestParam {

    public final int size;
    public final int lops;

    public TestParam(int size, int lops) {
        this.size = size;
        this.lops = lops;
    }

    /**
     * 根据int类型的集合中
     * 产生一组TestParam
     * @param values
     * @return
     */
    public static TestParam[] array(int... values) {
        int size = values.length / 2;
        TestParam[] testParams = new TestParam[size];
        int n = 0;
        for (int i = 0; i < size; i++) {
            testParams[i] = new TestParam(values[n++],values[n++]);
        }
        return testParams;
    }

    /**
     * 解析String类型的集合为int集合
     *
     * 产生一组TestParam
     * @param values
     * @return
     */
    public static TestParam[] array(String... values) {
        int[] vals = new int[values.length];
        int n = 0;
        for (int i = 0; i < vals.length; i++) {
            vals[i] = Integer.decode(values[i]);
        }
        return array(vals);
    }
}
