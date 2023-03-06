package com.examples.java.jdbc;

import java.sql.*;

/**
 * 使用远程JDBC连接数据库
 *
 * 1、加载驱动
 * 2、创建数据库连接
 * 3、创建执行sql的语句
 * 4、执行语句
 * 5、处理执行结果
 * 6、释放资源
 *
 * @author liangjinlong9527
 * @date 2022-11-13 12:57
 */
public class JdbcUtils {


    /**
     * 连接数据库
     */
    public static void connection () {
        // 连接信息
        String url = "jdbc:mysql://geminis:3306/test?useUnicode=true&characterEncoding=utf8&useSSL=true&serverTimezone=UTC";
        String user = "root";
        String password = "123456";
        try {
            // 1、加载驱动程序
            Class.forName("com.mysql.jdbc.Driver");
            // 2、获取数据库连接
            Connection connection = DriverManager.getConnection(url, user, password);
            // 3、创建执行sql语句
            String nickname = "闾丘";
            String sql = "select * from test_user where real_name = ? limit 10";
            // 4、执行语句
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, nickname);
            // 5、处理执行结果
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                String name = resultSet.getString("nickname");
                String mobile = resultSet.getString("mobile");
                System.out.println("name = " + name + ", mobile = " + mobile);
            }
            // 6、释放资源
            resultSet.close();
            statement.close();
            connection.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        connection();
    }

}
