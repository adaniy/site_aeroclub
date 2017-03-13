<!DOCTYPE html>

<html>
    <head>
        <title>Accueil</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link href="style.css" rel="stylesheet" type="text/css" />
    </head> 
    <body>	
		
        <div id="overflow"> 
            <div id="bandeau">
                 <div id="bandeau_logo1">
                 <p class="centre">
                     <a href="accueil.html">
                         <img src="photo/logo.jpg" alt="AeroClub"/>
                     </a>
                 </p>
                 </div>
                <div id="bandeau_menu"> 
                    <p class="bandeau">
                       <a href="" id="menu_acceuil">Accueil</a>
                       <a href="Planning.jsp" id="Planning">Planning</a>
                       <a href="avions.jsp" id="Avions">Avions</a>
                    </p>
                </div>
                <form action="ServletAvion" method="post">
                    <input type="submit" value="Avions" />
                </form>
                <form action="ServletPlanning" method="post">
                    <input type="submit" value="Planning" />
                </form>
                  <form action="ServletMembre" method="post">
                    <input type="submit" value="Membre" />
                </form>
                   
                <p> Vous êtes connecté en tant que : <%out.print(request.getAttribute("login"));%> </p>
            </div>
            <div class="accueil">
                <p class="centre"><img src="photo/avion.jpg" alt="AeroClub"  /></p>
            </div>
        </div>
    <div id=copyright>
        <p>Copyright© AeroClub</p>
    </div>
    </body>
</html>
