<!DOCTYPE html>
<html lang="en" id="main">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Star Copy</title>
    <link rel="stylesheet" href="listagemStyle.css" />
  </head>
  <body>
    <header class="header">
      <nav>
        <img src="./assets/logo-removebg-preview.png" alt="Logo" class="logo" />
        <ul>
          <li><a href="#" class="nav-link">Ator</a></li>
          <li><a href="#" class="nav-link">Dvd</a></li>
          <li><a href="#" class="nav-link">Genero</a></li>
          <li><a href="#" class="nav-link">Classificação</a></li>
        </ul>
      </nav>
    </header>

    <main>
      <table class="tabelaListagem" border="0" id="table">
        <thead>
          <tr>
            <th>Id</th>
            <th>Nome</th>
            <th>Sobrenome</th>
            <th>E-mail</th>
            <th>CPF</th>
            <th>Cidade</th>
            <th>Data de Nascimento</th>
            <th>Alterar</th>
            <th>Excluir</th>
          </tr>
        </thead>
        <tbody>
          <jsp:useBean
            id="servicos"
            scope="page"
            class="cadastroclientes.servicos.ClienteServices"
          />

          <tr>
            <td>${cliente.id}</td>
            <td>${cliente.nome}</td>
            <td>${cliente.sobrenome}</td>
            <td>${cliente.email}</td>
            <td>${cliente.cpf}</td>
            <td>${cliente.cidade.nome}</td>
            <td>
              <fmt:formatDate
                pattern="dd/MM/yyyy"
                value="${cliente.dataNascimento}"
              />
            </td>
            <td>
              <a href="${cp}/${prefixo}Alteracao&id=${cliente.id}"> Alterar </a>
            </td>
            <td>
              <a href="${cp}/${prefixo}Exclusao&id=${cliente.id}"> Excluir </a>
            </td>
          </tr>
          <tr>
            <td>${cliente.id}</td>
            <td>${cliente.nome}</td>
            <td>${cliente.sobrenome}</td>
            <td>${cliente.email}</td>
            <td>${cliente.cpf}</td>
            <td>${cliente.cidade.nome}</td>
            <td>
              <fmt:formatDate
                pattern="dd/MM/yyyy"
                value="${cliente.dataNascimento}"
              />
            </td>
            <td>
              <a href="${cp}/${prefixo}Alteracao&id=${cliente.id}"> Alterar </a>
            </td>
            <td>
              <a href="${cp}/${prefixo}Exclusao&id=${cliente.id}"> Excluir </a>
            </td>
          </tr>
        </tbody>
      </table>
    </main>

    <footer></footer>
  </body>
</html>
