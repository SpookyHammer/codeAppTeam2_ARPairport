<%-- 
    Document   : Passagierslijst
    Created on : 16-mei-2018, 10:38:19
    Author     : c1042016
--%>

<%@page import="hbo5.it.www.beans.Passagier"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Passagiers</title>
    </head>
    <body>
        <%ArrayList<Passagier> lijstPassagieren = (ArrayList<Passagier>) request.getAttribute("lijstPassagieren");%>
        <h1>Passagierslijst</h1>

        <table border="1" cellpadding="3">
            <thead>
                <tr>
                    <td>Naam:</td>
                    <td>Ingeschreven:</td>
                    <td>Ingecheckt:</td>
                    <td>Plaats:</td>
                    <td>Klasse:</td>                    
                </tr>
            </thead>
            <tbody>
                <% if (lijstPassagieren != null) {
                        for (Passagier passagier : lijstPassagieren) {%>
                <tr>
                    <td><p> <%=passagier.getPersoon().getVoornaam()%> <%=passagier.getPersoon().getFamilienaam()%></p></td>
                    <%if (passagier.getIngeschreven() == 0) {%>
                    <td><p>No</p></td>
                    <%} else {%>
                    <td><p>Yes</p></td>
                    <%}%>
                    <%if (passagier.getIngecheckt()== 0) {%>
                    <td><p>No</p></td>
                    <%} else {%>
                    <td><p>Yes</p></td>
                    <%}%>
                    <td><p><%=passagier.getPlaats()%></p></td>
                    <td><p><%=passagier.getVliegtuigklasse().getKlassenaam()%></p></td>

                </tr>
                <%}
                            }%>
            </tbody>
        </table>
    </body>
</html>
