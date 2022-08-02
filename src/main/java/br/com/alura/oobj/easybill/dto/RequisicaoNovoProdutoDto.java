package br.com.alura.oobj.easybill.dto;

import br.com.alura.oobj.easybill.model.Produto;
import br.com.alura.oobj.easybill.repository.ProdutoRepository;
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
    private String descricao;

    @NotNull
    @Positive
    private BigDecimal preco;

    @PositiveOrZero
    private BigDecimal precoPromocional;

    @NotBlank
    @Length(min=10, max=10)
    @Pattern(regexp = "^[\\d]{4}[.][\\d]{2}[.][\\d]{2}+$")
    private String classeFiscal;

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

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }

    public BigDecimal getPrecoPromocional() {
        return precoPromocional;
    }

    public void setPrecoPromocional(BigDecimal precoPromocional) {
        this.precoPromocional = precoPromocional;
    }

    public String getClasseFiscal() {
        return classeFiscal;
    }

    public void setClasseFiscal(String classeFiscal) {
        this.classeFiscal = classeFiscal;
    }

    public Produto toProduto() {
        Produto produto = new Produto();
        produto.setNome(nome);
        produto.setDescricao(descricao);
        produto.setUrl(url);
        produto.setPreco(preco);
        produto.setPrecoPromocional(precoPromocional);
        produto.setClasseFiscal(classeFiscal);
        return produto;
    }

    public RequisicaoNovoProdutoDto() {

    }

    public RequisicaoNovoProdutoDto(Produto produto) {
        this.nome = produto.getNome();
        this.url = produto.getUrl();
        this.descricao = produto.getDescricao();
        this.preco = produto.getPreco();
        this.precoPromocional = produto.getPrecoPromocional();
        this.classeFiscal = produto.getClasseFiscal();
    }

    public void update(Long id, ProdutoRepository produtoRepository) {
        Produto produto = produtoRepository.getById(id);
        produto.setNome(nome);
        produto.setUrl(url);
        produto.setDescricao(descricao);
        produto.setPreco(preco);
        produto.setPrecoPromocional(precoPromocional);
        produto.setClasseFiscal(classeFiscal);
    }
}
