<%-- 
    Document   : vluchtenZoeken
    Created on : 25-apr-2018, 9:50:39
    Author     : c1043194
--%>

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
        <%ArrayList<Vlucht> lijstAlleBinnenkomendeVluchten = (ArrayList<Vlucht>) request.getAttribute("lijstAlleBinnenkomendeVluchten");%>
        
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
            <p>
                <label for="naamLuchthaven">Naam luchthaven:</label>
                <select name ="naamLuchthaven">
                    <option value="0">---Kies hier je luchthaven---</option>
                    <% for (Vlucht vlucht : lijstAlleBinnenkomendeVluchten) {%>
                    <option value="<%=vlucht.getAankomstluchthaven_id() %>"><%=vlucht.getAankomstluchthaven().getLuchthavennaam()%> </option>
                    
                    <option value="2">Luchthaven van vertrek</option>
                    <%}%>
                </select>
            </p>
            
          
            <input type="submit" value="Zoeken" name="ZoekKnop"/>
        </form>  
        
        <p>  <a href="index.jsp">Terug naar beginpagina</a></p>
    </body>
</html>
