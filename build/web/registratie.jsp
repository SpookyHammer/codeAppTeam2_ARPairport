<%-- 
    Document   : registratie
    Created on : 18-apr-2018, 10:35:14
    Author     : c1042016
--%>

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
    </body>
</html>