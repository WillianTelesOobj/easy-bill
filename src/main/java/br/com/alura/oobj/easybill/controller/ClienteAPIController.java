package br.com.alura.oobj.easybill.controller;

import br.com.alura.oobj.easybill.dto.RequisicaoNovoClienteDto;
import br.com.alura.oobj.easybill.dto.RequisicaoNovoProdutoDto;
import br.com.alura.oobj.easybill.model.Cliente;
import br.com.alura.oobj.easybill.repository.ClienteRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

@RequestMapping("/api")
@RestController

public class ClienteAPIController {

    private ClienteRepository clienteRepository;

    public ClienteAPIController (ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    @PostMapping("clientes")
    public ResponseEntity<RequisicaoNovoClienteDto> insereNovoCliente(@RequestBody @Valid RequisicaoNovoClienteDto requisicaoNovoClienteDto, UriComponentsBuilder uriBuilder, BindingResult result) {
        if(result.hasErrors()){
            return ResponseEntity.badRequest().body(new RequisicaoNovoClienteDto());
        }
        Cliente cliente = requisicaoNovoClienteDto.toCliente();
        clienteRepository.save(cliente);

        URI uri = uriBuilder.path("/api/clientes/{id}").buildAndExpand(cliente.getId()).toUri();
        return ResponseEntity.created(uri).body(new RequisicaoNovoClienteDto(cliente));
    }
}
