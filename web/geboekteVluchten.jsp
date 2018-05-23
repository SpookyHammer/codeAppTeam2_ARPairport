<%-- 
    Document   : geboekteVluchten
    Created on : 22-mei-2018, 14:41:13
    Author     : Eline
--%>

<%@page import="hbo5.it.www.beans.Vlucht"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Mijn vluchten</title>
    </head>
    <body>
        <%ArrayList<Vlucht> lijstVluchten = (ArrayList<Vlucht>) request.getAttribute("lijstVluchten");%>
        
        <h1>Mijn vluchten</h1>
        
        <table border="1" cellpadding="3">
            <thead>
                <tr>
                    <td>Vluchtnummer:</td>
                    <td>Vertrek:</td>
                    <td>Aankomst:</td>
                    <td>Luchtvaartmaatschappij:</td>
                </tr>
            </thead>
            <tbody>
                <%if (lijstVluchten != null) {
                    for (Vlucht vlucht : lijstVluchten) 
                    {%>
                    <tr>
                        <td> <%=vlucht.getCode()%></td>
                        <td> <%=vlucht.getVertrekluchthaven().getLuchthavennaam()%> <br/> <%=vlucht.getAankomsttijd().toString()%> </td>
                        <td> <%=vlucht.getAankomstluchthaven().getLuchthavennaam()%> <br/> <%=vlucht.getVertrektijd().toString()%> </td>
                        <td> <%=vlucht.getVliegtuig().getLuchtvaartmaatschappij().getLuchtvaartnaam()%> </td>
                    </tr>
                    <%}}%>
            </tbody>
        </table>
    </body>
</html>
