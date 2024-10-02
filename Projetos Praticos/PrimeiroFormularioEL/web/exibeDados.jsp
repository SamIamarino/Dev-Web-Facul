<%-- 
    Document   : exibeDados
    Created on : 30 de set. de 2024, 21:25:54
    Author     : Samuel Iamarino
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <ul>
            <li>${requestScope.produtoObtido.codigoBarra}</li>
            <li>${requestScope.produtoObtido.descricao}</li>
            <li>${requestScope.produtoObtido.unidadeMedida}</li>
            <li>${requestScope.produtoObtido.quantidadeEmbalagem}</li>
        </ul>
    </body>
</html>
