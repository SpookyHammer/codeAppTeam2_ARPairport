<%-- 
    Document   : vluchtBoeken
    Created on : 9-mei-2018, 11:41:55
    Author     : Eline
--%>

<%@page import="hbo5.it.www.beans.Persoon"%>
<%@page import="hbo5.it.www.beans.Vlucht"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Vlucht boeken</title>
    </head>
    <body>
        <%Vlucht vlucht = (Vlucht) request.getAttribute("vlucht");%>
        <%Persoon persoon = (Persoon) session.getAttribute("persoon");%>
        
        <h1>Boek hier uw vlucht naar <%=vlucht.getAankomstluchthaven().getLuchthavennaam()%>, <%vlucht.getAankomstluchthaven().getLand();%></h1>
        
        <form>
            <p>
                <label>Luchthaven van vertrek:</label>
                <input type="text" value="<%=vlucht.getVertrekluchthaven().getLuchthavennaam()%>"/>
            </p>
            <p>
                <label>Luchthaven van aankomst:</label>
                <input type="text" value="<%=vlucht.getAankomstluchthaven().getLuchthavennaam()%>"/>
            </p>
            <p>
                <label>Datum van vertrek:</label>
                <input type="text" value="<%=vlucht.getVertrektijd().toString()%>"/>
            </p>
            <p>
                <label>Datum van aankomst:</label>
                <input type="text" value="<%=vlucht.getAankomsttijd().toString()%>"/>
            </p>
            <p>
                <label>Naam:</label>
                <input type="text" value="<%=persoon.getFamilienaam()%> <%=persoon.getVoornaam()%>"/>
            </p>
            <p>
                <label>Keuze vliegtuigklasse:</label>
                
            </p>

               
            
            <p>
                <input type="submit" name=""/>
            </p>
        </form>
    </body>
</html>
