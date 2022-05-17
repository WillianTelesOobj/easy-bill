package br.com.alura.oobj.easybill.controller;

import br.com.alura.oobj.easybill.dto.DevolveProduto;
import br.com.alura.oobj.easybill.model.Produto;
import br.com.alura.oobj.easybill.repository.ProdutoRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProdutoAPIController {

    private ProdutoRepository produtoRepository;

    public ProdutoAPIController(ProdutoRepository produtoRepository){
        this.produtoRepository = produtoRepository;
    }

    @GetMapping("/api/produtos")
    public List<DevolveProduto> listagemDeProdutos(){
        List<Produto> produtos = produtoRepository.findAll();
        return DevolveProduto.converter(produtos);
    }
}