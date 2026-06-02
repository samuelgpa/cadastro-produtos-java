package com.mycompany.cadastroee.web;

import com.mycompany.cadastroee.ejb.ProdutoDAO;
import com.mycompany.cadastroee.ejb.ProdutoEntity;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "TesteProduto", urlPatterns = {"/TesteProduto"})
public class TesteProduto extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");

        PrintWriter out = response.getWriter();

        ProdutoDAO dao = new ProdutoDAO();

        ProdutoEntity p = new ProdutoEntity();

        p.setId(10);
        p.setNome("Notebook");
        p.setQuantidade(5);
        p.setPrecoVenda(3500);

        dao.salvar(p);

        List<ProdutoEntity> lista = dao.listar();

        out.println("<h1>Lista de Produtos</h1>");

        for (ProdutoEntity prod : lista) {

            out.println("ID: " + prod.getId() + "<br>");
            out.println("Nome: " + prod.getNome() + "<br>");
            out.println("Quantidade: " + prod.getQuantidade() + "<br>");
            out.println("Preço: " + prod.getPrecoVenda() + "<br><hr>");

        }
    }
}