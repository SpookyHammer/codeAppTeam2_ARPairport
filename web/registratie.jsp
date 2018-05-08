<%-- 
    Document   : registratie
    Created on : 18-apr-2018, 10:35:14
    Author     : c1042016
--%>

<%@page import="hbo5.it.www.beans.Persoon"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Registratie</h1>
        
        <form action="InlogServlet">
            <label>Username: </label> <input type="text" name="username"></input><br/>
            <label>Paswoord: </label> <input type="text" name="username"></input><br/>
            <label>Voornaam: </label> <input type="text" name="username"></input><br/>
            <label>Familienaam: </label> <input type="text" name="username"></input><br/>
            <label>Straat: </label> <input type="text" name="username"></input><br/>
            <label>Huisnr: </label> <input type="text" name="username"></input><br/>
            <label>Postcode: </label> <input type="text" name="username"></input><br/>
            <label>Woonplaats: </label> <input type="text" name="username"></input><br/>
            <label>Land: </label> <input type="text" name="username"></input><br/>
            <label>Geboortedatum: </label> <input type="text" name="username"></input><br/>
            
            <input type="submit" value="registreren" Name="RegistratieKnop"></input>
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
        
        
    </body>
</html>