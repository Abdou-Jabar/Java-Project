/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Entite.Abonne;
import Entite.Abonnement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author abdou-jabar
 */
public class SouscriptionDAO {
    public static int Souscrire(Abonne abonne, Abonnement  abonnement) {
        int resultat = 0;
        
        Connection conn = Connexion.Connect();
        
        String requete = "INSERT INTO SOUSCRIPTION(ID_ABONNE, ID_ABONNEMENT, DATE_DEBUT) VALUES (?, ?, ?);";
        
        PreparedStatement ps = null;

        try {
            ps = conn.prepareStatement(requete);
            ps.setString(1, abonne.getId());
            ps.setString(2, abonnement.getId());
            ps.setDate(3, Date.valueOf(LocalDate.now()));
            resultat = ps.executeUpdate();
            ps.close();
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(AbonnementDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return resultat;
    }
}
