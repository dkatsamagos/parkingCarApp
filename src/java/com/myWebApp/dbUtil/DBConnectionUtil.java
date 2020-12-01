package com.myWebApp.dbUtil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author dkats
 */
public class DBConnectionUtil {

    // define database properties
    private static final String MYSQL_JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/parking?serverTimezone=UTC";
    private static final String USER = "root";
    private static final String PASSWORD = "250590";
    private static Connection connection = null;
    private static PreparedStatement preparedStatement = null;
    private static ResultSet resultSet = null;

    // define the static method
    public static Connection getConnection() {

        // check the connection
        if (connection != null) {
            return connection;
        } else {
            try {
                // load the driver
                Class.forName(MYSQL_JDBC_DRIVER);

                // get the connection
                connection = DriverManager.getConnection(DATABASE_URL, USER, PASSWORD);

            } catch (ClassNotFoundException | SQLException e) {
                e.printStackTrace();
            }
            // return the connection
            return connection;
        }
    }

    public static void closeConnection() {
        try {
            if (resultSet != null) {
                resultSet.close();
            }
            if (preparedStatement != null) {
                preparedStatement.close();
            }
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

}
