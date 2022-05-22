package br.com.alura.oobj.easybill.controller;

import br.com.alura.oobj.easybill.dto.RequisicaoNovoProdutoDto;
import br.com.alura.oobj.easybill.model.Produto;
import br.com.alura.oobj.easybill.repository.ProdutoRepository;
import br.com.alura.oobj.easybill.validator.PrecoPromocionalValidator;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
@RequestMapping("admin")
public class ProdutoController {

    private final ProdutoRepository produtoRepository;
    private final ProdutoAPIController produtoAPIController;
    private final PrecoPromocionalValidator precoPromocionalValidator;


    public ProdutoController(ProdutoRepository produtoRepository, PrecoPromocionalValidator precoPromocionalValidator, ProdutoAPIController produtoAPIController){
        this.produtoRepository = produtoRepository;
        this.precoPromocionalValidator = precoPromocionalValidator;
        this.produtoAPIController = produtoAPIController;
    }

    @GetMapping("produtos/formulario")
    public String formulario(RequisicaoNovoProdutoDto requisicaoNovoProdutoDto) {
        return "admin/produtos/formulario";
    }

    @PostMapping("produtos")
    public String produtos(@Valid RequisicaoNovoProdutoDto requisicaoNovoProdutoDto, BindingResult result) {
        precoPromocionalValidator.validacaoPrecoPromocional(requisicaoNovoProdutoDto,result);
        if(result.hasErrors()){
            return "admin/produtos/formulario";
        }
        Produto produto = requisicaoNovoProdutoDto.toProduto();
        produtoRepository.save(produto);
        return "redirect:produtos";
    }

    @GetMapping("/produto")
    public ModelAndView listaProdutos(){
        ModelAndView modelAndView = new ModelAndView("admin/produto");
        modelAndView.addObject("produto", produtoAPIController.listagemDeProdutos());
        return modelAndView;
    }
}