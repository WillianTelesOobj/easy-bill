package br.com.alura.oobj.easybill.controller;

import br.com.alura.oobj.easybill.dto.RequisicaoItemVendaDto;
import br.com.alura.oobj.easybill.dto.RequisicaoVendaDto;
import br.com.alura.oobj.easybill.model.Venda;
import br.com.alura.oobj.easybill.repository.ItemVendaRepository;
import br.com.alura.oobj.easybill.repository.VendaRepository;
import br.com.alura.oobj.easybill.service.VendaService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.util.UriComponentsBuilder;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.net.URI;

@Controller
@RequestMapping("/api")
public class VendaAPIController {

    private final VendaRepository vendaRepository;
    private final ItemVendaRepository itemVendaRepository;
    private final VendaService vendaService;

    public VendaAPIController(VendaRepository vendaRepository, ItemVendaRepository itemVendaRepository, VendaService vendaService) {
        this.vendaRepository = vendaRepository;
        this.itemVendaRepository = itemVendaRepository;
        this.vendaService = vendaService;
    }

    @PostMapping("/vendas")
    @Transactional
    public ResponseEntity<RequisicaoItemVendaDto> criacaoDeVenda(@RequestBody @Valid RequisicaoVendaDto requisicaoVendaDto, UriComponentsBuilder uriBuilder, BindingResult result) {
        if(result.hasErrors()){
            return ResponseEntity.badRequest().build();
        }
        Venda venda = vendaService.registraVenda(requisicaoVendaDto);
        URI uri = uriBuilder.path("/api/venda/{id}").buildAndExpand(venda.getId()).toUri();
        return ResponseEntity.created(uri).body(new RequisicaoItemVendaDto());
    }
}
