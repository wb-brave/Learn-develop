package util.xml;


import org.dom4j.*;
import org.dom4j.io.*;
import util.CommonUtils;

import java.io.*;
import java.net.URL;
import java.util.Date;

/**
 * @author wubin
 * @Description
 * @project Learn-develop
 * @package util.xml
 * @email wubin326@qq.com
 * @date 2018/12/05
 * Modification History:
 * Date              Author           Version              Description
 * ----------------------------------------------------------------------
 * 2018/12/05        wubin            0.0.1
 */
public class XmlUtils {
    public XmlUtils() {
    }

    public static Element parseXml(InputStream in) throws Exception {
        SAXReader saxReader = new SAXReader();
        Document document = saxReader.read(in);
        return document.getRootElement();
    }

    public static Element parseXml(String fileName) throws Exception {
        InputStream in = IOUtils.getResourceAsStream(XmlUtils.class, fileName);
        return parseXml(in);
    }

    public static Element parseXmlOfString(String str) throws Exception {
        ByteArrayInputStream in = new ByteArrayInputStream(str.getBytes());
        Element result = parseXml((InputStream)in);
        in.close();
        return result;
    }

    public static Element createElement(String name, String text) {
        Element e = DocumentHelper.createElement(name);
        if (text != null && !text.trim().equals("")) {
            e.setText(text);
        }

        return e;
    }

    public static String formatElement(Element e) {
        StringWriter s = new StringWriter();
        OutputFormat format = OutputFormat.createPrettyPrint();
        XMLWriter writer = new XMLWriter(s, format);

        try {
            writer.write(e);
            writer.close();
        } catch (IOException var5) {
            var5.printStackTrace();
        }

        return s.getBuffer().toString();
    }

    public static void writerXml(String filename, Element root) throws Exception {
        Writer writer = new FileWriter(new File(filename));
        writerXml((Writer)writer, root);
    }

    public static void writerXml(Writer writer, Element root) throws Exception {
        Document doc = root.getDocument();
        if (doc == null) {
            doc = DocumentHelper.createDocument(root);
        }

        OutputFormat format = OutputFormat.createPrettyPrint();
        format.setEncoding("GB2312");
        XMLWriter xmlWriter = new XMLWriter(writer, format);
        xmlWriter.write(doc);
        xmlWriter.close();
    }

    public static String getTextByPath(Element root, String path) {
        if (root != null && CommonUtils.judgeNullString(path)) {
            Element element = (Element)root.selectSingleNode(path);
            String text = null;
            if (element != null) {
                text = element.getTextTrim();
            }

            return text;
        } else {
            return null;
        }
    }

    public static final class IOUtils{
        public static InputStream getResourceAsStream(Class aClass, String fileName) {
            InputStream result = Thread.currentThread().getContextClassLoader().getResourceAsStream(fileName);
            if (result == null) {
                result = aClass.getClassLoader().getResourceAsStream(fileName);
            }

            return result;
        }

        public static URL getResource(Class aClass, String fileName) {
            URL result = Thread.currentThread().getContextClassLoader().getResource(fileName);
            if (result == null) {
                result = aClass.getClassLoader().getResource(fileName);
            }

            return result;
        }

        public static byte[] getResourceAsBytes(Class aClass, String fileName) throws Exception {
            InputStream in = Thread.currentThread().getContextClassLoader().getResourceAsStream(fileName);
            if (in == null) {
                in = aClass.getClassLoader().getResourceAsStream(fileName);
            }

            return getResourceAsBytes(in);
        }

        public static byte[] getResourceAsBytes(InputStream in) throws Exception {
            if (in == null) {
                return null;
            } else {
                ByteArrayOutputStream bytestream = new ByteArrayOutputStream();

                byte[] var5;
                try {
                    int ch;
                    while((ch = in.read()) != -1) {
                        bytestream.write(ch);
                    }

                    byte[] imgdata = bytestream.toByteArray();
                    var5 = imgdata;
                } finally {
                    bytestream.close();
                }

                return var5;
            }
        }

        public static Integer getExpireSeconds(Date date) {
            Integer seconds = null;
            if (date != null) {
                Long ttl = (date.getTime() - (new Date()).getTime()) / 1000L;
                seconds = ttl.intValue();
            }

            return seconds;
        }
    }
}
