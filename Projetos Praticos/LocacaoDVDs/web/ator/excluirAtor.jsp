<%@page contentType="text/html" pageEncoding="UTF-8"%> 
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="cp" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html lang="en" id="main">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Star Copy</title>
    <link rel="stylesheet" href="${cp}/ator/atorStyle.css" />
  </head>
  <body>
    <header class="header">
      <nav>
        <img src="..${cp}/assets/logo-removebg-preview.png" alt="Logo" class="logo" />
        <ul>
          <li><a href="${cp}/ator/listagemAtor.jsp" class="nav-link">Ator</a></li>
          <li><a href="#" class="nav-link">Dvd</a></li>
          <li><a href="${cp}/genero/listagemGenero.jsp" class="nav-link">Genero</a></li>
          <li><a href="${cp}/classificacao_etaria/listagemClassificacao.jsp" class="nav-link">Classificação</a></li>
        </ul>
      </nav>
    </header>

    <main>
      <div class="main-container">
        <div class="header-container">
          <h1>Excluir Ator:</h1>
          <hr
            style="
              height: 10px;
              border: 0;
              box-shadow: inset 0 12px 12px -12px rgba(0, 0, 0, 0.5);
            "
          />
        </div>
        <div class="header-body">
          <form action="${cp}/processaAtor" method="post">
            <input type="hidden" name="acao" value="deletar" />
            <input type="hidden" name="id" value="${requestScope.ator.idAtor}" />

            <label>Nome: </label>
            <input
              type="text"
              name="nomeAtor"
              class="form-input"
              value="${requestScope.ator.nome}"
              readonly
            />

            <label>Sobrenome: </label>
            <input
              type="text"
              name="sobrenomeAtor"
              class="form-input"
              value="${requestScope.ator.sobrenome}"
              readonly
            />

            <label>Data Estreia: </label>
            <input
              type="date"
              name="dataEstreia"
              class="form-input"
              value="${requestScope.ator.dataEstreia}"
              readonly
            />

            <input type="submit" class="form-input-submit" value="Excluir" />
          </form>
        </div>
      </div>
    </main>

    <footer></footer>
  </body>
</html>