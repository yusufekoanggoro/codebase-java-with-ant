/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package application;

import application.frames.LoginFrame;

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
            Config.build();
            GenerateUser generateUser = new GenerateUser();
            generateUser.start();
        
            LoginFrame loginFrame = new LoginFrame();
            loginFrame.start();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    
}
