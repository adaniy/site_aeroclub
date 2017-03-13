/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import domaine.Avion;
import java.sql.Array;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author eleve
 */
public class ServiceAvion {

    static Dao bdd = new Dao();
    static ArrayList array= new ArrayList();

    public static ArrayList getAvions() throws SQLException {
       array.clear();
        try {
            bdd.connexionDatabase();
            ResultSet rs;
            rs = bdd.querySelectAll("avions");

            int i = 0;

            while (rs.next()) {
                Avion avion = new Avion(rs.getInt(1),rs.getInt(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6));
                array.add(avion);
                System.out.println();//j'affiche pour vérifier
            }
        } catch (SQLException queryE) {
            System.out.println("Erreur de requête : " + queryE);
        }
        return array;
    }
}
