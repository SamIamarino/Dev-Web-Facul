<%-- 
    Document   : exibeDadosDVD
    Created on : 30 de set. de 2024, 21:54:40
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
            <li>${requestScope.produtoDVD.numeroCopias}</li>
            <li>${requestScope.produtoDVD.nomeDVD}</li>
            <li>${requestScope.produtoDVD.atorPrincipal}</li>
            <li>${requestScope.produtoDVD.atorSecundario}</li>
            <li>${requestScope.produtoDVD.diretor}</li>
            <li>${requestScope.produtoDVD.dataLancamento}</li>
        </ul>
    </body>
</html>
