/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entite;

import java.time.LocalDate;

/**
 *
 * @author abdou-jabar
 */
public class Abonne {
    
    private String id;
    private String nom;
    private String prenom;
    private String numero;
    private LocalDate dateInscription;
    private boolean statutSouscription;
    
    public Abonne(){}
    
    public Abonne(String id){
        this.id = id;
    }
    
    public Abonne(String id, String nom, String prenom, String numero){
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.numero = numero;
    }
    
    public Abonne(String id, String nom, String prenom, String numero, LocalDate dateInscription , boolean statutSouscription){
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.numero = numero;
        this.dateInscription = dateInscription;
        this.statutSouscription = statutSouscription;
    }

    public String getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getNumero() {
        return numero;
    }

    public LocalDate getDateInscription() {
        return dateInscription;
    }

    public boolean getStatutSouscription() {
        return statutSouscription;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public void setStatutSouscription(boolean statutSouscription) {
        this.statutSouscription = statutSouscription;
    }

    public void setDateInscription(LocalDate dateInscription) {
        this.dateInscription = dateInscription;
    }
    

    
    @Override
    public String toString() {
        return "Abonne{" + "id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", numero=" + numero + ", dateInscription=" + dateInscription + ", statutSouscription=" + statutSouscription + '}';
    }
    
    
}
