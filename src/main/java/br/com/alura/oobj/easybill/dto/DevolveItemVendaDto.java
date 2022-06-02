package br.com.alura.oobj.easybill.dto;

import br.com.alura.oobj.easybill.model.ItemVenda;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class DevolveItemVendaDto {

    private long id;

    private int quantidade;

    private String observacao;

    private Long produtoId;

    private BigDecimal precoUnitario;

    private BigDecimal precoUnitarioPromocional;

    public long getId() {
        return id;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public Long getProdutoId() {
        return produtoId;
    }

    public void setProdutoId(Long produtoId) {
        this.produtoId = produtoId;
    }

    public BigDecimal getPrecoUnitario() {
        return precoUnitario;
    }

    public void setPrecoUnitario(BigDecimal precoUnitario) {
        this.precoUnitario = precoUnitario;
    }

    public BigDecimal getPrecoUnitarioPromocional() {
        return precoUnitarioPromocional;
    }

    public void setPrecoUnitarioPromocional(BigDecimal precoUnitarioPromocional) {
        this.precoUnitarioPromocional = precoUnitarioPromocional;
    }

    public DevolveItemVendaDto(ItemVenda itemVenda) {
        this.id = itemVenda.getId();
        this.quantidade = itemVenda.getQuantidade();
        this.observacao = itemVenda.getObservacao();
        this.produtoId = itemVenda.getProduto().getId();
        this.precoUnitario = itemVenda.getPrecoUnitario();
        this.precoUnitarioPromocional = itemVenda.getPrecoUnitarioPromocional();
    }

    public static List<DevolveItemVendaDto> converter(List<ItemVenda> itemVendas) {
        List<DevolveItemVendaDto> devolveItens = new ArrayList<>();
        itemVendas.forEach(item -> {
            DevolveItemVendaDto devolveItemVendaDto = new DevolveItemVendaDto(item);
            devolveItens.add(devolveItemVendaDto);
        });
        return devolveItens;
    }
}
