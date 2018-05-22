<%-- 
    Document   : aanpassenBemanning
    Created on : 15-mei-2018, 15:33:04
    Author     : c1045286
--%>

<%@page import="hbo5.it.www.beans.Persoon"%>
<%@page import="hbo5.it.www.beans.Bemanningslid"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <!-- nieuw -->
        <%Bemanningslid bemanningslid = (Bemanningslid) request.getAttribute("Bemanningslid");%>
        <h1>Overzicht vluchten</h1>
        
        <table border="1" cellpadding="3">
                <thead>
                    <tr>
                        <td>Naam:</td>
                        <td>Familienaam:</td>
                        <td>Functie:</td>
                    </tr>
                </thead>
                
                        <td> <%=bemanningslid.getPersoon().getVoornaam() %></td>
                        <td> <%=bemanningslid.getPersoon().getFamilienaam() %></td>
                        <td> <%=bemanningslid.getFunctie().getFunctienaam() %></td>
                        </tr>
                    
                
            </table>
             <!-- EINDE NIEUW -->   
                <form action="InlogServlet">
             <!-- Zet dit er bij voor een de naam van de gebruiker en een inlog of uitlog button te hebben : -->
            
            <%Persoon persoon = (Persoon) session.getAttribute("persoon");
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
