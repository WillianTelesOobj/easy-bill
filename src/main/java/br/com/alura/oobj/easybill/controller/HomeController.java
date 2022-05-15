package br.com.alura.oobj.easybill.controller;

import br.com.alura.oobj.easybill.model.Produto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

@Controller
public class HomeController {

    @PersistenceContext
    private EntityManager entityManager;


    @GetMapping("/home")
    public String home(Model model) {
//        Produto produto = new Produto();
//        produto.setNomeProduto("Notebook Gamer Alienware x17 R2");
//        produto.setUrlProduto("https://www.dell.com/pt-br/shop/notebooks/notebook-gamer-alienware-x17-r2/spd/alienware-x17-r2-laptop/ax17r230w");
//        produto.setDescricaoProduto("12ª geração de Intel® Core™ i9 12900HK, Windows 11 Home Single Language, SSD de 1TB e Memória de 16GB");
//        produto.setPrecoProduto(BigDecimal.valueOf(37498.99));
//        produto.setPrecoPromocionalProduto(BigDecimal.valueOf(34000.99));
//        produto.setClasseFiscalProduto("9999.99.99");
//        List<Produto> produtos = Arrays.asList(produto);

        Query query = entityManager.createQuery("select p from Produto p", Produto.class);
        List<Produto> produtos = query.getResultList();

        model.addAttribute("produtos", produtos);
        return "home";
    }
}
