/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domaine;

/**
 *
 * @author eleve
 */
public class Membre {
    public int num_membre;
    public String nom;
    public String prenom;
    public String adresse;
    public int code_postal;
    public String ville;
    public String tel;
    public String portable;
    public String email;
    
    
    
    public Membre(int num_membre, String nom, String prenom, String adresse, int code_postal, String ville, String tel, String portable, String email ) {
        this.num_membre = num_membre;
        this.nom = nom;
        this.prenom = prenom;
        this.adresse = adresse;
        this.code_postal = code_postal;
        this.ville = ville;
        this.tel = tel;
        this.portable = portable;
        this.email = email;
    }

    public int getNum_membre() {
        return num_membre;
    }

    public void setNum_membre(int num_membre) {
        this.num_membre = num_membre;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public int getCode_postal() {
        return code_postal;
    }

    public void setCode_postal(int code_postal) {
        this.code_postal = code_postal;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }
    
    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }       
    
     public String getPortable() {
        return portable;
    }

    public void setPortable(String portable) {
        this.portable = portable;
    }   
    
     public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }   
    
}
