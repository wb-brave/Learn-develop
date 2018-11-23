package thinkinjava.chapter15.generics;

/**
 * @author wubin
 * @Description
 * @project Learn-develop
 * @package thinkinjava.chapter15.generics
 * @email wubin326@qq.com
 * @date 2018/11/21
 * Modification History:
 * Date              Author           Version              Description
 * ----------------------------------------------------------------------
 * 2018/11/21        wubin            0.0.1
 */
public class MultipleInterfaceVariants {
}

interface Payable<T>{}

class Employee implements Payable{}

/**
 * 由于employee类实现了同样的泛型接口
 * 这个类继承employee后如果在实现这个泛型接口
 * 时，由于擦除的特性，编译器会理解你这条语句重复实现了同一个接口
 * 进而报错
 // */
// class Hourly extends Employee implements Payable<Hourly>{}

/**
 * 不适用泛型却可以
 */
class Hourly extends Employee implements Payable{}
