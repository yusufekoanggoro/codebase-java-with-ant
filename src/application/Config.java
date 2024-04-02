/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package application;

import io.github.cdimascio.dotenv.Dotenv;

/**
 *
 * @author yusuf
 */
public class Config {
    
    public static void load() {
        Dotenv dotenv = Dotenv.configure().load();
        dotenv.entries().forEach(e -> System.setProperty(e.getKey(), e.getValue()));
    }
    
}
