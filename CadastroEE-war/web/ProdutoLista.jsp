<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<%@page import="com.mycompany.cadastroee.ejb.ProdutoEntity"%>

<%
    List<ProdutoEntity> lista =
            (List<ProdutoEntity>) request.getAttribute("lista");
%>

<!DOCTYPE html>
<html>

<head>

    <meta charset="UTF-8">

    <title>Listagem de Produtos</title>

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
          rel="stylesheet">

</head>

<body class="bg-light">

    <!-- MENU -->

    <nav class="navbar navbar-dark bg-dark">

        <div class="container-fluid">

            <span class="navbar-brand mb-0 h1">
                Sistema de Produtos
            </span>

        </div>

    </nav>

    <!-- CONTEÚDO -->

    <div class="container mt-4">

        <div class="d-flex justify-content-between align-items-center mb-3">

            <h1>
                Listagem de Produtos
            </h1>

            <a href="ServletProdutoFC?acao=formIncluir"
               class="btn btn-success">

                Novo Produto

            </a>

        </div>

        <table class="table table-striped table-hover table-bordered shadow">

            <thead class="table-dark">

                <tr>

                    <th>ID</th>
                    <th>Nome</th>
                    <th>Quantidade</th>
                    <th>Preço</th>
                    <th width="220">
                        Opções
                    </th>

                </tr>

            </thead>

            <tbody>

                <%
                    for (ProdutoEntity prod : lista) {
                %>

                <tr>

                    <td>
                        <%= prod.getId() %>
                    </td>

                    <td>
                        <%= prod.getNome() %>
                    </td>

                    <td>
                        <%= prod.getQuantidade() %>
                    </td>

                    <td>
                        R$ <%= prod.getPrecoVenda() %>
                    </td>

                    <td>

                        <a href="ServletProdutoFC?acao=formAlterar&id=<%= prod.getId() %>"
                           class="btn btn-primary btn-sm">

                            Alterar

                        </a>

                        <a href="ServletProdutoFC?acao=excluir&id=<%= prod.getId() %>"
                           class="btn btn-danger btn-sm"
                           onclick="return confirm('Deseja realmente excluir?')">

                            Excluir

                        </a>

                    </td>

                </tr>

                <%
                    }
                %>

            </tbody>

        </table>

    </div>

</body>
</html>