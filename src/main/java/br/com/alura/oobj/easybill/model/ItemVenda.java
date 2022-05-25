package br.com.alura.oobj.easybill.model;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
public class ItemVenda {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, name = "quantidadeItemVenda")
    private Integer quantidadeItemVenda;

    @Column(length = 500, name = "observacaoItemVenda")
    private String observacaoItemVenda;

    @Column(nullable = false, name = "precoUnitarioItemVenda")
    private BigDecimal precoUnitarioItemVenda;

    @Column(name = "precoUnitarioPromocionalItemVenda")
    private BigDecimal precoUnitarioPromocionalItemVenda;


    @ManyToOne
//    @Column(nullable = false, name = "venda")
    private Venda venda;

    @ManyToOne
//    @Column(nullable = false, name = "produto")
    private Produto produto;

    public Long getId() {
        return id;
    }

    public Integer getQuantidadeItemVenda() {
        return quantidadeItemVenda;
    }

    public void setQuantidadeItemVenda(Integer quantidadeItemVenda) {
        this.quantidadeItemVenda = quantidadeItemVenda;
    }

    public String getObservacaoItemVenda() {
        return observacaoItemVenda;
    }

    public void setObservacaoItemVenda(String observacaoItemVenda) {
        this.observacaoItemVenda = observacaoItemVenda;
    }

    public BigDecimal getPrecoUnitarioItemVenda() {
        return precoUnitarioItemVenda;
    }

    public void setPrecoUnitarioItemVenda(BigDecimal precoUnitarioItemVenda) {
        this.precoUnitarioItemVenda = precoUnitarioItemVenda;
    }

    public BigDecimal getPrecoUnitarioPromocionalItemVenda() {
        return precoUnitarioPromocionalItemVenda;
    }

    public void setPrecoUnitarioPromocionalItemVenda(BigDecimal precoUnitarioPromocionalItemVenda) {
        this.precoUnitarioPromocionalItemVenda = precoUnitarioPromocionalItemVenda;
    }

    public Venda getVenda() {
        return venda;
    }

    public void setVenda(Venda venda) {
        this.venda = venda;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }
}
