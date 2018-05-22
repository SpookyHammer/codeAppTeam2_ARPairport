<%-- 
    Document   : adminbeheer
    Created on : 9-mei-2018, 10:58:48
    Author     : c1045286
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
        <form action="AdminServlet">
            <input type="submit" value="Beheren luchthavens" name="OpenBeheerluchthavens"/>
            <input type="submit" value="Beheren luchtvaartmaatschappijen" name="OpenBeheerluchtvaartmaatschappijen"/>
            <input type="submit" value="Beheren vliegtuigen" name="OpenBeheervliegtuigen"/>
            <input type="submit" value="Beheren hangars" name="OpenBeheerhangars"/>
            <input type="submit" value="Beheren bemanning" name="OpenBeheerbemanning"/>
            <input type="submit" value="Beheren vluchtbemanning" name="OpenBeheervluchtbemanning"/>
            <input type="submit" value="Beheren vliegtuigen in hangars" name="OpenBeheervliegtuigeninhangars"/>
        </form>
        
        <form action="InlogServlet">
             <!-- Zet dit er bij voor een de naam van de gebruiker en een inlog of uitlog button te hebben : -->
            
            <%Persoon persoon = (Persoon) session.getAttribute("persoon");
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
