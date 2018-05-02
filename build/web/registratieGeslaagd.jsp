<%-- 
    Document   : regestratieGeslaagd
    Created on : 18-apr-2018, 11:38:47
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
        <h1>Registratie geslaagd</h1>
        
        <p>Dank u, <%=request.getAttribute("voornaam")%></p>
        
        <p>U bent geregistreerd en kan nu vluchten boeken.</p>
        
        <a href="index.jsp">Keer terug naar de hoofdpagina</a>
    </body>
</html>
