<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="cp" value="${pageContext.request.contextPath}"/>
<c:set var="prefixo" value="processaClassificacao?acao=preparar"/>
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
              <th>Descrição</th>
              <th>Alterar</th>
              <th>Excluir</th>
            </tr>
          </thead>
          <tbody>
            
        <jsp:useBean
            id="servicos"
            scope="page"
            class="locacaodvds.servicos.ClassificacaoServicos"
        />
        
        <c:forEach items="${servicos.todos}" var="classificacao">
            
            <tr>
              <td>${classificacao.idClassificacao}</td>
              <td>${classificacao.descricao}</td>
              <td>
                <a href="${cp}/${prefixo}Alteracao&id=${classificacao.idClassificacao}">
                  Alterar
                </a>
              </td>
              <td>
                <a href="${cp}/${prefixo}Exclusao&id=${classificacao.idClassificacao}">
                  Excluir
                </a>
              </td>
            </tr>
            
        </c:forEach>
        
          </tbody>
        </table>
        
        <a href="${cp}/classificacao_etaria/cadastroClassificacao.jsp" 
           class="link-button" 
           style="width: inherit; text-align: center"
        >
            Nova Classificação
        </a>
      </div>
    </main>

    
  </body>
</html>
