package br.com.alura.oobj.easybill.controller;

import br.com.alura.oobj.easybill.dto.DevolveVendaDto;
import br.com.alura.oobj.easybill.dto.RequisicaoItemVendaDto;
import br.com.alura.oobj.easybill.dto.RequisicaoVendaDto;
import br.com.alura.oobj.easybill.model.ItemVenda;
import br.com.alura.oobj.easybill.model.Venda;
import br.com.alura.oobj.easybill.projection.VendasPorProdutoProjection;
import br.com.alura.oobj.easybill.repository.ItemVendaRepository;
import br.com.alura.oobj.easybill.repository.VendaRepository;
import br.com.alura.oobj.easybill.service.VendaService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
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
        if(result.hasErrors()) {
            return ResponseEntity.badRequest().build();
        }
        Venda venda = vendaService.registraVenda(requisicaoVendaDto);
        URI uri = uriBuilder.path("/api/venda/{id}").buildAndExpand(venda.getId()).toUri();
        return ResponseEntity.created(uri).body(new RequisicaoItemVendaDto());
    }

    @GetMapping("/vendas/{id}")
    public ResponseEntity<DevolveVendaDto> devolveVendaPorId(@PathVariable Long id) {
        Optional<Venda> venda = vendaRepository.findById(id);
        List<ItemVenda> itemVenda = itemVendaRepository.findAllByVenda_Id(id);
        if(venda.isPresent()) {
            DevolveVendaDto devolveVendaDto = DevolveVendaDto.converter(venda.get(), itemVenda);
            return ResponseEntity.ok(devolveVendaDto);
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/vendas")
    public List<DevolveVendaDto> devolveVenda() {
        List<Venda> vendas = vendaRepository.findAll();
        List<ItemVenda> itemVenda = itemVendaRepository.findAll();
        return vendas.stream().map(venda -> DevolveVendaDto.converter(venda, itemVenda)).collect(Collectors.toList());
    }

    @GetMapping("/relatorios/vendas-por-produto")
    public ResponseEntity<List<VendasPorProdutoProjection>> retornaRelatorioVendasPorProduto() {
        return ResponseEntity.ok(itemVendaRepository.relatorioVendasPorProduto());
    }
}
