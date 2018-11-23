package thinkinjava.chapter14.proxy;

import util.MyConst;

import java.lang.reflect.Proxy;

/**
 * @author wubin
 * @Description
 * @project Learn-develop
 * @package thinkinjava.chapter5.proxy
 * @email wubin326@qq.com
 * @date 2018/11/05
 * Modification History:
 * Date              Author           Version              Description
 * ----------------------------------------------------------------------
 * 2018/11/05        wubin            0.0.1
 */
public class WriteFileTestProxy {

    public static void main(String[] args) {

        WriteFile writeFile = new WriteFile();
        Writes proxyInstance = (Writes) Proxy.newProxyInstance(Writes.class.getClassLoader()
                , new Class[]{Writes.class}
                , new ProxyTransaction(writeFile));
        proxyInstance.writing(MyConst.FileConst.FILEPATH_DESKTOP + "test.json",0);
    }
}
