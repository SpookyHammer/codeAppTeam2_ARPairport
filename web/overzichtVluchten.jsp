<%-- 
    Document   : overzichtVluchten.jsp
    Created on : 25-apr-2018, 9:30:39
    Author     : c1043194
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="hbo5.it.www.beans.Vlucht"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Overzicht vluchten</title>
    </head>
    <body>
        <!-- mag deze weg? , ben niet zeker of ik deze vorige les had toegevoegd of iemand anders.. -->
        <%ArrayList<Vlucht> lijstAlleVluchten = (ArrayList<Vlucht>) request.getAttribute("lijstAlleVluchten");%> 
        
        <%ArrayList<Vlucht> lijstAlleBinnenkomendeVluchten = (ArrayList<Vlucht>) request.getAttribute("lijstAlleBinnenkomendeVluchten");%>
        
        <h1>Overzicht vluchten</h1>
        
        <table border="1" cellpadding="3">
                <thead>
                    <tr>
                        <td>Vluchtnummer:</td>
                        <td>Vertrek luchthaven:</td>
                        <td>Geplande vertrektijd:</td>
                        <td>Aankomst luchthaven:</td>
                        <td>Geplande aankomsttijd:</td>
                    </tr>
                </thead>
                <tbody>
                    
                        <%  if (lijstAlleBinnenkomendeVluchten != null) {
                            for (Vlucht vlucht : lijstAlleBinnenkomendeVluchten) 
                    {%>
                    <tr>
                        <td> <%=vlucht.getCode()%></td>
                        <td><%=vlucht.getVertrekluchthaven() %></td>
                        <td> <%=vlucht.getVertrektijd() %></td>
                        <td><%=vlucht.getAankomstluchthaven() %></td>
                        <td> <%=vlucht.getAankomsttijd() %></td> 
                    </tr>
                    <%}
                        }else //kijken of lijst vertrekkende vluchten opgevuld is en deze resultaten tonen %>
                        
                </tbody>
            </table>
                
            <p>  <a href="index.jsp">Terug naar beginpagina</a></p>
        
    </body>
</html>
