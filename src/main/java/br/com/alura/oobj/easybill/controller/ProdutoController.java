package br.com.alura.oobj.easybill.controller;

import br.com.alura.oobj.easybill.dto.RequisicaoNovoProduto;
import br.com.alura.oobj.easybill.model.Produto;
import br.com.alura.oobj.easybill.repository.ProdutoRepository;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    private ProdutoRepository produtoRepository;
    private ProdutoAPIController produtoAPIController;


    @GetMapping("produtos/formulario")
    public String formulario(RequisicaoNovoProduto requisicaoNovoProduto) {
        return "admin/produtos/formulario";
    }

    @PostMapping("produtos")
    public String produtos(@Valid RequisicaoNovoProduto requisicaoNovoProduto, @NotNull BindingResult result) {
        if(result.hasErrors()){
            return "admin/produtos/formulario";
        }

        Produto produto = requisicaoNovoProduto.toProduto();
        produtoRepository.save(produto);

        return "redirect:home";
    }

    @GetMapping("/produto")
    public ModelAndView listaProdutos(){
        ModelAndView modelAndView = new ModelAndView("admin/produto");
        modelAndView.addObject("produto", produtoAPIController.listagemDeProdutos());
        return modelAndView;
    }
}