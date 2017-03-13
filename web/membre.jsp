<%@page import="java.util.List"%>
<%@page import="servlet.Dao"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="domaine.Membre" %>
<!DOCTYPE html>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="style.css" rel="stylesheet" type="text/css" />
        <title>Liste des membres</title>
    </head>
    <body>
       <p> Liste des membres </p>
    </body>
        <p>
            <%   
            List<Membre> laListe = (List<Membre>)request.getAttribute("membres") ;
             %>
            <title> Liste des membres</title>
        <div id="tableau">
            <table >
                <caption> Liste des membres</caption>
                <tbody>
                <tr>
                    <td>Numéro</td>
                    <td>Nom</td>
                    <td>Prénom</td>
                    <td>Adresse</td>
                    <td>Code Postal</td>
                    <td>Ville</td>
                    <td>Télephone</td>
                    <td>Portable</td>
                    <td>Email</td>
                </tr>
            <%
            for(Membre mbr : laListe ){
            %>
		<tr><!-- seconde ligne du tableau et première de tbody-->
                    <td> <%= mbr.getNum_membre() %></td>
                    <td> <%= mbr.getNom()%></td>
                    <td> <%= mbr.getPrenom() %></td>
                    <td> <%= mbr.getAdresse() %></td>
                    <td> <%= mbr.getCode_postal() %></td>
                    <td> <%= mbr.getVille() %></td>
                    <td> <%= mbr.getTel() %></td>
                    <td> <%= mbr.getPortable() %></td>
                    <td> <%= mbr.getEmail() %></td>
                 </tr>	
            <%
            }
            %>
                </tbody>
            </table>
                </div>
         </p>
        <div id=copyright>
             <p>Copyright© AeroClub</p>
        </div>
        </body>
</html>