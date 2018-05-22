<%-- 
    Document   : detailVlucht
    Created on : May 16, 2018, 9:00:41 AM
    Author     : Kaân Gostek
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="hbo5.it.www.beans.Vlucht"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Detail pagina</title>
        <style>
            tr{
                padding: 10px;
            }
            td{
                padding-right: 20px;
                padding-bottom: 5px;
            }
        </style>
    </head>
    <body>
        <% Vlucht vlucht = (Vlucht)request.getAttribute("vlucht"); %>
        <h1>Vlucht Detail</h1>
        <table>
            <tr>
                <td>Vlucht code:</td>
                <td><%=vlucht.getCode() %></td>
            </tr>
            <tr>
                <td>Vertrek gegevens:</td>
                <td>
                    <table>
                        <tr>
                            <td>vertrek datum en tijd</td>
                            <td><%=vlucht.getVertrektijd()%></td>
                        </tr>
                        <tr>
                            <td>Vertrek Luchthaven</td>
                            <td><%=vlucht.getVertrekluchthaven().getLuchthavennaam()%></td>
                            <td>(<%=vlucht.getVertrekluchthaven().getStad()%> - <%=vlucht.getVertrekluchthaven().getLand().getLandnaam()%>)</td>
                        </tr>
                    </table>
                </td>
            </tr>
            <tr>
                <td>Aankomst gegevens:</td>
                <td>
                    <table>
                        <tr>
                            <td>Aankomst datum en tijd:</td>
                            <td><%=vlucht.getAankomsttijd()%></td>
                        </tr>
                        <tr>
                            <td>Aankomst Luchthaven</td>
                            <td><%=vlucht.getAankomstluchthaven().getLuchthavennaam()%></td> 
                            <td>(<%=vlucht.getAankomstluchthaven().getStad()%> - <%=vlucht.getAankomstluchthaven().getLand().getLandnaam()%>)</td>
                        </tr>
                    </table>
                </td>
            </tr>
        </table>
        <h1>Vliegtuig</h1>
        <table>
            <tr>
                <td>Luchtvaartmaatschappij</td>
                <td><%=vlucht.getVliegtuig().getLuchtvaartmaatschappij().getLuchtvaartnaam() %></td>
            </tr>
            <tr>
                <td>Type vliegtuig</td>
                <td><%=vlucht.getVliegtuig().getVliegtuigtype().getTypenaam() %></td>
            </tr>
        </table>
    </body>
</html>
