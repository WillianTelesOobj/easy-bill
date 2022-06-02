package br.com.alura.oobj.easybill.dto;

import br.com.alura.oobj.easybill.model.ItemVenda;
import br.com.alura.oobj.easybill.model.StatusVenda;
import br.com.alura.oobj.easybill.model.Venda;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public class DevolveVendaDto {

    private Long id;

    private StatusVenda status;

    private LocalDateTime dataCriacao;

    private Long clienteId;

    private List<ItemVenda> itens;

    public Long getId() {
        return id;
    }

    public StatusVenda getStatus() {
        return status;
    }

    public void setStatus(StatusVenda status) {
        this.status = status;
    }

    public LocalDateTime getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(LocalDateTime dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public Long getClienteId() {
        return clienteId;
    }

    public void setClienteId(Long clienteId) {
        this.clienteId = clienteId;
    }

    public List<ItemVenda> getItens() {
        return itens;
    }

    public void setItens(List<ItemVenda> itens) {
        this.itens = itens;
    }

    public DevolveVendaDto(Optional<Venda> venda, List<ItemVenda> itemVenda) {
        this.id = venda.get().getId();
        this.status = venda.get().getStatus();
        this.dataCriacao = venda.get().getDataCriacao();
        this.clienteId = venda.get().getCliente().getId();
        this.itens = itemVenda;
    }

    public static DevolveVendaDto converter(Optional<Venda> venda, List<ItemVenda> itemVendas){
        return new DevolveVendaDto(venda, itemVendas);
    }
}
