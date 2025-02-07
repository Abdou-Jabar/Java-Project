/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entite;

import java.util.Date;

/**
 *
 * @author abdou-jabar
 */
public class Souscription {
    private String id;
    private String idAbonne;
    private String idAbonnement;
    private Date dateDebut;
    
    public Souscription(){}

    //Pour créer une nouvelle souscription
    public Souscription(String idAbonne, String idAbonnement, Date dateDebut) {
        this.idAbonne = idAbonne;
        this.idAbonnement = idAbonnement;
        this.dateDebut = dateDebut;
    }

    public Souscription(String id, String idAbonne, String idAbonnement, Date dateDebut) {
        this.id = id;
        this.idAbonne = idAbonne;
        this.idAbonnement = idAbonnement;
        this.dateDebut = dateDebut;
    }

    public String getId() {
        return id;
    }

    public String getIdAbonne() {
        return idAbonne;
    }

    public String getIdAbonnement() {
        return idAbonnement;
    }

    public Date getDateDebut() {
        return dateDebut;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setIdAbonne(String idAbonne) {
        this.idAbonne = idAbonne;
    }

    public void setIdAbonnement(String idAbonnement) {
        this.idAbonnement = idAbonnement;
    }

    public void setDateDebut(Date dateDebut) {
        this.dateDebut = dateDebut;
    }
    
    
}
