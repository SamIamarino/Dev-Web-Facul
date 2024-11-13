<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="cp" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html lang="en" id="main">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Star Copy</title>
    <link rel="stylesheet" href="styles-index.css" />
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
      <div class="main-container">
        <div class="header-container">
          <h1>Bem vindo ao Star Copy!</h1>
          <hr
            style="
              height: 10px;
              border: 0;
              box-shadow: inset 0 12px 12px -12px rgba(0, 0, 0, 0.5);
            "
          />
        </div>
        <div class="header-body">
          <h2>Star copy, seu sistema de cadastro de Dvds!</h2>
          <p>A seguir selecione o que você quer cadastrar:</p>
          <a href="${cp}/dvd/cadastroDvd.jsp" class="link-button">Cadastre seu DVD.</a>
          <a href="${cp}/ator/cadastroAtor.jsp" class="link-button">Atores</a>
          <a href="${cp}/genero/cadastroGenero.jsp" class="link-button">Gênero.</a>
          <a href="${cp}/classificacao_etaria/cadastroClassificacao.jsp" class="link-button">Classificação Etária</a>
        </div>
      </div>
      <div class="main-container scroll">
        <div class="header-container">
          <h1>Copias Cadastradas:</h1>
          <hr
            style="
              height: 10px;
              border: 0;
              box-shadow: inset 0 12px 12px -12px rgba(0, 0, 0, 0.5);
            "
          />
        </div>
        <div class="header-body">
            
        <jsp:useBean
            id="servicos"
            scope="page"
            class="locacaodvds.servicos.DvdServicos"
        />
            
          <h3>Algumas cópias suas cadastradas:</h3>

          <c:forEach items="${servicos.todos}" var="dvd" >
            <a href="#" class="link-button">${dvd.titulo}</a>
          </c:forEach>
          
          
        </div>
      </div>
    </main>

    <footer></footer>
  </body>
</html>
