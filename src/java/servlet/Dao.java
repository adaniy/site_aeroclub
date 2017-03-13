package servlet;
 
import java.net.Socket;
import java.sql.*;
 
/**
 *
 * @author alexandre
 */
public class Dao{
    Connection connection;
    Statement statement;
    String SQL;
   
 //   String url = "jdbc:postgresql://192.168.168.40:5432/aeroclub";
    String url = "jdbc:postgresql://localhost:5432/aeroclub";
    String user = "postgres";
    String passwd = "root";
    Socket client;
    int port;
    String host;
   
      
    //fonction qui permet la connection a la base de données
    public Connection connexionDatabase(){
        try{
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(url, user, passwd);
        }catch(Exception e){
            System.out.println("erreur lors de la connexion");
            System.out.println(e.getMessage());
        }
        return connection;
    }
   
    public Connection closeConnexion(){
        try{
            connection.close();
        }catch(Exception e){
            System.err.println(e);
        }
        return connection;
    }
   
    public int executionQueryMembre(String nomTable,String login,String password) {
        int resultat=0;
        connexionDatabase();
        ResultSet resultSet = null;
        SQL = "SELECT count(*) FROM "+ nomTable+" WHERE nom='"+ login+"' and password_membre='"+password+"'";
        resultSet=this.executionQuery(SQL);
        System.out.println(SQL);
        try {
            resultSet.next();
            resultat= resultSet.getInt(1);  // on recupère le nombre de membre avec login et mdp .. 1 ou 0
        } catch (Exception e) {
            System.out.println(e.toString());
	} 
        
        return resultat;
    }
     public int executionQueryDroit(String nomTable,String login,String password) {
        int resultat=0;
        connexionDatabase();
        ResultSet resultSet = null;
        SQL = "SELECT droit_membre FROM "+ nomTable+" WHERE nom='"+ login+"' and password_membre='"+password+"'";
        resultSet=this.executionQuery(SQL);
        System.out.println(SQL);
        try {
            resultSet.next();
            resultat= resultSet.getInt(1);  // on recupère le nombre de membre avec login et mdp .. 1 ou 0
        } catch (Exception e) {
            System.out.println(e.toString());
	} 
        
        return resultat;
    }
     
    public ResultSet executionQueryMoi(String nomTable,String login,String password) {
        connexionDatabase();
        ResultSet resultSet = null;
        SQL = "SELECT * FROM "+ nomTable+" WHERE nom='"+ login+"' and password_membre='"+password+"'";
        resultSet=this.executionQuery(SQL);
       
        return resultSet;
    }
        //fonction d'insertion de données dans une table
  
    public void queryInsertReservation (String nomTable, int v1,int v2,int v3,String date,int v4){
        connexionDatabase();
        int i;
        SQL = "INSERT INTO "+nomTable+"(num_avion,num_membre,num_instructeur,date_vol,confirmation) VALUES('" + v1+"','"+v2+"','"+v3+"','"+date+"','"+v4+"')";
         ResultSet rs=this.executionQuery(SQL);
          
    }
    public void queryInsertTest () {
        connexionDatabase();
        SQL = "INSERT INTO seq_vol (num_avion,num_membre,num_instructeur,date_vol,confirmation) VALUES ('1','3','1','2017-02-01','1')";
        
        ResultSet rs=this.executionQuery(SQL);
    }
    
    //fonction qui sert a l'execution de requetes sql;
    public ResultSet executionQuery(String sql){
        connexionDatabase();
        ResultSet resultSet = null;
        try{
            statement = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
            resultSet = statement.executeQuery(sql);
            System.out.println(sql);
        }catch(SQLException ex){
            System.err.println(ex);
        }
        return resultSet;
    }
   
    //fonction qui execute des requetes d'update
    public String executionUpdate(String sql){
        connexionDatabase();
        String result = "";
        try{
            statement = connection.createStatement();
            statement.executeUpdate(sql);
            result = sql;
        }catch(SQLException ex){
            result = ex.toString();
        }
        return result;
    }
   
    
    //fonction qui retourne le contenu d'une table passée en parametre
    public ResultSet querySelectAll(String nomTable){
        connexionDatabase();
        SQL = "SELECT * FROM "+ nomTable;
        System.out.println(SQL);
        return this.executionQuery(SQL);
    }
   
    //fonction qui retourne le contenu d'une table selon un etat
    public ResultSet querySelectAll(String nomTable, String etat){
        connexionDatabase();
        SQL = "SELECT * FROM "+ nomTable +" WHERE "+ etat;
        return this.executionQuery(SQL);
    }
   
   
    public ResultSet querySelect(String[] nomColonne, String nomTable){
        connexionDatabase();
        int i;
        SQL = "SELECT ";
       
        for(i=0; i<= nomColonne.length -1; i++){
            SQL += nomColonne[i];
            if(i < nomColonne.length -1){
                SQL += ",";
            }
        }
       
        SQL += " FROM "+ nomTable;
        return this.executionQuery(SQL);
    }
   
    public ResultSet fcSelectCommand(String[] nomColonne, String nomTable, String etat){
        connexionDatabase();
        int i;
        SQL = "SELECT ";
       
        for(i = 0; i <= nomColonne.length -1; i++){
            SQL += nomColonne[i];
            if(i < nomColonne.length -1){
                SQL += ",";
            }
        }
       
        SQL += " FROM "+ nomTable +" WHERE "+etat;
        return this.executionQuery(SQL);
    }
   
    //fonction d'insertion de données dans une table
    public String queryInsert(String nomTable, String[] contenuTableau){
        connexionDatabase();
        int i;
        SQL = "INSERT INTO "+ nomTable +" VALUES(";
       
        for(i = 0; i <= contenuTableau.length -1; i++){
            SQL += "'"+ contenuTableau[i] +"'";
            if(i < contenuTableau.length -1){
                SQL += ",";
            }
        }
       
        SQL += ")";
        return this.executionUpdate(SQL);
    }
   
    public String queryInsert(String nomTable, String[] nomColonne, String[] contenuTableau){
        connexionDatabase();
        int i;
        SQL = "INSERT INTO "+ nomTable +"(";
 
        for(i = 0; i <= nomColonne.length -1; i++){
            SQL += nomColonne[i];
            if(i < nomColonne.length -1){
                SQL += ",";
            }
        }
       
        SQL += ") VALUES(";
       
        for(i = 0; i <= contenuTableau.length -1; i++){
            SQL += "'"+ contenuTableau[i] +"'";
            if(i < contenuTableau.length -1){
                SQL += ",";
            }
        }
        SQL += ")";
        return this.executionUpdate(SQL);
    }
   
    //fonction qui modifie un enregistrement
    public String queryUpdate(String nomTable, String[] nomColonne, String[] contenuTableau, String etat){
        connexionDatabase();
        int i;
        SQL = "UPDATE "+ nomTable +" SET ";
       
        for(i = 0; i <= nomColonne.length -1; i++){
            SQL += nomColonne[i]+ "='" + contenuTableau[i] +"'";
            if(i < nomColonne.length -1){
                SQL += ",";
            }
        }
       
        SQL += " WHERE " + etat;
        return this.executionUpdate(SQL);
    }
   
    //fonction pour supprimer
    public String queryDelete(String nomTable){
        connexionDatabase();
        SQL = "DELETE FROM" +nomTable;
        return this.executionUpdate(SQL);
    }
   
    public String queryDelete(String nomTable, String etat){
        connexionDatabase();
        SQL = "DELETE FROM "+ nomTable +" WHERE "+ etat;
        System.out.println(SQL);
        return this.executionUpdate(SQL);
    }

    }

