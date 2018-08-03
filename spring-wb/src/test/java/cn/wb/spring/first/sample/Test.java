package cn.wb.spring.first.sample;

import java.sql.*;

public class Test {
    private int wubin;

    public Test(int wubin) {
        this.wubin = wubin;
    }

    public void setWubin(int wubin) {
        this.wubin = wubin;
    }

    public int getWubin() {
        return wubin;
    }

    static class innerClazz {
        public static void prints() {
            System.out.println("wubin");
        }
    }

    public static void main(String[] wn) {
        String jdbcDriver = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/test";
        String username = "";
        String password = "";
        Connection connection = null;
        ResultSet resultSet = null;
        try {
            Class.forName(jdbcDriver);
            connection = DriverManager.getConnection(url, username, password);
            //Statement
            Statement statement = connection.createStatement();
            ResultSet sql = statement.executeQuery("sql");
            //PreparedStatement 在构造是进行了预编译，所以性能要快一旦，而且与statement的创建方式不一样
            PreparedStatement sql1 = connection.prepareStatement("sql");
            resultSet = sql1.executeQuery();
            while (sql.next()) {
                //对属性进行封装
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }
}
