package br.com.alura.oobj.easybill.service;

import br.com.alura.oobj.easybill.dto.RequisicaoVendaDto;
import br.com.alura.oobj.easybill.model.Cliente;
import br.com.alura.oobj.easybill.model.ItemVenda;
import br.com.alura.oobj.easybill.model.Venda;
import br.com.alura.oobj.easybill.repository.ClienteRepository;
import br.com.alura.oobj.easybill.repository.ItemVendaRepository;
import br.com.alura.oobj.easybill.repository.ProdutoRepository;
import br.com.alura.oobj.easybill.repository.VendaRepository;
import br.com.alura.oobj.easybill.validator.NotFoundException;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static br.com.alura.oobj.easybill.model.StatusVenda.REALIZADA;

@Service
public class VendaService {

    private final ClienteRepository clienteRepository;
    private final ProdutoRepository produtoRepository;
    private final VendaRepository vendaRepository;
    private final ItemVendaRepository itemVendaRepository;

    public VendaService(ClienteRepository clienteRepository, ProdutoRepository produtoRepository, VendaRepository vendaRepository, ItemVendaRepository itemVendaRepository) {
        this.clienteRepository = clienteRepository;
        this.produtoRepository = produtoRepository;
        this.vendaRepository = vendaRepository;
        this.itemVendaRepository = itemVendaRepository;
    }

    public Venda registraVenda(RequisicaoVendaDto requisicaoVendaDto)
    {
        Cliente cliente = clienteRepository.findById(requisicaoVendaDto.getClienteId())
                .orElseThrow(() -> new NotFoundException("Não foi encontrodao o cliente: " + requisicaoVendaDto.getClienteId()));
        Venda venda = criaVenda(cliente);
        vendaRepository.save(venda);

        List<ItemVenda> itemVendas = criaItemVenda(requisicaoVendaDto, venda);
        itemVendaRepository.saveAll(itemVendas);

        return venda;
    }

    private Venda criaVenda(Cliente cliente) {
        Venda venda = new Venda();
        venda.setCliente(cliente);
        venda.setDataCriacao(LocalDateTime.now());
        venda.setStatus(REALIZADA);
        return venda;
    }

    private List<ItemVenda> criaItemVenda(RequisicaoVendaDto requisicaoVendaDto, Venda venda) {
        List<ItemVenda> itens = new ArrayList<>();
        requisicaoVendaDto.getItensVenda().forEach(item ->
                itens.add(item.toItemVenda(produtoRepository, venda))

        );
        return itens;
    }
}
