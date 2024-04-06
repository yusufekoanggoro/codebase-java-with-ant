/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package application.dao;

import application.models.UserModel;
import java.util.List;

/**
 *
 * @author yusuf
 */
public interface UserDao {
    
    public List<UserModel> findOneById(String id);
    
    public UserModel findOneByUsernameAndPassword(String username, String Password);
    
    public List<UserModel> findAll();
    
    public int create(UserModel user);
    
    public int upsert(UserModel user);
    
    public int update(UserModel user);
    
    public void delete(UserModel user);
    
}
