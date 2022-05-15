package br.com.alura.oobj.easybill.repository;

import br.com.alura.oobj.easybill.model.Produto;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
public class ProdutoRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public List<Produto> recuperaTodosOsProdutos() {
        Query query = entityManager.createQuery("select p from Produto p", Produto.class);
        return query.getResultList();
    }


}
