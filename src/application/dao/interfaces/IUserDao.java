/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package application.dao.interfaces;

import application.models.UserModel;
import java.util.List;

/**
 *
 * @author yusuf
 */
public interface IUserDao {
    
    public List<UserModel> findOneById(UserModel userModel);
    
    public UserModel findOneByUsername(UserModel userModel);
    
    public List<UserModel> findAll();
    
    public int create(UserModel userModel);
    
    public int upsert(UserModel userModel);
    
    public int update(UserModel userModel);
    
    public void delete(UserModel userModel);

    public void closeStatement();
    
    public void closeConnection();
    
}
