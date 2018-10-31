package thinkinjava.chapter18.serializable.xml;

import nu.xom.*;
import util.MyConst;

import java.io.*;
import java.util.Arrays;
import java.util.List;

/**
 * @author wubin
 * @Description
 * @project Learn-develop
 * @package thinkinjava.chapter18.serializable.xml
 * @email wubin326@qq.com
 * @date 2018/10/23
 * Modification History:
 * Date              Author           Version              Description
 * ----------------------------------------------------------------------
 * 2018/10/23        wubin            0.0.1
 */
public class Person {

    private String first, last;

    public Person(String first, String last) {
        this.first = first;
        this.last = last;
    }

    @Override
    public String toString() {
        return "Person{" +
                "first='" + first + '\'' +
                ", last='" + last + '\'' +
                '}';
    }

    public Element getXml() {
        Element person = new Element("person");
        Element firstName = new Element("first");
        firstName.appendChild(first);
        Element lastName = new Element("last");
        lastName.appendChild(last);
        person.appendChild(firstName);
        person.appendChild(lastName);
        return person;
    }

    public Person(Element person) {
        first = person.getFirstChildElement("first").getValue();
        last = person.getFirstChildElement("last").getValue();
    }

    public static void format(OutputStream os, Document doc) throws IOException {

        Serializer serializer = new Serializer(os, "GBK");
        serializer.setIndent(4);
        serializer.setMaxLength(50);
        serializer.write(doc);
        serializer.flush();
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        List<Person> people = Arrays.asList(
                new Person("wu", "bin"),
                new Person("zhang", "liang"),
                new Person("da", "qiao")
        );
        System.out.println(people);
        Element root = new Element("people");
        for (Person p : people) {
            root.appendChild(p.getXml());
        }
        Document document = new Document(root);
        format(System.out,document);
        format(new ObjectOutputStream(new FileOutputStream(String.format("%speople.xml", MyConst.FileConst.FILEPATH_DESKTOP)))
                ,document);
        /**
         *不能用下列方法进行反序列化
         * 因为是使用serializer.write(doc)序列化的文件
         */
        // ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(String.format("%speople.xml", MyConst.FileConst.FILEPATH_DESKTOP)));
        // Document document1 = (Document) objectInputStream.readObject();
        // format(System.out,document1);

    }
}
