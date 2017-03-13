<%@page import="java.util.List"%>
<%@page import="servlet.Dao"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="domaine.Avion" %>
<!DOCTYPE html>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Liste des avions</title>
    </head>
    <body>
       <p> Liste des avions </p>
    </body>
       <%   
            List<Avion> laListe = (List<Avion>)request.getAttribute("avions") ;
            %>
            <table>
	<caption> Liste des avions</caption>
	<tbody>
            <tr>
                <td>Numéro</td>
                <td>Immatriculation</td>
                <td>Planning</td>
            </tr>
            <%
            for(Avion avn : laListe ){
            %>
            <tr><!-- seconde ligne du tableau et première de tbody-->
		<td> <%= avn.getNum_avion() %></td>
                <td> <%= avn.getImmatriculation()%></td>
                <td><input type="submit" value="Planning" /></td>
            </tr>	
            <%
            }
            %>
	</tbody>
        <p>
<div id=copyright>
    <p>Copyright© AeroClub</p>
</div>
</body>
</html>