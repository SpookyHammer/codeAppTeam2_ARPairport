<%-- 
    Document   : index
    Created on : 18-apr-2018, 10:32:26
    Author     : c1043194
    Team: 2
    Groepsleden: Cools Jasper, Gostek Kaân, Leysen Eline, Winkelmans Quinten
--%>

<%@page import="hbo5.it.www.beans.Persoon"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/bootstrap-1.css" rel="stylesheet" type="text/css"/>
        <title>Startscherm</title>
    </head>
    <body>
        <h1>Paper Flights</h1>
        <p>
            <img src="images/Paperflights.png" alt="afbeelding"/>
        </p>
        <p>
            Team 2
        </p>
        <p>
        <form action="vluchtenZoeken.jsp">
            <input type="submit" value="Vluchten Zoeken" name="OpenZoekpagina"/>
        </form>      
        
        <form action="InlogServlet">
             <!-- Zet dit er bij voor een de naam van de gebruiker en een inlog of uitlog button te hebben : -->
            
            <%Persoon persoon = (Persoon) request.getAttribute("persoon");
            if(persoon != null){%>
            <P>
                <label name="naam"><%=persoon.getVoornaam() %></label>
                <label name="famillienaam"><%=persoon.getFamilienaam() %></label>
            </p>
            <input type="submit" value="Uitloggen" name="UitlogKnop"/>
           <%} else {%>
            <input type="submit" value="Inloggen" name="InlogKnop"/>
            <%}%>
        </form>        
        
        <a href="registratie.jsp">Registratietest</a>
        </p>
    </body>
</html>
