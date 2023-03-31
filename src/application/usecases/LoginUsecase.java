/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package application.usecases;

import application.Password;
import application.dao.UserDao;
import application.dao.interfaces.IUserDao;
import application.models.UserModel;

/**
 *
 * @author yusuf
 */
public class LoginUsecase {
    
    private final IUserDao userDao;
    
    public LoginUsecase() {
        this.userDao = new UserDao();
    }
    
    public boolean validateLogin(String username, String password){
        UserModel user = new UserModel();
        user.setUsername(username);
        UserModel findOneByUsername = userDao.findOneByUsername(user);
        if(findOneByUsername == null) return false;

        String inputUser = Password.getSecurePassword(password);
        String passwordDb = findOneByUsername.getPassword();
        
        return inputUser.equals(passwordDb);
    }
    
    
    public void daoCloseConnection() {
        userDao.closeConnection();
    }
    
}
