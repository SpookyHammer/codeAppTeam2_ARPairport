<%-- 
    Document   : vluchtenZoeken
    Created on : 25-apr-2018, 9:50:39
    Author     : c1043194
--%>

<%@page import="hbo5.it.www.beans.Luchtvaartmaatschappij"%>
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
    <script>
        function changeFunction(){
           var dropdown = document.getElementById("selectBoxID")
           var selectedValue = dropdown.options[dropdown.selectedIndex].value;
           document.getElementById("divLuchtvaartmaatschappij").style.display = "none";
           document.getElementById("divLuchthaven").style.display = "none";
           
           if (selectedValue == "maatschappij" ) 
               document.getElementById("divLuchtvaartmaatschappij").style.display = "block"; 
           if (selectedValue == "vertrek" || selectedValue == "aankomst") 
               document.getElementById("divLuchthaven").style.display = "block"; 
    }
        
        
    </script>
    <body>
        <%ArrayList<Luchthaven> lijstAlleLuchthavens = (ArrayList<Luchthaven>) request.getAttribute("lijstAlleLuchthavens");%>
        <%ArrayList<Luchtvaartmaatschappij> lijstAlleLuchtvaartmaatschappijen = (ArrayList<Luchtvaartmaatschappij>) request.getAttribute("lijstAlleLuchtvaartmaatschappijen");%>
       
        
        <h1>Zoek hier uw vlucht</h1>

        <form action="ZoekServlet">
            <p>
                <label for="keuzeLuchthaven">Ik wil zoeken op:</label>
                <select name ="keuzeLuchthaven" id="selectBoxID" onchange="changeFunction();">
                    <option value="0">---Maak hier je keuze---</option>
                    <option value="vertrek">Luchthaven van vertrek</option>
                    <option value="aankomst">Luchthaven van aankomst</option>
                    <option value="maatschappij">Luchtvaartmaatschappij</option>
                </select>
            </p>
            <div style="display:none;" id="divLuchthaven">
                <p> <!-- We gebruiken de value van de geslecteerde luchthaven voor zowel de methode van binnenkomende vluchten als vertrekkende vluchten in de zoekServlet -->
                    <label for="naamLuchthaven">Naam luchthaven:</label>
                    <select name ="naamLuchthaven">
                        <option value="0">---Kies hier je luchthaven---</option>
                        <% for (Luchthaven luchthaven : lijstAlleLuchthavens) {%>
                        <option value="<%=luchthaven.getId()%>"><%=luchthaven.getLuchthavennaam()%>, <%=luchthaven.getLand().getLandnaam()%> </option>
                        <%}%>
                    </select>
                </p>
            </div>
            <div style="display:none;" id="divLuchtvaartmaatschappij">
                <p>
                    <label for="naamMaatschappij">Naam luchtvaartmaatschappij:</label>
                    <select name="naamMaatschappij">
                        <% for (Luchtvaartmaatschappij maatschappij : lijstAlleLuchtvaartmaatschappijen) {%>
                            <option value="<%=maatschappij.getId()%>"><%=maatschappij.getLuchtvaartnaam()%></option>
                        <%}%>
                    </select>
                </p>
            </div>
            <input type="submit" value="Zoeken" name="ZoekKnop"/>
        </form> 

        <form action="ZoekServlet">
            <p>
                <label>Geef datum in de volgende formaat yyyy-mm-dd:</label>
                <input type="text" name="datum">
                <input type="submit" value="ZoekenDatum" name="ZoekDatumKnop"/>
            </p>
        </form>   
            
        <form action="ZoekServlet">
            <p>
                <label>Geef vluchtnummer in om op vluchtnummer te zoeken:</label>
                <input type="text" name="code">
                <input type="submit" value="ZoekenCode" name="ZoekCodeKnop"/>
            </p>
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
