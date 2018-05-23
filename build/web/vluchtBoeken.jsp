<%-- 
    Document   : vluchtBoeken
    Created on : 9-mei-2018, 11:41:55
    Author     : Eline
--%>

<%@page import="hbo5.it.www.beans.Passagier"%>
<%@page import="hbo5.it.www.beans.Vliegtuigklasse"%>
<%@page import="java.util.ArrayList"%>
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
        <%ArrayList<Vliegtuigklasse> lijstVliegtuigklasses = (ArrayList<Vliegtuigklasse>) request.getAttribute("lijstVliegtuigklasses");%>
        <%ArrayList<Passagier> lijstPassagiers = (ArrayList<Passagier>) request.getAttribute("lijstPassagiers");%>
        <%ArrayList<String> lijstPlaatsen = (ArrayList<String>) request.getAttribute("lijstPlaatsen");%>

        <h1>Boek hier uw vlucht naar <%=vlucht.getAankomstluchthaven().getLuchthavennaam()%>, <%vlucht.getAankomstluchthaven().getLand().getLandnaam();%></h1>

        <form action="ManageServlet">
            <input type="hidden" value="<%=vlucht.getCode()%>"/>
            <p>
                <label>Luchthaven van vertrek:</label>
                <input type="text" value="<%=vlucht.getVertrekluchthaven().getLuchthavennaam()%>" readonly/>
            </p>
            <p>
                <label>Luchthaven van aankomst:</label>
                <input type="text" value="<%=vlucht.getAankomstluchthaven().getLuchthavennaam()%>" readonly/>
            </p>
            <p>
                <label>Datum van vertrek:</label>
                <input type="text" value="<%=vlucht.getVertrektijd().toString()%>" readonly/>
            </p>
            <p>
                <label>Datum van aankomst:</label>
                <input type="text" value="<%=vlucht.getAankomsttijd().toString()%>" readonly/>
            </p>
            <p>
                <label>Naam:</label>
                <input type="text" value="<%=persoon.getFamilienaam()%> <%=persoon.getVoornaam()%>" readonly/>
            </p>
            <p>
                <label name ="vliegtuigklasse">Keuze vliegtuigklasse:</label>
                <select name ="vliegtuigklasse">
                    <option value="0">---Kies hier uw klasse---</option>
                    <% for (Vliegtuigklasse vliegtuigklasse : lijstVliegtuigklasses) {%>
                    <option value="<%=vliegtuigklasse.getId()%>"><%=vliegtuigklasse.getKlassenaam()%> </option>
                    <%}%>
                </select>
            </p>
            <p>
                <label>Selecteer uw zitplaats</label>
                <%for (Passagier passagier : lijstPassagiers) {
                    for (int i = 0; i < lijstPlaatsen.size(); i++) {
                        if (passagier.getPlaats().equals(lijstPlaatsen.get(i))) {
                                lijstPlaatsen.remove(i);   
                                }
                        }                  
                }%>
                <select name="zitplaats">
                    <option value="0">---Kies hier uw zitplaats---</option>
                    <% for (String plaats : lijstPlaatsen) {%>
                    <option value="<%=plaats%>"><%=plaats%></option>
                <%}%>
                </select>
            </p>
            
            <p>
                <input type="submit" name="registreerGeboekteVlucht" value="Boek deze vlucht"/>
            </p>
        </form>
    </body>
</html>
