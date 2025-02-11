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
import java.sql.ResultSet;

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
    
    public static int renouvellerAbonnement(Abonne abonne){
        int resultat = 0;
        String dernierAbonnement = "";

        Connection conn = Connexion.Connect();
        
        String requete = "INSERT INTO SOUSCRIPTION(ID_ABONNE, ID_ABONNEMENT, DATE_DEBUT) VALUES (?, ?, ?);";
        
        String requeteDernierAbonnement = "SELECT ID_ABONNEMENT FROM SOUSCRIPTION WHERE ID_ABONNE = ? DESC LIMIT 1";
       
        PreparedStatement ps = null;
        
        try {
            ps = conn.prepareStatement(requeteDernierAbonnement);
            ps.setString(1, abonne.getId());
            ResultSet rs = ps.executeQuery();
            dernierAbonnement = rs.getString("ID_ABONNEMENT");
        } catch (SQLException ex) {
            Logger.getLogger(SouscriptionDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            ps = conn.prepareStatement(requete);
            ps.setString(1, abonne.getId());
            ps.setString(2, dernierAbonnement);
            ps.setDate(3, Date.valueOf(LocalDate.now()));
            resultat = ps.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(SouscriptionDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return resultat;
    }
    
    public static int resilierAbonne(Abonne abonne){
        int resultat = 0;
        
        Connection conn = Connexion.Connect();
        
        String requete = "UPDATE SOUSCRIPTION SET STATUT_SOUSCRIPTION = FALSE WHERE ID_ABONNE = ?;";
        
        PreparedStatement ps = null;
        
        try {
            ps = conn.prepareStatement(requete);
            ps.setString(1, abonne.getId());
            resultat = ps.executeUpdate();
            ps.close();
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(SouscriptionDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return resultat;
    }
}














