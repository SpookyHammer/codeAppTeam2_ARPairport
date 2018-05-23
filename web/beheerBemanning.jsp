<%-- 
    Document   : beheerBemanning
    Created on : 9-mei-2018, 11:19:28
    Author     : c1045286
--%>

<%@page import="hbo5.it.www.beans.Persoon"%>
<%@page import="hbo5.it.www.beans.Bemanningslid"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%ArrayList<Bemanningslid> lijstalleBemanningsleden = (ArrayList<Bemanningslid>) request.getAttribute("lijstalleBemanningsleden");%>
        <h1>Overzicht vluchten</h1>

        <table border="1" cellpadding="3">
            <thead>
                <tr>
                    <td>Naam:</td>
                    <td>Familienaam:</td>
                    <td>Functie:</td>
                    <td>Luchtvaartmaatschappij:</td>
                </tr>
            </thead>
            <tbody>

                <%  if (lijstalleBemanningsleden != null) {
                                for (Bemanningslid bemanningslid : lijstalleBemanningsleden) {%>
                <tr>
                    <% String Id = "bemmaningslid.getId()";%>
                    <td> <%=bemanningslid.getPersoon().getVoornaam()%></td>
                    <td> <%=bemanningslid.getPersoon().getFamilienaam()%></td>
                    <td> <%=bemanningslid.getFunctie().getFunctienaam()%></td>
                    <td> <%=bemanningslid.getLuchtvaartmaatschappij().getLuchtvaartnaam()%></td>
                    <td><button name="Aanpassen" value="<%=bemanningslid.getId()%>">Aanpassen</button></td>
                    <td><button name="Verwijderen" value="<%=bemanningslid.getId()%>">Verwijderen</button></td>

            <form action="AdminServlet"> 
                <td><a href="?OpenBeheerbemanning=Beheren&actie=aanpassen&Id=<%=bemanningslid.getId()%>">Aanpassen</a></td>
                <td><a href="?OpenBeheerbemanning=Beheren&actie=verwijderen&Id=<%=bemanningslid.getId()%>">Verwijderen</a></td>
            </form>

        </tr>
        <%}
                        }%>
    </tbody>
</table>
<form action="InlogServlet">
    <!-- Zet dit er bij voor een de naam van de gebruiker en een inlog of uitlog button te hebben : -->

    <%Persoon persoon = (Persoon) session.getAttribute("persoon");
                if (persoon != null) {%>
    <P>
        <label name="naam"><%=persoon.getVoornaam()%></label>
        <label name="famillienaam"><%=persoon.getFamilienaam()%></label>
    </p>
    <input type="submit" value="Uitloggen" name="UitlogKnop"/>
    <%} else {%>
    <input type="submit" value="Inloggen" name="InlogKnop"/>
    <%}%>
</form> 

<p>  <a href="index.jsp">Terug naar beginpagina</a></p>

</body>
</html>
