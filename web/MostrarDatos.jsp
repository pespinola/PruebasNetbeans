<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%-- 
    Document   : MostrarDatos
    Created on : 10-sep-2016, 15:43:15
    Author     : Usuario
--%>

<%


%>



<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Todas las personas</h1>
    <c:forEach var="listaPersonas" items="${session.scope.persona}">
        Nombre: ${listaPersonas.nombre} <br>
        Edad: ${listaPersonas.edad} <br>
        <br>
        <hr>
    </c:forEach>    
    </body>
</html>
