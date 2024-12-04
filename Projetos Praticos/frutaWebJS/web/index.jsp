<%-- 
    Document   : index.jsp
    Created on : 3 de dez. de 2024, 09:42:07
    Author     : Samuel Iamarino
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="cp" value="${pageContext.request.contextPath}"/>
<html>
    <head onload="carregarPagina(event)">
        <title>TODO supply a title</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="${cp}/css/style.css"/>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
        <script src="${cp}/js/frutaWeb.js"></script>
    </head>
    <body>
        <div class="main">
            <div class="container-add">
            <div>
                <h3>FrutaWeb</h3>
                <button class="button" onclick="criarFruta(event)">Adicionar sua fruta</button>
            </div>
        </div>
        
            <div class="resposta" id="div-resposta">

            </div>
        </div>
      
    </body>
</html>
