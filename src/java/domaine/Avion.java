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
public class Avion {
    public int num_avion;
    public int num_forfait;
    public String typeavion;
    public String taux;
    public String reduction_semaine;
    public String immatriculation;
    
    
    public Avion(int num_avion, int num_forfait, String typeavion, String taux, String reduction_semaine, String immatriculation) {
        this.num_avion = num_avion;
        this.num_forfait = num_forfait;
        this.typeavion = typeavion;
        this.taux = taux;
        this.reduction_semaine = reduction_semaine;
        this.immatriculation = immatriculation;
    }

    public int getNum_avion() {
        return num_avion;
    }

    public void setNum_avion(int num_avion) {
        this.num_avion = num_avion;
    }

    public int getNum_forfait() {
        return num_forfait;
    }

    public void setNum_forfait(int num_forfait) {
        this.num_forfait = num_forfait;
    }

    public String getTypeavion() {
        return typeavion;
    }

    public void setTypeavion(String typeavion) {
        this.typeavion = typeavion;
    }

    public String getTaux() {
        return taux;
    }

    public void setTaux(String taux) {
        this.taux = taux;
    }

    public String getReduction_semaine() {
        return reduction_semaine;
    }

    public void setReduction_semaine(String reduction_semaine) {
        this.reduction_semaine = reduction_semaine;
    }

    public String getImmatriculation() {
        return immatriculation;
    }

    public void setImmatriculation(String immatriculation) {
        this.immatriculation = immatriculation;
    }
           
    
}
