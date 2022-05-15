package br.com.alura.oobj.easybill.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("admin")
public class ProdutoController {

    @GetMapping("produtos/formulario")
    public String formulario() {
        return "admin/produtos/formulario";
    }

    @PostMapping("produtos")
    public String novo() {
        return "admin/produtos/formulario";
    }
}
