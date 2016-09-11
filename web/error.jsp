<%-- 
    Document   : error
    Created on : 10-sep-2016, 16:02:27
    Author     : Usuario
--%>

<%
    String error = (String) request.getSession().getAttribute("error");
%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Error Page</title>
    </head>
    <body>
        <h1>Ha ocurrido un error: <%=error%></h1>
    </body>
</html>
