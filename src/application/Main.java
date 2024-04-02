/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package application;

import application.views.*;

/**
 *
 * @author yusuf
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            Config.load();
            Mysql.getInstance().getConnection();
            GenerateUser.start();
            new LoginView().start();
            new ReportView().start();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    
}
