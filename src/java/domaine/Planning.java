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
public class Planning {
    public int num_avion;
    public int num_membre;
    public String date_vol;
    public int temps;
    public int confirmation;

    
    public Planning(int num_avion, int num_membre, String date_vol, int temps,int confirmation) {
        this.num_avion = num_avion;
        this.num_membre = num_membre;
        this.date_vol = date_vol;
        this.temps = temps;
        this.confirmation=confirmation;
    }

    public int getConfirmation() {
        return confirmation;
    }

    public void setConfirmation(int confirmation) {
        this.confirmation = confirmation;
    }
    public int getNum_avion() {
        return num_avion;
    }

    public void setNum_avion(int num_avion) {
        this.num_avion = num_avion;
    }

    public int getNum_membre() {
        return num_membre;
    }

    public void setNum_membre(int num_membre) {
        this.num_membre = num_membre;
    }

    public String getdate_vol() {
        return date_vol;
    }

    public void setdate_vol(String date_vol) {
        this.date_vol = date_vol;
    }

    public int getTemps() {
        return temps;
    }

    public void setTemps(int temps) {
        this.temps = temps;
    }

       
}
