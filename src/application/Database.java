/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package application;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Logger;

/**
 *
 * @author yusuf
 */
public class Database {
    
    private static Connection connection;
    private static final String DRIVER = System.getProperty("MYSQL_DRIVER");
    private static final String URL = System.getProperty("MYSQL_URL");
    private static final String USERNAME = System.getProperty("MYSQL_USERNAME");
    private static final String PASSWORD = System.getProperty("MYSQL_PASSWORD");
    private static final String MAX_POOL = System.getProperty("MYSQL_MAX_POOL");
    
    private static Database instance;
    
    private static final Logger logger = Logger.getLogger(Database.class.getName());
            
    private Database() {
        try {
            Properties properties = new Properties();
            properties.setProperty("user", USERNAME);
            properties.setProperty("password", PASSWORD);
            properties.setProperty("MaxPooledStatements", MAX_POOL);
        
            Class.forName(DRIVER);
            connection = DriverManager.getConnection(URL, properties);
            logger.info("Connection to the database established successfully");       
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static Database getInstance(){
        if (instance == null) {
            instance = new Database();
        }else{
            logger.info("Connection already established with db");
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
                logger.info("Connection closed");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
        
}
