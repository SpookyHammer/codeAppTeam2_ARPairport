<%-- 
    Document   : vluchtenZoeken
    Created on : 25-apr-2018, 9:50:39
    Author     : c1043194
--%>

<%@page import="hbo5.it.www.beans.Persoon"%>
<%@page import="hbo5.it.www.beans.Luchthaven"%>
<%@page import="java.util.ArrayList"%>
<%@page import="hbo5.it.www.beans.Vlucht"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Vluchten zoeken</title>
    </head>
    <body>
        <%ArrayList<Luchthaven> lijstAlleLuchthavens = (ArrayList<Luchthaven>) request.getAttribute("lijstAlleLuchthavens");%>
        
        <h1>Zoek hier uw vlucht</h1>
        
        <form action="ZoekServlet">
            <p>
                <label for="keuzeLuchthaven">Ik wil zoeken op:</label>
                <select name ="keuzeLuchthaven">
                    <option value="0">---Maak hier je keuze---</option>
                    <option value="vertrek">Luchthaven van vertrek</option>
                    <option value="aankomst">Luchthaven van aankomst</option>
                </select>
            </p>
            <p> <!-- We gebruiken de value van de geslecteerde luchthaven voor zowel de methode van binnenkomende vluchten als vertrekkende vluchten in de zoekServlet -->
                <label for="naamLuchthaven">Naam luchthaven:</label>
                <select name ="naamLuchthaven">
                    <option value="0">---Kies hier je luchthaven---</option>
                    <% for (Luchthaven luchthaven : lijstAlleLuchthavens) {%>
                    <option value="<%=luchthaven.getId() %>"><%=luchthaven.getLuchthavennaam() %>, <%=luchthaven.getLand().getLandnaam()%> </option>
                    <%}%>
                </select>
            </p>
            <input type="submit" value="Zoeken" name="ZoekKnop"/>
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
        
        <p>  <a href="index.jsp">Terug naar beginpagina</a></p>
    </body>
</html>
