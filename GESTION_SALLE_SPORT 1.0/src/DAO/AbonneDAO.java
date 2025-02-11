/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Entite.Abonne;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author abdou-jabar
 */
@SuppressWarnings("unused")
public class AbonneDAO {
    
    /**
        Insérer un abonné
     */
    public static int createAbonne(Abonne abonne){
     
        int resultat = 0;
        
        Connection conn = Connexion.Connect();
        
        String requete = "INSERT INTO ABONNE(ID_ABONNE, NOM, PRENOM, DATE_INSCRIPTION, NUMERO, STATUS_SOUSCRIPTION) VALUES (?, ?, ?, ?, ?, ?);";
        
        PreparedStatement ps = null;
        
        try {
            ps = conn.prepareStatement(requete);
            ps.setString(1, abonne.getId());
            ps.setString(2, abonne.getNom());
            ps.setString(3, abonne.getPrenom());
            ps.setDate(4, Date.valueOf(LocalDate.now()));
            ps.setString(5, abonne.getNumero());
            ps.setBoolean(6, abonne.getStatutSouscription());
            resultat = ps.executeUpdate();
            ps.close();
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(AbonneDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return resultat;
    }
    
    /*
        Rechecher un abonné
    */
    public static Abonne searchAbonne(String idAbonne){
                       
        Abonne abonne = new Abonne();
        
        Connection conn = Connexion.Connect();
        
        ResultSet resultat = null;
        
        String requete = "SELECT * FROM ABONNE WHERE ID_ABONNE = ?;";
        
        PreparedStatement ps = null;
        
        try {
            ps = conn.prepareStatement(requete);
            ps.setString(1, idAbonne);
            resultat = ps.executeQuery();
            if (resultat.next()) {
                abonne.setId(resultat.getString(1));
                abonne.setNom(resultat.getString(2));
                abonne.setPrenom(resultat.getString(3));
                abonne.setNumero(resultat.getString(4));
                Date dateSql = resultat.getDate(5);
                LocalDate dateInscription = dateSql.toLocalDate();
                abonne.setDateInscription(dateInscription);
                abonne.setStatutSouscription(resultat.getBoolean(6));
                ps.close();
                conn.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger(AbonneDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
                
        return abonne;
    }
    
    /*
        Liste de tous les abonnés
    */
    public static List<Abonne> allAbonne(){
        Connection conn = Connexion.Connect();
        
        List<Abonne> abonnes = new ArrayList<>();
        
        String requete = "SELECT ABONNE.*, ABONNEMENT.LIBELLE"
                       + "FROM ABONNE"
                       + "JOIN SOUSCRIPTION"
                       + "ON ABONNE.ID_ABONNE = SOUSCRIPTION.ID_ABONNE"
                       + "JOIN ABONNEMENT"
                       + "ON SOUSCRIPTION.ID_ABONNEMENT = ABONNEMENT.ID_ABONNEMENT;";
        
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(requete);
            
            while (rs.next()){
                Abonne abonne = new Abonne(
                        rs.getString("ID_ABONNE"),
                        rs.getString("NOM"),
                        rs.getString("PRENOM"),
                        rs.getString("NUMERO_TELEPHONE"),
                        rs.getDate("DATE_INSCRIPTION").toLocalDate()
                );
                abonnes.add(abonne);
            }
            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(AbonneDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return abonnes;
    }
    
    /*
        Supprimer un aboonnne
    */
    public static int supprimerAbonne(String id){
        int resultat = 0;
        
        Connection conn = Connexion.Connect();
        
        String requete = "DELETE FROM ABONNE WHERE ID_ABONNE = ?;";
        
        PreparedStatement ps = null;
        
        try {
            ps = conn.prepareStatement(requete);
            ps.setString(1, id);
            resultat = ps.executeUpdate();
            ps.close();
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(AbonneDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return resultat;
    }
    
    /*
        Modifier un abonne
    */
    public static int modifierAbonne(Abonne abonne){
        int resultat = 0;
        
        Connection conn = Connexion.Connect();
        
        String requete = "UPDATE ABONNE SET NOM = ?, PRENOM = ?, NUMERO_TELEPHONE = ? WHERE ID_ABONNE = ?;";
        
        PreparedStatement ps = null;
        
        try {
            ps = conn.prepareStatement(requete);
            ps.setString(1, abonne.getNom());
            ps.setString(2, abonne.getPrenom());
            ps.setString(3, abonne.getNumero());
            ps.setString(4, abonne.getId());
            resultat = ps.executeUpdate();
            ps.close();
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(AbonneDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return resultat;
    }
}
