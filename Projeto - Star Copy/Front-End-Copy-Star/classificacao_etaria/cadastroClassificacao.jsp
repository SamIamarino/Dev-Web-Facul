<!DOCTYPE html>
<html lang="en" id="main">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Star Copy</title>
    <link rel="stylesheet" href="formularioStyle.css" />
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
          <h1>Cadastro Classificação:</h1>
          <hr
            style="
              height: 10px;
              border: 0;
              box-shadow: inset 0 12px 12px -12px rgba(0, 0, 0, 0.5);
            "
          />
        </div>
        <div class="header-body">
          <!-- Colocar Servlet -->
          <form action="" method="post">
            <input type="hidden" name="acao" value="inserir" />

            <label>Descrição: </label>

            <textarea
              name="descricaoGenero"
              id="descricaoGenero"
              class="form-input"
              rows="20"
            ></textarea>

            <input type="submit" class="form-input-submit" value="Cadastrar" />
          </form>
        </div>
      </div>
    </main>

    <footer></footer>
  </body>
</html>
