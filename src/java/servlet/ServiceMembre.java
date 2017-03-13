/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import domaine.Membre;
import java.sql.Array;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author eleve
 */
public class ServiceMembre {

    static Dao bdd = new Dao();
    static ArrayList array= new ArrayList();

    public static ArrayList getMembres() throws SQLException {
       array.clear();
        try {
            bdd.connexionDatabase();
            ResultSet rs;
            rs = bdd.querySelectAll("membres");

          

            while (rs.next()) {
                Membre membre = new Membre(rs.getInt("num_membre"),rs.getString("nom"),rs.getString("prenom"),rs.getString("adresse"),rs.getInt("code_postal"),rs.getString("ville"), rs.getString("tel"),rs.getString("portable"),rs.getString("email"));
                array.add(membre);
                System.out.println();//j'affiche pour vérifier
            }
        } catch (SQLException queryE) {
            System.out.println("Erreur de requête : " + queryE);
        }
        return array;
    }
       public static ArrayList getMoi() throws SQLException {
       array.clear();
        try {
            bdd.connexionDatabase();
            ResultSet rs;
            rs = bdd.executionQueryMoi("membres",ServletConnection.login,ServletConnection.mdp);

            int i = 0;

            while (rs.next()) {
                Membre membre = new Membre(rs.getInt("num_membre"),rs.getString("nom"),rs.getString("prenom"),rs.getString("adresse"),rs.getInt("code_postal"),rs.getString("ville"), rs.getString("tel"),rs.getString("portable"),rs.getString("email"));
                array.add(membre);
                System.out.println();//j'affiche pour vérifier
            }
        } catch (SQLException queryE) {
            System.out.println("Erreur de requête : " + queryE);
        }
        return array;
    }
}
