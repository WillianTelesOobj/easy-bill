package br.com.alura.oobj.easybill.dto;

import br.com.alura.oobj.easybill.model.Produto;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

public class DevolveProdutoDto {

    private Long id;

    private String nome;

    private String descricaoProduto;

    private BigDecimal precoProduto;

    private String classeFiscalProduto;

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
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

    public DevolveProdutoDto(Produto produto){
        this.id = produto.getId();
        this.nome = produto.getNome();
        this.descricaoProduto = getDescricaoProdutoTruncada(produto.getDescricaoProduto());
        this.precoProduto = produto.getPrecoPromocionalProduto() != null ? produto.getPrecoPromocionalProduto() : produto.getPrecoProduto();
        this.classeFiscalProduto = produto.getClasseFiscalProduto();
    }

    public static List<DevolveProdutoDto> converter(List<Produto> produtos){
        return produtos.stream()
                .map(DevolveProdutoDto::new)
                .collect(Collectors.toList());
    }

    public String getDescricaoProdutoTruncada(String descricaoProduto) {
        if (descricaoProduto.length() <= 250) {
            return descricaoProduto;
        }
        String descricaoProdutoTruncada = descricaoProduto.substring(0,247);
        return descricaoProdutoTruncada + "...";
    }
}
