package br.com.alura.oobj.easybill.dto;

import br.com.alura.oobj.easybill.model.Produto;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

public class DevolveProduto {

    private Long id;

    private String nomeProduto;

    private String urlProduto;

    private String descricaoProduto;

    private BigDecimal precoProduto;

    private BigDecimal precoPromocionalProduto;

    private String classeFiscalProduto;

    public Long getId() {
        return id;
    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public String getUrlProduto() {
        return urlProduto;
    }

    public String getDescricaoProduto() {
        return descricaoProduto;
    }

    public BigDecimal getPrecoProduto() {
        return precoProduto;
    }

    public BigDecimal getPrecoPromocionalProduto() {
        return precoPromocionalProduto;
    }

    public String getClasseFiscalProduto() {
        return classeFiscalProduto;
    }

    public DevolveProduto(Produto produto){
        this.id = produto.getId();
        this.nomeProduto = produto.getNomeProduto();
        this.urlProduto = produto.getUrlProduto();;
        this.descricaoProduto = produto.getDescricaoProduto();
        this.precoProduto = produto.getPrecoProduto();
        this.precoPromocionalProduto = produto.getPrecoPromocionalProduto();
        this.classeFiscalProduto = produto.getClasseFiscalProduto();
    }

    public static List<DevolveProduto> converte(List<Produto> produtos){
        return produtos.stream().map(DevolveProduto::new).collect(Collectors.toList());
    }
}

