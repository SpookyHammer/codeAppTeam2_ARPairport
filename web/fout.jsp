<%-- 
    Document   : fout
    Created on : 25-apr-2018, 9:35:27
    Author     : c1042016
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Foutpagina</title>
    </head>
    <body>

        <h1>Er is iets fout gegaan!</h1>
        <%
            String foutmelding = (String)request.getAttribute("foutmelding");
        %>
        <p><%=foutmelding %></p>
        
        <a href="index.jsp">Home</a>
    </body>
</html>
