package br.com.alura.oobj.easybill.dto;

import br.com.alura.oobj.easybill.model.Produto;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

public class DevolveProdutoDto {

    private Long id;

    private String nome;

    private String descricao;

    private BigDecimal preco;

    private String classeFiscal;

    public DevolveProdutoDto() {

    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public String getClasseFiscal() {
        return classeFiscal;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }

    public void setClasseFiscal(String classeFiscal) {
        this.classeFiscal = classeFiscal;
    }

    public DevolveProdutoDto(Produto produto) {
        this.id = produto.getId();
        this.nome = produto.getNome();
        this.descricao = getDescricaoProdutoTruncada(produto.getDescricao());
        this.preco = produto.getPrecoPromocional() != null ? produto.getPrecoPromocional() : produto.getPreco();
        this.classeFiscal = produto.getClasseFiscal();
    }

    public static List<DevolveProdutoDto> converter(List<Produto> produtos) {
        return produtos.stream()
                .map(DevolveProdutoDto::new)
                .collect(Collectors.toList());
    }

    public String getDescricaoProdutoTruncada(String descricao) {
        if (descricao.length() <= 250) {
            return descricao;
        }
        String descricaoProdutoTruncada = descricao.substring(0,247);
        return descricaoProdutoTruncada + "...";
    }

    public static DevolveProdutoDto toDevolveProdutoDto (Produto produto) {
        DevolveProdutoDto listaDeProdutos = new DevolveProdutoDto();
        listaDeProdutos.setId(produto.getId());
        listaDeProdutos.setNome(produto.getNome());
        listaDeProdutos.setDescricao(produto.getDescricao());
        listaDeProdutos.setPreco(produto.getPrecoPromocional() != null ? produto.getPrecoPromocional() : produto.getPreco());
        listaDeProdutos.setClasseFiscal(produto.getClasseFiscal());
        return listaDeProdutos;
    }
}
