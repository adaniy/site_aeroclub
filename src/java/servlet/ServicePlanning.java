/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;


import domaine.Planning;
import java.sql.Array;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import static servlet.ServiceMembre.array;

/**
 *
 * @author eleve
 */
public class ServicePlanning {

    static Dao bdd = new Dao();
    static ArrayList array
            = new ArrayList();

    public static ArrayList getPlanning() throws SQLException {
    array.clear();
        try {
            bdd.connexionDatabase();
            ResultSet rs;
            rs = bdd.querySelectAll("seq_vol");

            int i = 0;

            while (rs.next()) {
                Planning planning = new Planning(rs.getInt("num_avion"),rs.getInt("num_membre"),rs.getString("date_vol"),rs.getInt("temps"),rs.getInt("confirmation"));
                array.add(planning);
               
                System.out.println(array.get(i));//j'affiche pour vérifier
                 i++;
            }
        } catch (SQLException queryE) {
            System.out.println("Erreur de requête : " + queryE);
        }
        return array;
    }
    public static void setReservation(int val1,int val2,int val3,String date,int val4) throws SQLException {
        bdd.connexionDatabase();
        bdd.queryInsertReservation("seq_vol",val1,val2,val3,date,val4);
      
    }
    
        public static void setReservation() throws SQLException {
        bdd.connexionDatabase();
     //   bdd.queryInsertReservation("seq_vol",val1,val2,val3,date,val4);
      
    }


}
