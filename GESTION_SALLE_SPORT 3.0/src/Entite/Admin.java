/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entite;

/**
 *
 * @author abdou-jabar
 */
@SuppressWarnings("unused")
public class Admin {
    private String nomAdmin;
    private String motDePasseAdmin;
    
    public Admin(){
        
    }

    public Admin(String nomAdmin, String motDePasseAdmin) {
        this.nomAdmin = nomAdmin;
        this.motDePasseAdmin = motDePasseAdmin;
    }

    public String getNomAdmin() {
        return nomAdmin;
    }

    public String getMotDePasseAdmin() {
        return motDePasseAdmin;
    }

    public void setNomAdmin(String nomAdmin) {
        this.nomAdmin = nomAdmin;
    }

    public void setMotDePasseAdmin(String motDePasseAdmin) {
        this.motDePasseAdmin = motDePasseAdmin;
    }
    
}
