/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entite;

/**
 *
 * @author abdou-jabar
 */
public class Abonnement {
    
    private String id;
    private String libelle;
    private int dureeMois;
    private float prixMensuel;
    
    public Abonnement(){}
    
    public Abonnement(String id){
        this.id = id;
    }
    
    public Abonnement(String id, String libelle, int dureeMois, float prixMensuel){
        this.id = id;
        this.libelle = libelle;
        this.dureeMois = dureeMois;
        this.prixMensuel = prixMensuel;
    }

    public String getId() {
        return id;
    }

    public String getLibelle() {
        return libelle;
    }

    public int getDureeMois() {
        return dureeMois;
    }

    public float getPrixMensuel() {
        return prixMensuel;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public void setDureeMois(int dureeMois) {
        this.dureeMois = dureeMois;
    }

    public void setPrixMensuel(float prixMensuel) {
        this.prixMensuel = prixMensuel;
    }

}
