<%@page contentType="text/html" pageEncoding="UTF-8"%> <%@taglib prefix="c"
uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="cp" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html lang="en" id="main">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Star Copy</title>
    <link rel="stylesheet" href="atorStyle.css" />
  </head>
  <body>
    <header class="header">
      <nav>
        <img
          src="../assets/logo-removebg-preview.png"
          alt="Logo"
          class="logo"
        />
        <ul>
          <li><a href="#" class="nav-link">Ator</a></li>
          <li><a href="#" class="nav-link">Dvd</a></li>
          <li><a href="#" class="nav-link">Genero</a></li>
          <li><a href="#" class="nav-link">Classificação</a></li>
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
          <form action="" method="post">
            <input type="hidden" name="acao" value="deletar" />

            <label>Nome: </label>
            <input
              type="text"
              name="nomeAtor"
              class="form-input"
              value=""
              readonly
            />

            <label>Sobrenome: </label>
            <input
              type="text"
              name="sobrenomeAtor"
              class="form-input"
              value=""
              readonly
            />

            <label>Data Estreia: </label>
            <input
              type="date"
              name="dataEstreia"
              class="form-input"
              value=""
              readonly
            />

            <input type="submit" class="form-input-submit" value="Editar" />
          </form>
        </div>
      </div>
    </main>

    <footer></footer>
  </body>
</html>