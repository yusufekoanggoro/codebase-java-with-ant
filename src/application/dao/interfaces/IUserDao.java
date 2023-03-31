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
    
    public List<UserModel> findOneById(UserModel user);
    
    public UserModel findOneByUsername(UserModel user);
    
    public List<UserModel> findAll();
    
    public int create(UserModel user);
    
    public int upsert(UserModel user);
    
    public int update(UserModel user);
    
    public void delete(UserModel user);

    public void closeStatement();
    
    public void closeConnection();
    
}
