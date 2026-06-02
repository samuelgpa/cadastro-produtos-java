package com.mycompany.cadastroee.web;

import com.mycompany.cadastroee.ejb.ProdutoDAO;
import com.mycompany.cadastroee.ejb.ProdutoEntity;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "ServletProdutoFC", urlPatterns = {"/ServletProdutoFC"})
public class ServletProdutoFC extends HttpServlet {

    ProdutoDAO dao = new ProdutoDAO();

    @Override
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        String acao = request.getParameter("acao");

        if (acao == null) {
            listar(request, response);
        }

        else if (acao.equals("formIncluir")) {
            abrirFormulario(request, response);
        }

        else if (acao.equals("formAlterar")) {
            abrirAlteracao(request, response);
        }

        else if (acao.equals("excluir")) {
            excluir(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        salvar(request, response);
    }

    private void listar(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        List<ProdutoEntity> lista = dao.listar();

        request.setAttribute("lista", lista);

        RequestDispatcher rd =
                request.getRequestDispatcher("ProdutoLista.jsp");

        rd.forward(request, response);
    }

    private void abrirFormulario(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        RequestDispatcher rd =
                request.getRequestDispatcher("ProdutoDados.jsp");

        rd.forward(request, response);
    }

    private void salvar(HttpServletRequest request,
            HttpServletResponse response)
            throws IOException {

        String idStr = request.getParameter("id");

        String nome = request.getParameter("nome");

        int quantidade =
                Integer.parseInt(request.getParameter("quantidade"));

        double preco =
                Double.parseDouble(request.getParameter("preco"));

        ProdutoEntity produto = new ProdutoEntity();

        produto.setNome(nome);
        produto.setQuantidade(quantidade);
        produto.setPrecoVenda(preco);

        if (idStr != null && !idStr.isEmpty()
                && Integer.parseInt(idStr) > 0) {

            produto.setId(Integer.parseInt(idStr));

            dao.atualizar(produto);

        } else {

            dao.salvar(produto);
        }

        response.sendRedirect("ServletProdutoFC");
    }

    private void excluir(HttpServletRequest request,
            HttpServletResponse response)
            throws IOException {

        int id =
                Integer.parseInt(request.getParameter("id"));

        dao.excluir(id);

        response.sendRedirect("ServletProdutoFC");
    }

    private void abrirAlteracao(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        int id =
                Integer.parseInt(request.getParameter("id"));

        ProdutoEntity produto =
                dao.buscarPorId(id);

        request.setAttribute("produto", produto);

        RequestDispatcher rd =
                request.getRequestDispatcher("ProdutoDados.jsp");

        rd.forward(request, response);
    }
}