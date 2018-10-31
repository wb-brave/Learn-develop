package thinkinjava.chapter19.enums;

/**
 * @author wubin
 * @Description 基本特性
 * @project Learn-develop
 * @package thinkinjava.chapter19.enums
 * @email wubin326@qq.com
 * @date 2018/10/23
 * Modification History:
 * Date              Author           Version              Description
 * ----------------------------------------------------------------------
 * 2018/10/23        wubin            0.0.1
 */
public class EnumClass {

    public static void main(String[] args) {
        for (Shrubbery s : Shrubbery.values()) {
            System.out.println(s + " ordinal: " + s.ordinal());
            System.out.print(s.compareTo(Shrubbery.CRAWLING) + " ");
            System.out.print(s.equals(Shrubbery.CRAWLING) + " ");
            System.out.println(s == Shrubbery.CRAWLING);
            System.out.println(s.getDeclaringClass());
            System.out.println(s.name());
            System.out.println("=========================");
        }
        for (String s : "GROUND,CRAWLING,HANGING".split(",")) {
            Shrubbery shrubbery = Enum.valueOf(Shrubbery.class, s);
            System.out.println(shrubbery);
        }
    }
}

enum Shrubbery {
    GROUND,
    CRAWLING,
    HANGING
}