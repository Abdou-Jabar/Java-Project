/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author abdou-jabar
 */
public class Statistiques {
    
    public static int nbAbonneActif(){
        int count = 0;
        
        Connection conn = Connexion.Connect();
        
        String requete = "SELECT COUNT(*) AS TOTAL FROM ABONNE WHERE STATUT_SOUSCRIPTION IS TRUE;";
        
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(requete);
            if (rs.next()) {
                count = rs.getInt("TOTAL");
            }
        } catch (SQLException ex) {
            Logger.getLogger(Statistiques.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return count;
    }
}
