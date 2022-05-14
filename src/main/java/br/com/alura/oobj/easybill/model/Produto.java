package br.com.alura.oobj.easybill.model;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 150, nullable = false)
    private String nomeProduto;

    @Column(length = 500, nullable = false)
    private String urlProduto;

    @Column(length = 1000)
    private String descricaoProduto;

    private BigDecimal precoProduto;

    private BigDecimal precoPromocionalProduto;

    @Column(length = 10, nullable = false)
    private String classeFiscalProduto;

    public Long getId() {
        return id;
    }

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
}