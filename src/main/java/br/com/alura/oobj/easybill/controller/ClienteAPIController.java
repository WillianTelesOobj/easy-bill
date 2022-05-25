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

    private ClienteRepository clienteRepository;

    public ClienteAPIController (ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    @PostMapping("/api/clientes")
    public ResponseEntity<RequisicaoNovoClienteDto> insereNovoCliente(@RequestBody @Valid RequisicaoNovoClienteDto requisicaoNovoClienteDto, UriComponentsBuilder uriBuilder, BindingResult result) {
        if(result.hasErrors()){
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
        if(cliente.isPresent()) {
            return ResponseEntity.ok(new DevolveClienteDto(cliente.get()));
        }
        return ResponseEntity.notFound().build();
    }

//    @GetMapping("/admin/clientes")
//    public List<DevolveClienteDto> devolveTodosClientes(){
//        List<Cliente> clientes = clienteRepository.findAll();
//        return DevolveClienteDto.converter(clientes);
//    }

    @GetMapping("/admin/clientes")
    public List<DevolveClienteDto> devolveClientesPorEstado(@RequestParam(value = "estado", defaultValue = "") String estado){
        if(estado.isEmpty()) {
            System.out.println(estado);
            List<Cliente> clientes = clienteRepository.findAll();
            return DevolveClienteDto.converter(clientes);
        }
        List<Cliente> clientesPorEstado = clienteRepository.findByEstadoEnderecoCliente(estado);
        return DevolveClienteDto.converter(clientesPorEstado);
    }
}
