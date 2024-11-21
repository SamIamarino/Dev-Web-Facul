<%@page contentType="text/html" pageEncoding="UTF-8"%> 
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="cp" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html lang="en" id="main">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Star Copy</title>
    <link rel="stylesheet" href="${cp}/css/dvdStyle.css" />
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
          <h1>Cadastre seu Dvd:</h1>
          <hr
            style="
              height: 10px;
              border: 0;
              box-shadow: inset 0 12px 12px -12px rgba(0, 0, 0, 0.5);
            "
          />
        </div>
        <div class="header-body">
          <form action="${cp}/processaDvd" method="post">
            <input type="hidden" name="acao" value="inserir"/>

            <label>Título: </label>
            <input type="text" name="nomeDvd" class="form-input" required/>

            <label>Ano Lancamento: </label>
            <input type="text" name="anoLancamentoDvd" class="form-input" required/>

            <label>Data Lançamento: </label>
            <input type="date" name="dataLancamentoDvd" class="form-input" required/>

            <label>Duração(Min): </label>
            <input type="text" name="duracaoDvd" class="form-input"required />

            <jsp:useBean 
                id="atorServicos" 
                scope="page" 
                class="locacaodvds.servicos.AtorServicos"/>
            
            <label>Ator Principal: </label>
            <select name="atorPrincipalDvd" class="form-input" required>
                <option></option>
                <c:forEach items="${atorServicos.todos}" var="ator">
                <option value="${ator.idAtor}">
                  ${ator.nome} ${ator.sobrenome}
                </option>
              </c:forEach>
            </select>
            
            <label>Ator Coadjuvante: </label>
            <select name="atorQuadjuvante" class="form-input" required>
              <option></option>
                <c:forEach items="${atorServicos.todos}" var="ator">
                <option value="${ator.idAtor}">
                  ${ator.nome} ${ator.sobrenome}
                </option>
              </c:forEach>
            </select>

             <jsp:useBean 
                id="generoServicos" 
                scope="page" 
                class="locacaodvds.servicos.GeneroServicos"/>
            
            <label>Genero: </label>
            <select name="generoDvd" class="form-input" required>
              <option></option>
                <c:forEach items="${generoServicos.todos}" var="genero">
                <option value="${genero.idGenero}">
                  ${genero.descricao}
                </option>
              </c:forEach>
            </select>

             <jsp:useBean 
                id="classificacaoServicos" 
                scope="page" 
                class="locacaodvds.servicos.ClassificacaoServicos"/>
            
            <label>Classificação Etária: </label>
            <select name="classificacaoDvd" class="form-input" required>
              <option></option>
                <c:forEach items="${classificacaoServicos.todos}" var="classificacao">
                <option value="${classificacao.idClassificacao}">
                  ${classificacao.descricao}
                </option>
              </c:forEach>
            </select>

            <input type="submit" class="form-input-submit" value="Cadastrar" />
          </form>
        </div>
      </div>
    </main>


  </body>
</html>