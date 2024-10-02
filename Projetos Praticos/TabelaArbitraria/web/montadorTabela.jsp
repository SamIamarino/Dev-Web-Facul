<%-- 
    Document   : montadorTabela.jsp
    Created on : 2 de out. de 2024, 10:15:27
    Author     : Samuel Iamarino
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <style>
        table {
            
            width: 50%;
        }
        th, td {
            border: 1px solid black;
            padding: 8px;
            text-align: center;
        }
    </style>
        
    </head>
    <body>
        <!-- gt == Greater Than -->
        <c:choose>
            <c:when test="${(param.numeroLinhas gt 0) and (param.numeroColunas gt 0)}">
                <table>
                    <c:forEach var="i" begin="1" end="${param.numeroLinhas}">
                        <tr>
                            <c:forEach var="j" begin="1" end="${param.numeroColunas}">
                                <td>Linha ${i}, Coluna ${j}</td>
                            </c:forEach>
                        </tr>
                    </c:forEach>
                </table>
            </c:when>
            <c:otherwise>
                <h1>Insira um numero de colunas e linhas valido.</h1>
            </c:otherwise>
        </c:choose>
     
    </body>
</html>
