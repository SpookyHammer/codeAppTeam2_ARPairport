<%-- 
    Document   : aanpassenBemanning
    Created on : 15-mei-2018, 15:33:04
    Author     : c1045286
--%>

<%@page import="hbo5.it.www.beans.Luchtvaartmaatschappij"%>
<%@page import="hbo5.it.www.beans.Functie"%>
<%@page import="java.util.ArrayList"%>
<%@page import="hbo5.it.www.beans.Persoon"%>
<%@page import="hbo5.it.www.beans.Bemanningslid"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%ArrayList<Functie> lijstAlleFuncties = (ArrayList<Functie>) request.getAttribute("lijstAlleFuncties");%>
        <%ArrayList<Luchtvaartmaatschappij> lijstAlleLuchtvaartmaatschappijen = (ArrayList<Luchtvaartmaatschappij>) request.getAttribute("lijstAlleLuchtvaartmaatschappijen");%>
        <%Bemanningslid bemanningslid = (Bemanningslid) request.getAttribute("bemanningslid");%>
        <h1>Overzicht vluchten</h1>

        <table>
            <thead>
                <tr>
                    <td>Naam:</td>
                    <td>Familienaam:</td>
                    <td>Functie:</td>
                    <td>Luchtvaartmaatschappij:</td>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <td> <%=bemanningslid.getPersoon().getVoornaam()%></td>
                    <td> <%=bemanningslid.getPersoon().getFamilienaam()%></td>
                    <td> <%=bemanningslid.getFunctie().getFunctienaam()%></td>
                    <td> <%=bemanningslid.getLuchtvaartmaatschappij().getLuchtvaartnaam()%></td>
                </tr>
            </tbody>
        </table>
        <form action="AdminServlet">
            <input type="hidden" value="<%=bemanningslid.getId()%>" name="Id"/>
            <%if (lijstAlleFuncties != null) {%>
            <p>
                <label for="functies">Kies een functie:</label>
                <select name ="functies">
                    <option value="0">---Kies hier je functie---</option>
                    <% for (Functie functie : lijstAlleFuncties) {%>
                    <option value="<%=functie.getId()%>"><%=functie.getFunctienaam()%> </option>
                    <%}%>
                </select>
            </p>
            <%}%>

            <%if (lijstAlleLuchtvaartmaatschappijen != null) {%>
            <p>
                <label for="maatschappij">Kies een maatschappij:</label>
                <select name ="maatschappij">
                    <option value="0">---Kies hier je maatschappij---</option>
                    <% for (Luchtvaartmaatschappij luchtvaartmaatschappij : lijstAlleLuchtvaartmaatschappijen) {%>
                    <option value="<%=luchtvaartmaatschappij.getId()%>"><%=luchtvaartmaatschappij.getLuchtvaartnaam()%> </option>
                    <%}%>
                </select>
            </p>
            <%}%>

            <input type="submit" value="Aanpassen" name="AanpasKnop"/>
        </form>

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
