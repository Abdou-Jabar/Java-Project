/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author abdou-jabar
 */
public class Connexion {
        public static Connection Connect(){
        Connection con = null;
        String url = "jdbc:mysql://localhost:3306/GES_SALLE_SPORT";
        String motdepasse="djabar00";
        String login="root";
     
        try {
            con= DriverManager.getConnection(url, login, motdepasse);
        } catch (SQLException ex) {
            Logger.getLogger(Connexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return con;
        
    }
}
