/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Entite.Admin;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author abdou-jabar
 */
public class AdminDAO {
    public static int seConnecter(Admin admin){
        
        int resultat = 0;
        
        Connection conn = Connexion.Connect();
        
        String requete = "SELECT * FROM ADMIN WHERE NOM_ADMIN = ? AND PASSWORD_ADMIN = ?;";
        
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        try {
            ps = conn.prepareStatement(requete);
            ps.setString(1, admin.getNomAdmin());
            ps.setString(2, admin.getMotDePasseAdmin());
            rs = ps.executeQuery();
            if(rs.next()){
                resultat = 1;
            }
            ps.close();
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(AdminDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return resultat;
    }
}
