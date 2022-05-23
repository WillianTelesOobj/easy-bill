package br.com.alura.oobj.easybill.controller;

import br.com.alura.oobj.easybill.dto.DevolveProdutoDto;
import br.com.alura.oobj.easybill.dto.RequisicaoNovoProdutoDto;
import br.com.alura.oobj.easybill.model.Produto;
import br.com.alura.oobj.easybill.repository.ProdutoRepository;
import br.com.alura.oobj.easybill.validator.PrecoPromocionalValidator;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.Optional;

@RequestMapping("api")
@RestController
public class ProdutoAPIController {

    private ProdutoRepository produtoRepository;
    private PrecoPromocionalValidator precoPromocionalValidator;

    public ProdutoAPIController(ProdutoRepository produtoRepository, PrecoPromocionalValidator precoPromocionalValidator){
        this.produtoRepository = produtoRepository;
        this.precoPromocionalValidator = precoPromocionalValidator;
    }

    @GetMapping("/produtos")
    public List<DevolveProdutoDto> listagemDeProdutos(){
        List<Produto> produtos = produtoRepository.findAll();
        return DevolveProdutoDto.converter(produtos);
    }

    @GetMapping("/produtos/{id}")
    public ResponseEntity<DevolveProdutoDto> devolveProdutoPorId(@PathVariable Long id) {
        Optional<Produto> produto = produtoRepository.findById(id);
        if(produto.isPresent()) return ResponseEntity.ok(new DevolveProdutoDto(produto.get()));
        return ResponseEntity.notFound().build();
    }
}