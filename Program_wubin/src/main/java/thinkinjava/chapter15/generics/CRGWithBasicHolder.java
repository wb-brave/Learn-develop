package thinkinjava.chapter15.generics;

import thinkinjava.chapter15.generics.arrays.Holder;

/**
 * @author wubin
 * @Description 古怪的循环泛型（CRG）本质：基类用导出类替代其参数。
 * 这意味着泛型基类(BaseicHolder)便成为一种其子类的公共功能的模块
 * 里面设计到的泛型都是使用确切的类型（Subtype）
 * @project Learn-develop
 * @package thinkinjava.chapter15.generics
 * @email wubin326@qq.com
 * @date 2018/11/21
 * Modification History:
 * Date              Author           Version              Description
 * ----------------------------------------------------------------------
 * 2018/11/21        wubin            0.0.1
 */
public class CRGWithBasicHolder {

    public static void main(String[] args) {
        Subtype subtype = new Subtype();
        Subtype subtype1 = new Subtype();
        subtype.setElement(subtype1);
        Subtype element = subtype.getElement();
        subtype.f();
    }
}

class Subtype extends BasicHolder<Subtype>{

}
