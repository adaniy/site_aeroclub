<%-- 
    Document   : connection
    Created on : 22 nov. 2016, 09:04:43
    Author     : eleve
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Connection</title>
    </head>
    <body>
        <form action="ServletConnection" method="post">
            <p> Identifiant  : <input name="id" required="required" >     </input> <br />
            <p> Mot de passe : <input type="password" name="mdp" placeholder="" required="required" />  <br />    
            <input type="submit" value="Connection" />
        </form>
        
    </body>
</html>
