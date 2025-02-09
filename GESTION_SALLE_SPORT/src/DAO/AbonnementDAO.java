/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Entite.Abonnement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author abdou-jabar
 */
@SuppressWarnings("unused")
public class AbonnementDAO {
    public static int ajouterAbonnement(Abonnement abonnement){
        int resultat = 0;
        
        Connection conn = Connexion.Connect();
        
        String requete = "INSERT INTO ABONNEMENT(ID_ABONNEMENT, LIBELLE, DUREE_MOIS, PRIX_MENSUEL) VALUES (?, ?, ?, ?);";
        
        PreparedStatement ps = null;

        try {
            ps = conn.prepareStatement(requete);
            ps.setString(1, abonnement.getId());
            ps.setString(2, abonnement.getLibelle());
            ps.setInt(3, abonnement.getDureeMois());
            ps.setFloat(4, abonnement.getPrixMensuel());
            resultat = ps.executeUpdate();
            ps.close();
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(AbonnementDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return resultat;
    }
    
    public static int modifierAbonnement(Abonnement abonnement){
        int resultat = 0;
        
        Connection conn = Connexion.Connect();
        
        String requete = "UPDATE ABONNEMENT SET LIBELLE = ?, DUREE_MOIS = ?, PRIX_MENSUEL = ? WHERE ID_ABONNEMENT = ?;";
        
        PreparedStatement ps = null;
        
        try {
            ps = conn.prepareStatement(requete);
            ps.setString(1, abonnement.getLibelle());
            ps.setInt(2, abonnement.getDureeMois());
            ps.setFloat(3, abonnement.getPrixMensuel());
            ps.setString(4, abonnement.getId());
            resultat = ps.executeUpdate();
            ps.close();
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(AbonnementDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return resultat;
    }
    
    public static int supprimerAbonnement(String idAbonnement){
        int resultat = 0;
        
        Connection conn = Connexion.Connect();
        
        String requete = "DELETE FROM ABONNEMENT WHERE ID_ABONNEMENT = ?";
        
        PreparedStatement ps = null;
        
        try {
            ps = conn.prepareStatement(requete);
            ps.setString(1, idAbonnement);
            resultat = ps.executeUpdate();
            ps.close();
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(AbonnementDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return resultat;
    }
    
    public static List<Abonnement> allAbonnement(){
        
        Connection conn = Connexion.Connect();
        
        List<Abonnement> abonnements = new ArrayList<>();
        
        String requete = "SELECT * FROM ABONNEMENT;";
        
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(requete);
            
            while(rs.next()){
                Abonnement abonnement = new Abonnement(
                        rs.getString("ID_ABONNEMENT"),
                        rs.getString("LIBELLE"),
                        rs.getInt("DUREE_MOIS"),
                        rs.getFloat("ID_ABONNEMENT")
                );
                abonnements.add(abonnement);
            }

        } catch (SQLException ex) {
            Logger.getLogger(AbonnementDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return abonnements;
    }
}
