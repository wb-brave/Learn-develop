package thinkinjava.chapter20.annotations.database;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.*;

/**
 * @author wubin
 * @Description
 * @project Learn-develop
 * @package thinkinjava.chapter20.annotations.database
 * @email wubin326@qq.com
 * @date 2018/12/29
 * Modification History:
 * Date              Author           Version              Description
 * ----------------------------------------------------------------------
 * 2018/12/29        wubin            0.0.1
 */
public class TableCreater {

    public static void parseAnnotation(Class<?> cla) {
        DBTable dbTable = cla.getAnnotation(DBTable.class);
        String tbname = null;
        if (dbTable != null) {
            tbname = dbTable.name().toUpperCase();
        } else {
            tbname = cla.getSimpleName().toUpperCase();
        }
        List<String> listColumns = new ArrayList<>();
        String columname = null;
        StringBuilder builder = new StringBuilder();
        for (Field field : cla.getDeclaredFields()) {
            columname = field.getName().toUpperCase();
            for (Annotation annotation : field.getAnnotations()) {
                if (annotation instanceof SQLString) {
                    SQLString sqlString = (SQLString) annotation;
                    builder.append(columname).append(" varchar(")
                            .append(sqlString.value()).append(") ")
                            .append(getContraints(sqlString.CONSTRAINTS()));
                    listColumns.add(builder.toString());
                    builder.delete(0, builder.length());
                }
                if (annotation instanceof SQLInteger) {
                    SQLInteger sqlInteger = (SQLInteger) annotation;
                    builder.append(columname).append(" int ").append(sqlInteger.name())
                            .append(" ").append(getContraints(sqlInteger.CONSTRAINTS()));
                    listColumns.add(builder.toString());
                    builder.delete(0, builder.length());
                }
            }
        }
        builder.append("create table ").append(tbname).append("(\n");
        Iterator<String> iterator = listColumns.iterator();
        while (iterator.hasNext()) {
            builder.append("\t").append(iterator.next()).append(",");
        }
        builder.deleteCharAt(builder.length() - 1);
        builder.append("\n)");
        System.out.println(builder);
    }

    public static StringBuilder getContraints(Constraints constraints) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(constraints.privateKey() ? "primary key ".toUpperCase() : "")
                .append(constraints.unique() ? "unique ".toUpperCase() : "")
                .append(constraints.canNull() ? "null ".toUpperCase() : "not null ".toUpperCase());
        return stringBuilder;
    }

    public static void main(String[] args) {
        parseAnnotation(Member.class);
    }
}
