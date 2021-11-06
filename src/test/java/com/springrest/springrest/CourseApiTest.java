package com.springrest.springrest;

import org.testng.annotations.Test;
import java.sql.*;

public class CourseApiTest {

    int rowCount = 0;
    Connection connection;

    @Test
    public void verifyCourses() {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager
                    .getConnection("jdbc:mysql://localhost:3306/demo_api", "root", "elect22#@I");

            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from demo_api.course");
            ResultSetMetaData rsmd = resultSet.getMetaData();
            int columnCnt = rsmd.getColumnCount();

            while (resultSet.next()) {
                rowCount++;
                //System.out.println(Table.read().db(resultSet).printAll());
                for (int i = 1; i <= rsmd.getColumnCount(); i++) {
                    System.out.println(rsmd.getColumnName(i) + " = " + resultSet.getObject(i));
                }
                System.out.println("*******************************************************");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}