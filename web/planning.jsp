<%@page import="java.util.List"%>
<%@page import="servlet.Dao"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="domaine.Planning" %>
<!DOCTYPE html>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Liste des avions</title>
        <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
  <link rel="stylesheet" href="/resources/demos/style.css">
  <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
  <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
 
           <script>
  $( function() {
    $( "#datepicker" ).datepicker();
  } );
  </script>
    </head>
    <body>
       
        <p> Liste des avions </p>
       
    </body>
      
       
        <p>
          <%   
            List<Planning> laListe = (List<Planning>)request.getAttribute("planning") ;
            %>
            <title> Liste des modèles</title>
            <%
         int numLigne=0;
         for(Planning pln : laListe ){
            %>
              <p><span><%= numLigne++ %></span><span class="avions" >Num d'avion: <%= pln.getNum_avion() %> Membre : <%= pln.getNum_membre()%></span></p>
            <%
         }%>
          </p>
          
          

  
  <p>Date: <input type="text" id="datepicker"></p>
    <div id=copyright>
        <p>Copyright© AeroClub</p>
    </div>
    </body>
</html>