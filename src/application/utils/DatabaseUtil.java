/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package application.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 *
 * @author yusuf
 */
public class DatabaseUtil {
    private static Connection connection;
    private static final String DRIVER = System.getProperty("MYSQL_DRIVER");
    private static final String URL = System.getProperty("MYSQL_URL");
    private static final String USERNAME = System.getProperty("MYSQL_USERNAME");
    private static final String PASSWORD = System.getProperty("MYSQL_PASSWORD");
    private static final String MAX_POOL = System.getProperty("MYSQL_MAX_POOL");
    private static DatabaseUtil instance;
             
    private DatabaseUtil() {
        try {
            Properties properties = new Properties();
            properties.setProperty("user", USERNAME);
            properties.setProperty("password", PASSWORD);
            properties.setProperty("MaxPooledStatements", MAX_POOL);
        
            Class.forName(DRIVER);
            connection = DriverManager.getConnection(URL, properties);
            System.out.println("Connection to the database established successfully");       
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static DatabaseUtil getInstance(){
        if (instance == null) {
            instance = new DatabaseUtil();
        }else{
            System.out.println("Connection already established with db");
        }
        return instance;
    }
    
    public Connection getConnection() {
        return connection;
    }
    
    public void closeConnection() {
        try {
            if (connection != null) {
                connection.close();
                System.out.println("Connection closed");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
}
