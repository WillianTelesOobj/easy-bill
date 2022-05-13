package br.com.alura.oobj.easybill.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ProdutoController {

    @GetMapping("/formulario")
    public String formulario() {
        return "formulario";
    }
}
