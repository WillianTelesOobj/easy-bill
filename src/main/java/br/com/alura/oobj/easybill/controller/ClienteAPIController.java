package br.com.alura.oobj.easybill.controller;

import br.com.alura.oobj.easybill.dto.DevolveClienteDto;
import br.com.alura.oobj.easybill.dto.RequisicaoNovoClienteDto;
import br.com.alura.oobj.easybill.model.Cliente;
import br.com.alura.oobj.easybill.repository.ClienteRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
public class ClienteAPIController {

    private final ClienteRepository clienteRepository;

    public ClienteAPIController (ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    @PostMapping("/api/clientes")
    public ResponseEntity<RequisicaoNovoClienteDto> insereNovoCliente(@RequestBody @Valid RequisicaoNovoClienteDto requisicaoNovoClienteDto, UriComponentsBuilder uriBuilder, BindingResult result) {
        if(result.hasErrors()) {
            return ResponseEntity.badRequest().body(new RequisicaoNovoClienteDto());
        }
        Cliente cliente = requisicaoNovoClienteDto.toCliente();
        clienteRepository.save(cliente);

        URI uri = uriBuilder.path("/api/clientes/{id}").buildAndExpand(cliente.getId()).toUri();
        return ResponseEntity.created(uri).body(new RequisicaoNovoClienteDto(cliente));
    }

    @GetMapping("/api/clientes/{id}")
    public ResponseEntity<DevolveClienteDto> devolveClientePorId(@PathVariable Long id) {
        Optional<Cliente> cliente = clienteRepository.findById(id);
        return cliente.map(value -> ResponseEntity.ok(new DevolveClienteDto(value))).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/api/clientes")
    public List<DevolveClienteDto> devolveClientesPorEstado(@RequestParam(required = false) Optional<String> estado) {
        if(!estado.isPresent()) {
            List<Cliente> clientes = clienteRepository.findAll();
            return DevolveClienteDto.converter(clientes);
        }
        List<Cliente> clientesPorEstado = clienteRepository.findAllByEnderecoEstado(estado.get());
        return DevolveClienteDto.converter(clientesPorEstado);
    }
}
