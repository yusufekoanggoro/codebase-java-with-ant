/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package application;

import application.dao.UserDao;
import application.dao.interfaces.IUserDao;
import application.models.UserModel;
import application.utils.StringUtils;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.logging.Logger;

/**
 *
 * @author yusuf
 */
public class GenerateUser {
    
    private static final Logger logger = Logger.getLogger(Mysql.class.getName());
    
    public static void start(){
        List<UserModel> users = new ArrayList<>();
        IUserDao userDao = new UserDao();
        
        java.util.Date utilDate = new java.util.Date();
        java.sql.Timestamp dateNow = new java.sql.Timestamp(utilDate.getTime());
        
        Calendar cal = Calendar.getInstance();
        cal.set( Calendar.YEAR, 2001 );
        cal.set( Calendar.MONTH, Calendar.FEBRUARY );
        cal.set( Calendar.DATE, 24 );

        java.sql.Date dateOfBirth = new java.sql.Date(cal.getTimeInMillis());
        
        UserModel user1 = new UserModel();
        user1.setName("Yusuf Eko Anggoro");
        user1.setGender("Laki-laki");
        user1.setPlaceOfBirth("Jakarta");
        user1.setPhoneNumber("0812********");
        user1.setDateOfBirth(dateOfBirth);
        user1.setCreatedAt(dateNow);
        user1.setUpdatedAt(dateNow);
        user1.setAddress("Jalan-jalan");
        user1.setReligion("Islam");
        user1.setRoleId(1);
        users.add(user1);
        
        UserModel user2 = new UserModel();
        user2.setName("Yusuf Eko Anggoro");
        user2.setGender("Laki-laki");
        user2.setPlaceOfBirth("Jakarta");
        user2.setPhoneNumber("0812********");
        user2.setDateOfBirth(dateOfBirth);
        user2.setCreatedAt(dateNow);
        user2.setUpdatedAt(dateNow);
        user2.setAddress("Jalan-jalan");
        user2.setReligion("Islam");
        user2.setRoleId(1);
        users.add(user2);
        
        int index = 1;
        String roleName = null;
        for (UserModel user : users) {
            if(user.getRoleId() == 1){
                roleName = "admin";
            }
            String username = StringUtils.getInitialsFullName(user.getName()).toLowerCase() + index++  + "-" + roleName;
            user.setUsername(username);
            user.setPassword(Password.getSecurePassword(username));
            userDao.upsert(user);
        }
        logger.info("Success Generate User");
    }
}
