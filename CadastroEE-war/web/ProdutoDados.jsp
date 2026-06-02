<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="com.mycompany.cadastroee.ejb.ProdutoEntity"%>

<%
    ProdutoEntity produto =
            (ProdutoEntity) request.getAttribute("produto");

    if (produto == null) {
        produto = new ProdutoEntity();
    }
%>

<!DOCTYPE html>
<html>

<head>

    <meta charset="UTF-8">

    <title>Cadastro de Produtos</title>

    <!-- Bootstrap -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
          rel="stylesheet">

</head>

<body class="container mt-4">

    <h1>Cadastro de Produtos</h1>

    <form action="ServletProdutoFC" method="post">

        <input type="hidden"
               name="id"
               value="<%= produto.getId() %>">

        <div class="mb-3">

            <label class="form-label">
                Nome
            </label>

            <input type="text"
                   name="nome"
                   class="form-control"
                   value="<%= produto.getNome() == null ? "" : produto.getNome() %>">

        </div>

        <div class="mb-3">

            <label class="form-label">
                Quantidade
            </label>

            <input type="number"
                   name="quantidade"
                   class="form-control"
                   value="<%= produto.getQuantidade() %>">

        </div>

        <div class="mb-3">

            <label class="form-label">
                Preço
            </label>

            <input type="number"
                   step="0.01"
                   name="preco"
                   class="form-control"
                   value="<%= produto.getPrecoVenda() %>">

        </div>

        <button type="submit"
                class="btn btn-success">
            Salvar
        </button>

        <a href="ServletProdutoFC"
           class="btn btn-secondary">
            Voltar
        </a>

    </form>

</body>
</html>