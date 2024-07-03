/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package application.daoimpl;

import application.models.UserModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import application.dao.UserDao;
import application.utils.DatabaseUtil;

/**
 *
 * @author yusuf
 */
public class UserDaoImpl implements UserDao {
    private Connection dbConnection = null;
    private PreparedStatement pstmt = null;
    private ResultSet resultSet = null;
    private String query;
    
    public UserDaoImpl() {
        dbConnection = DatabaseUtil.getInstance().getConnection();
    }

    @Override
    public List<UserModel> findOneById(String id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public UserModel findOneByUsernameAndPassword(String username, String password) {
        try {
            query = "SELECT * FROM users WHERE username=? and password=?";
 
            pstmt = dbConnection.prepareStatement(query);
            pstmt.setString(1, username);
            pstmt.setString(2, password);
            
            resultSet = pstmt.executeQuery();
            if(resultSet.next()){
                UserModel userFound = new UserModel();
                userFound.setId(resultSet.getInt("id"));
                userFound.setUsername(resultSet.getString("username"));
                userFound.setName(resultSet.getString("name"));
                userFound.setGender(resultSet.getString("gender"));
                userFound.setPassword(resultSet.getString("password"));
                return userFound;
            }
            return null;
	} catch (SQLException e) {
            // e.printStackTrace();
            throw new RuntimeException(e);
        } finally {
            closeStatement();
        }
    }

    @Override
    public List<UserModel> findAll() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int create(UserModel user) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int upsert(UserModel user) {
        try {
            query = "INSERT INTO users(name, gender, place_of_birth, date_of_birth, address, religion, phone_number, username, password, created_at, updated_at, role_id, email) " +
                    "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) " +
                    "ON DUPLICATE KEY UPDATE name=VALUES(name), gender=VALUES(gender), place_of_birth=VALUES(place_of_birth), " +
                    "date_of_birth=VALUES(date_of_birth), address=VALUES(address), religion=VALUES(religion)," +
                    "phone_number=VALUES(phone_number), username=VALUES(username), password=VALUES(password), " +
                    "created_at=VALUES(created_at), updated_at=VALUES(updated_at), role_id=VALUES(role_id), " +
                    "email=VALUES(email)";
            
            pstmt = dbConnection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            pstmt.setString(1, user.getName());
            pstmt.setString(2, user.getGender());
            pstmt.setString(3, user.getPlaceOfBirth());
            pstmt.setDate(4, user.getDateOfBirth());
            pstmt.setString(5, user.getAddress());
            pstmt.setString(6, user.getReligion());
            pstmt.setString(7, user.getPhoneNumber());
            pstmt.setString(8, user.getUsername());
            pstmt.setString(9, user.getPassword());
            pstmt.setTimestamp(10, user.getCreatedAt());
            pstmt.setTimestamp(11, user.getUpdatedAt());
            pstmt.setInt(12, user.getRoleId());
            pstmt.setString(13, user.getEmail());
       
            int result = pstmt.executeUpdate();
            resultSet = pstmt.getGeneratedKeys();
            return result;
	} catch (SQLException e) {
            // e.printStackTrace();
            throw new RuntimeException(e);
        } finally {
            closeStatement();
        }
    }

    @Override
    public int update(UserModel user) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(UserModel user) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private void closeStatement() {
        try {
            if(pstmt != null){
                pstmt.close();
                pstmt = null;
            }
            if(resultSet != null){
                resultSet.close();
                resultSet = null;
            }   
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
