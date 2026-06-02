package com.mycompany.cadastroee.ejb;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import java.util.List;

public class ProdutoDAO {

    EntityManagerFactory emf =
            Persistence.createEntityManagerFactory("CadastroEE-warPU");

    EntityManager em = emf.createEntityManager();

    public void salvar(ProdutoEntity produto) {

        em.getTransaction().begin();

        em.persist(produto);

        em.getTransaction().commit();
    }

    public List<ProdutoEntity> listar() {

        return em.createQuery(
                "SELECT p FROM ProdutoEntity p",
                ProdutoEntity.class
        ).getResultList();
    }
    
    public void excluir(int id) {

    ProdutoEntity produto = em.find(ProdutoEntity.class, id);

    em.getTransaction().begin();

    em.remove(produto);

    em.getTransaction().commit();
}
    
    public ProdutoEntity buscarPorId(int id) {

    return em.find(ProdutoEntity.class, id);
}

public void atualizar(ProdutoEntity produto) {

    em.getTransaction().begin();

    em.merge(produto);

    em.getTransaction().commit();
}
}