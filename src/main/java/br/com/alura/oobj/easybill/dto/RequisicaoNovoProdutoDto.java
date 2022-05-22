package br.com.alura.oobj.easybill.dto;

import br.com.alura.oobj.easybill.model.Produto;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.*;
import java.math.BigDecimal;

public class RequisicaoNovoProdutoDto {
    @NotBlank
    @Size(max = 150)
    private String nomeProduto;

    @NotBlank
    @Size(max = 500)
    private String urlProduto;

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

    public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public String getUrlProduto() {
        return urlProduto;
    }

    public void setUrlProduto(String urlProduto) {
        this.urlProduto = urlProduto;
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
        produto.setNomeProduto(nomeProduto);
        produto.setDescricaoProduto(descricaoProduto);
        produto.setUrlProduto(urlProduto);
        produto.setPrecoProduto(precoProduto);
        produto.setPrecoPromocionalProduto(precoPromocionalProduto);
        produto.setClasseFiscalProduto(classeFiscalProduto);
        return produto;
    }
}