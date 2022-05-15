package br.com.alura.oobj.easybill.controller;

import br.com.alura.oobj.easybill.dto.RequisicaoNovoProduto;
import br.com.alura.oobj.easybill.model.Produto;
import br.com.alura.oobj.easybill.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("admin")
public class ProdutoController {

    @Autowired
    private ProdutoRepository produtoRepository;

    @GetMapping("produtos/formulario")
    public String formulario() {
        return "admin/produtos/formulario";
    }

    @PostMapping("produtos")
    public String novo(RequisicaoNovoProduto requisicaoNovoProduto) {

        Produto produto = requisicaoNovoProduto.toProduto();
        produtoRepository.save(produto);

        return "admin/produtos/formulario";
    }
}
