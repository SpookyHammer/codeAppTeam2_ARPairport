<%-- 
    Document   : inloggen
    Created on : 24-apr-2018, 13:36:03
    Author     : c1045286
--%>

<%@page import="hbo5.it.www.beans.Persoon"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        
        <div id="headercontainer">
        <title>Inloggen:</title>
    </head>
    <body>
        <h1>Inloggen:</h1>
        <div id="content">  
            <form action="InlogServlet">
                   <p>
                        <label for="Logintext">Login:</label>
                        <input type="text" name="Logintext" value="" id="Logintext"/>
                   </p>
                   <p>
                        <label for="passwoord">Paswoord:</label>
                        <input type="password" name="Passwoordtext" value="" id="Passwoordtext"/>
                   </p>
                   <input type="submit" name="Loginknop" value="Aanmelden"/>
            </form>
            <p>  <a href="index.jsp">Terug naar beginpagina</a></p>
        </div>
    </body>
</html>
