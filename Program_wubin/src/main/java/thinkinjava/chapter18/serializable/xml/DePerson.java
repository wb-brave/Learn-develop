package thinkinjava.chapter18.serializable.xml;

import nu.xom.*;
import util.MyConst;

import java.io.*;
import java.util.ArrayList;

/**
 * @author wubin
 * @Description
 * @project Learn-develop
 * @package thinkinjava.chapter18.serializable
 * @email wubin326@qq.com
 * @date 2018/10/23
 * Modification History:
 * Date              Author           Version              Description
 * ----------------------------------------------------------------------
 * 2018/10/23        wubin            0.0.1
 */
public class DePerson extends ArrayList<Person> {

    public DePerson(String filename) throws ParsingException, IOException {

        /**
         * 不能直接使用filename进行反序列化
         * 将其转换为输入流即可
         */
        Document doc = new Builder().build(new ObjectInputStream(new FileInputStream(filename)));
        Elements elements = doc.getRootElement().getChildElements();
        for (int i = 0; i < elements.size(); i++) {
            add(new Person(elements.get(i)));
        }
    }

    public static void main(String[] args) throws ParsingException, IOException {
        DePerson people = new DePerson(String.format("%speople.xml", MyConst.FileConst.FILEPATH_DESKTOP));
        System.out.println(people);
    }
}
