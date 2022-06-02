package br.com.alura.oobj.easybill.controller;

import br.com.alura.oobj.easybill.dto.DevolveProdutoDto;
import br.com.alura.oobj.easybill.dto.RequisicaoNovoProdutoDto;
import br.com.alura.oobj.easybill.model.Produto;
import br.com.alura.oobj.easybill.repository.ProdutoRepository;
import br.com.alura.oobj.easybill.validator.PrecoPromocionalValidator;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.Optional;

@RequestMapping("/api")
@RestController
public class ProdutoAPIController {

    private final ProdutoRepository produtoRepository;
    private final PrecoPromocionalValidator precoPromocionalValidator;

    public ProdutoAPIController(ProdutoRepository produtoRepository, PrecoPromocionalValidator precoPromocionalValidator){
        this.produtoRepository = produtoRepository;
        this.precoPromocionalValidator = precoPromocionalValidator;
    }

    @GetMapping("/produtos/listagem")
    public List<DevolveProdutoDto> listagemDeProdutos(){
        List<Produto> produtos = produtoRepository.findAll();
        return DevolveProdutoDto.converter(produtos);
    }

    @GetMapping("/produtos")
    public ResponseEntity<Page<DevolveProdutoDto>> listagemDeProdutosPorPagina(@PageableDefault(size = 5,sort="nome", direction = Sort.Direction.ASC) Pageable pagina) {
        Page<Produto> produtos = produtoRepository.findAll(pagina);
        return ResponseEntity.ok(DevolveProdutoDto.converterPageDevolveProdutoDto(produtos));
    }

    @GetMapping("/produtos/{id}")
    public ResponseEntity<DevolveProdutoDto> devolveProdutoPorId(@PathVariable Long id) {
        Optional<Produto> produto = produtoRepository.findById(id);
        return produto.map(value -> ResponseEntity.ok(new DevolveProdutoDto(value))).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/admin/produtos")
    public ResponseEntity<RequisicaoNovoProdutoDto> insereNovoProduto(@RequestBody @Valid RequisicaoNovoProdutoDto requisicaoNovoProdutoDto, UriComponentsBuilder uriBuilder, BindingResult result) {
        precoPromocionalValidator.validacaoPrecoPromocional(requisicaoNovoProdutoDto, result);
        if(result.hasErrors()){
            return ResponseEntity.badRequest().body(new RequisicaoNovoProdutoDto());
        }
        Produto produto = requisicaoNovoProdutoDto.toProduto();
        produtoRepository.save(produto);

        URI uri = uriBuilder.path("/api/admin/produtos/{id}").buildAndExpand(produto.getId()).toUri();
        return ResponseEntity.created(uri).body(new RequisicaoNovoProdutoDto(produto));
    }
}
