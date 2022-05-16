package br.com.alura.oobj.easybill.controller;

import br.com.alura.oobj.easybill.model.Produto;
import br.com.alura.oobj.easybill.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HomeController {

    @Autowired
    private ProdutoRepository repository;

    @GetMapping("/admin/home")
    public String home(Model model) {
        List<Produto> produtos = repository.findAll();
        model.addAttribute("produtos", produtos);
        return "admin/home";
    }
}
