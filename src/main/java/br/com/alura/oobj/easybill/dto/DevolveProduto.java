package br.com.alura.oobj.easybill.dto;

import br.com.alura.oobj.easybill.model.Produto;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

public class DevolveProduto {

    private Long id;

    private String nomeProduto;

    private String descricaoProduto;

    private BigDecimal precoProduto;

    private String classeFiscalProduto;

    public Long getId() {
        return id;
    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public String getDescricaoProduto() {
        return descricaoProduto;
    }

    public BigDecimal getPrecoProduto() {
        return precoProduto;
    }

    public String getClasseFiscalProduto() {
        return classeFiscalProduto;
    }

    public DevolveProduto(Produto produto){
        this.id = produto.getId();
        this.nomeProduto = produto.getNomeProduto();
        this.descricaoProduto = produto.getDescricaoProduto();
        this.precoProduto = produto.getPrecoProduto();
        this.classeFiscalProduto = produto.getClasseFiscalProduto();
    }

    public static List<DevolveProduto> converter(List<Produto> produtos){
        return produtos.stream()
                .map(DevolveProduto::new)
                .collect(Collectors.toList());
    }
}
