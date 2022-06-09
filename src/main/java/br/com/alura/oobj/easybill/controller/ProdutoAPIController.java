package br.com.alura.oobj.easybill.controller;

import br.com.alura.oobj.easybill.dto.DevolveProdutoDto;
import br.com.alura.oobj.easybill.dto.RequisicaoNovoProdutoDto;
import br.com.alura.oobj.easybill.model.Produto;
import br.com.alura.oobj.easybill.repository.ProdutoRepository;
import br.com.alura.oobj.easybill.validator.PrecoPromocionalValidator;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.transaction.Transactional;
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
    public Page<DevolveProdutoDto> retornaLista(@RequestParam(value = "pagina", defaultValue = "") Integer pagina){
        if(pagina == null){
            pagina = 0;
        }
        Pageable pageable = PageRequest.of(pagina, 5, Sort.by(Sort.Direction.ASC, "nome"));
        return produtoRepository.findAll(pageable).map(DevolveProdutoDto::toDevolveProdutoDto);
    }

    @GetMapping("/produtos/{id}")
    public ResponseEntity<DevolveProdutoDto> devolveProdutoPorId(@PathVariable Long id) {
        Optional<Produto> produto = produtoRepository.findById(id);
        return produto.map(value -> ResponseEntity.ok(new DevolveProdutoDto(value))).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/admin/produtos")
    @Transactional
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

    @PutMapping("/admin/produtos/{id}")
    @Transactional
    public ResponseEntity<Void> atualizarProdutoPorId(@PathVariable Long id, @RequestBody @Valid RequisicaoNovoProdutoDto requisicaoNovoProdutoDto) {
        Optional<Produto> produtoOptional = produtoRepository.findById(id);
        if (produtoOptional.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        requisicaoNovoProdutoDto.update(id, produtoRepository);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/admin/produtos/{id}")
    @Transactional
    public ResponseEntity<?> deletarProdutoPorId(@PathVariable Long id) {
        Optional<Produto> produtoOptional = produtoRepository.findById(id);
        if (produtoOptional.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        produtoRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
