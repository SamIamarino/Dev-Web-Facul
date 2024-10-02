<%-- 
    Document   : exibedados.jsp
    Created on : 26 de set. de 2024, 15:17:26
    Author     : Samuel Iamarino
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Exibir Dados</title>
    </head>
    <body>
        Descrção: ${requestScope.prod.descricao}
        <br/>
        <a href="index.html">Voltar</a>
    </body>
</html>
