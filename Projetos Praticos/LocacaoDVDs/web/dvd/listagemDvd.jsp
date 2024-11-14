<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="cp" value="${pageContext.request.contextPath}"/>
<c:set var="prefixo" value="processaDvd?acao=preparar"/>
<!DOCTYPE html>
<html lang="en" id="main">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Star Copy</title>
    <link rel="stylesheet" href="${cp}/css/listagemStyle.css" />
  </head>
  <body>
    <header class="header">
      <nav>
        <a href="${cp}/index.jsp">
            <img src="${cp}/assets/logo-removebg-preview.png" alt="Logo" class="logo" />
          </a>
        <ul>
          <li><a href="${cp}/ator/listagemAtor.jsp" class="nav-link">Ator</a></li>
          <li><a href="${cp}/dvd/listagemDvd.jsp" class="nav-link">Dvd</a></li>
          <li><a href="${cp}/genero/listagemGenero.jsp" class="nav-link">Genero</a></li>
          <li><a href="${cp}/classificacao_etaria/listagemClassificacao.jsp" class="nav-link">Classificação</a></li>
        </ul>
      </nav>
    </header>

    <main>
      <div>
        <table class="tabelaListagem" border="0" id="table">
          <thead>
            <tr>
              <th>Id</th>
              <th>Titulo</th>
              <th>Ator Principal</th>
              <th>Ator Coadjuvante</th>
              <th>Data Lancamento</th>
              <th>Genero</th>
              <th>Classificação Etaría</th>
              <th>Ano Lançamento</th>
              <th>Duração (Min)</th>
              <th>Alterar</th>
              <th>Excluir</th>
            </tr>
          </thead>
          <tbody>

        <jsp:useBean
            id="servicos"
            scope="page"
            class="locacaodvds.servicos.DvdServicos"
        />
        
        
        <c:forEach items="${servicos.todos}" var="dvd">
            
            <fmt:formatDate 
                pattern="dd-MM-yyyy"
                value="${dvd.dataLancamento}"
                var="data" scope="page"/>
            
            <tr>
              <td>${dvd.dvdID}</td>
              <td>${dvd.titulo}</td>
              <td>${dvd.atorPrincipal.nome} ${dvd.atorPrincipal.sobrenome}</td>
              <!-- Usar o formatter dps -->
              <td>${dvd.atorCoadjuvante.nome} ${dvd.atorCoadjuvante.sobrenome}</td>
              <td>${data}</td>
              <td>${dvd.genero.descricao}</td>
              <td>${dvd.classificacao.descricao}</td>
              <td>${dvd.anoLancamento}</td>
              <td>${dvd.duracaoMinutos}</td>
              
              <td>
                <a href="${cp}/${prefixo}Alteracao&id=${dvd.dvdID}">
                  Alterar
                </a>
              </td>
              <td>
                <a href="${cp}/${prefixo}Exclusao&id=${dvd.dvdID}">
                  Excluir
                </a>
              </td>
            </tr>
            
        </c:forEach>
        
          </tbody>
        </table>
        <a href="${cp}/dvd/cadastroDvd.jsp" class="link-button" style="width: inherit; text-align: center">Novo Dvd</a
        >
      </div>
    </main>

   
  </body>
</html>
