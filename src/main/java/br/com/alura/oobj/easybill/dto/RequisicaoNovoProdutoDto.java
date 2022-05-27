package br.com.alura.oobj.easybill.dto;

import br.com.alura.oobj.easybill.model.Produto;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.*;
import java.math.BigDecimal;

public class RequisicaoNovoProdutoDto {
    @NotBlank
    @Size(max = 150)
    private String nome;

    @NotBlank
    @Size(max = 500)
    private String url;

    @Size(max = 1000)
    private String descricaoProduto;

    @NotNull
    @Positive
    private BigDecimal precoProduto;

    @Positive
    private BigDecimal precoPromocionalProduto;

    @NotBlank
    @Length(min=10, max=10)
    @Pattern(regexp = "^[\\d]{4}[.][\\d]{2}[.][\\d]{2}+$")
    private String classeFiscalProduto;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getDescricaoProduto() {
        return descricaoProduto;
    }

    public void setDescricaoProduto(String descricaoProduto) {
        this.descricaoProduto = descricaoProduto;
    }

    public BigDecimal getPrecoProduto() {
        return precoProduto;
    }

    public void setPrecoProduto(BigDecimal precoProduto) {
        this.precoProduto = precoProduto;
    }

    public BigDecimal getPrecoPromocionalProduto() {
        return precoPromocionalProduto;
    }

    public void setPrecoPromocionalProduto(BigDecimal precoPromocionalProduto) {
        this.precoPromocionalProduto = precoPromocionalProduto;
    }

    public String getClasseFiscalProduto() {
        return classeFiscalProduto;
    }

    public void setClasseFiscalProduto(String classeFiscalProduto) {
        this.classeFiscalProduto = classeFiscalProduto;
    }

    public Produto toProduto() {
        Produto produto = new Produto();
        produto.setNome(nome);
        produto.setDescricaoProduto(descricaoProduto);
        produto.setUrl(url);
        produto.setPrecoProduto(precoProduto);
        produto.setPrecoPromocionalProduto(precoPromocionalProduto);
        produto.setClasseFiscalProduto(classeFiscalProduto);
        return produto;
    }

    public RequisicaoNovoProdutoDto() {

    }

    public RequisicaoNovoProdutoDto(Produto produto) {
        this.nome = produto.getNome();
        this.url = produto.getUrl();
        this.descricaoProduto = produto.getDescricaoProduto();
        this.precoProduto = produto.getPrecoProduto();
        this.precoPromocionalProduto = produto.getPrecoPromocionalProduto();
        this.classeFiscalProduto = produto.getClasseFiscalProduto();
    }
}
