<%-- 
    Document   : overzichtVluchten.jsp
    Created on : 25-apr-2018, 9:30:39
    Author     : c1043194
--%>

<%@page import="hbo5.it.www.beans.Persoon"%>
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
        <%ArrayList<Vlucht> lijstAlleBinnenkomendeVluchten = (ArrayList<Vlucht>) request.getAttribute("lijstAlleBinnenkomendeVluchten");%>
        <%ArrayList<Vlucht> lijstAlleVertrekkendeVluchten = (ArrayList<Vlucht>) request.getAttribute("lijstAlleVertrekkendeVluchten");%>
        <%ArrayList<Vlucht> lijstAlleVluchtenLuchtvaartmaatschappij = (ArrayList<Vlucht>) request.getAttribute("lijstAlleVluchtenLuchtvaartmaatschappij");%>
        <%Persoon persoon = (Persoon) session.getAttribute("persoon");%>
        <%Vlucht vlucht2 = (Vlucht) request.getAttribute("vlucht");%>
        <%ArrayList<Vlucht> vluchtenDatum = (ArrayList<Vlucht>) request.getAttribute("vluchtenDatum");%>

        <h1>Overzicht vluchten</h1>

        <table border="1" cellpadding="3">
            <thead>
                <tr>
                    <td>Vluchtnummer:</td>
                    <td>Vertrek luchthaven:</td>
                    <td width="100">Geplande vertrektijd:</td>
                    <td>Aankomst luchthaven:</td>
                    <td>Geplande aankomsttijd:</td>
                    <%if (persoon != null && persoon.getSoort() == 'P') {%>
                    <td> Boek vlucht </td>
                    <%}
                        if (persoon != null && persoon.getSoort() == 'B') {%>
                    <td> Bekijk Passagierslijst </td>
                    <%}%> 
                </tr>
            </thead>
            <tbody>

                <%  if (lijstAlleBinnenkomendeVluchten != null) {
                        for (Vlucht vlucht : lijstAlleBinnenkomendeVluchten) {%>
                <tr>
                    <td> <%=vlucht.getCode()%></td>
                    <td><%=vlucht.getVertrekluchthaven().getLuchthavennaam()%></td>
                    <td> <%=vlucht.getVertrektijd()%></td>
                    <td><%=vlucht.getAankomstluchthaven().getLuchthavennaam()%></td>
                    <td> <%=vlucht.getAankomsttijd()%></td> 
                    <%if (persoon != null && persoon.getSoort() == 'P') {%>
                    <td> <button value="<%=vlucht.getCode()%>" name="knopVluchtBoeken" >Vlucht boeken</button> </td>
                    <% }
                        if (persoon != null && persoon.getSoort() == 'B') {%>
            <form action="ManageServlet">
                <td> <button type="submit" value="<%=vlucht.getCode()%>" name="knopPassagierslijstZoeken" >Passagierslijst</button> </td>
            </form>
            <%}%>
        </tr>

        <%}
        } else if (lijstAlleVertrekkendeVluchten != null) {
            for (Vlucht vlucht : lijstAlleVertrekkendeVluchten) {%>
        <tr>
            <td> <%=vlucht.getCode()%></td>
            <td><%=vlucht.getVertrekluchthaven().getLuchthavennaam()%></td>
            <td> <%=vlucht.getVertrektijd()%></td>
            <td><%=vlucht.getAankomstluchthaven().getLuchthavennaam()%></td>
            <td> <%=vlucht.getAankomsttijd()%></td>
            <%if (persoon != null && persoon.getSoort() == 'P') {%>
            <td> <button value="<%=vlucht.getCode()%>" name="knopVluchtBoeken" >Vlucht boeken</button> </td>
            <%}
                if (persoon != null && persoon.getSoort() == 'B') {%>
        <form action="ManageServlet">
            <td> <button type="submit" value="<%=vlucht.getCode()%>" name="knopPassagierslijstZoeken" >Passagierslijst</button> </td>
        </form>
        <%}%>
    </tr>

    <%}
    } else if (lijstAlleVluchtenLuchtvaartmaatschappij != null) {
        for (Vlucht vlucht : lijstAlleVluchtenLuchtvaartmaatschappij) {%>
    <tr>
        <td> <%=vlucht.getCode()%></td>
        <td><%=vlucht.getVertrekluchthaven().getLuchthavennaam()%></td>
        <td> <%=vlucht.getVertrektijd()%></td>
        <td><%=vlucht.getAankomstluchthaven().getLuchthavennaam()%></td>
        <td> <%=vlucht.getAankomsttijd()%></td> 
        <%if (persoon != null && persoon.getSoort() == 'P') {%>
        <td> <button value="<%=vlucht.getCode()%>" name="knopVluchtBoeken" >Vlucht boeken</button> </td>
        <%}
            if (persoon != null && persoon.getSoort() == 'B') {%>
    <form action="ManageServlet">
        <td> <button type="submit" value="<%=vlucht.getCode()%>" name="knopPassagierslijstZoeken" >Passagierslijst</button> </td>
    </form>
    <%}%>
</tr>                   
<%}
} else if (vlucht2 != null) {%>
<tr>
    <td> <%=vlucht2.getCode()%></td>
    <td><%=vlucht2.getVertrekluchthaven().getLuchthavennaam()%></td>
    <td> <%=vlucht2.getVertrektijd()%></td>
    <td><%=vlucht2.getAankomstluchthaven().getLuchthavennaam()%></td>
    <td> <%=vlucht2.getAankomsttijd()%></td> 
    <%if (persoon != null && persoon.getSoort() == 'P') {%>
    <td> <button value="<%=vlucht2.getCode()%>" name="knopVluchtBoeken" >Vlucht boeken</button> </td>
    <%}
        if (persoon != null && persoon.getSoort() == 'B') {%>
<form action="ManageServlet">
    <td> <button type="submit" value="<%=vlucht2.getCode()%>" name="knopPassagierslijst" >Passagierslijst</button> </td>
</form>
<%}%>
</tr>                   
<%} else if (vluchtenDatum != null) {
    for (Vlucht vlucht : vluchtenDatum) {%>
<tr>
    <td><%=vlucht.getCode()%></td>
    <td><%=vlucht.getVertrekluchthaven().getLuchthavennaam()%></td>
    <td> <%=vlucht.getVertrektijd()%></td>
    <td><%=vlucht.getAankomstluchthaven().getLuchthavennaam()%></td>
    <td> <%=vlucht.getAankomsttijd()%></td>  
    <%if (persoon != null && persoon.getSoort() == 'P') {%>
    <td> <button value="<%=vlucht.getCode()%>" name="knopVluchtBoeken" >Vlucht boeken</button> </td>
    <%}
        if (persoon != null && persoon.getSoort() == 'B') {%>
<form action="ManageServlet">
    <td> <input type="submit" value="<%=vlucht.getCode()%>" name="knopPassagierslijstZoeken" >Passagierslijst</button> </td>
</form>
<%}%>
</tr>                   
<%}
    }%>
</tbody>
</table>

<form action="InlogServlet">
    <!-- Zet dit er bij voor een de naam van de gebruiker en een inlog of uitlog button te hebben : -->


    <%if (persoon != null) {%>
    <P>
        <label name="naam"><%=persoon.getVoornaam()%></label>
        <label name="famillienaam"><%=persoon.getFamilienaam()%></label>
    </p>
    <input type="submit" value="Uitloggen" name="UitlogKnop"/>
    <%} else {%>
    <input type="submit" value="Inloggen" name="InlogKnop"/>
    <%}%>
</form> 

<p>  <a href="vluchtenZoeken.jsp">Terug naar zoekpagina</a></p>
<p>  <a href="index.jsp">Terug naar beginpagina</a></p>

</body>
</html>
