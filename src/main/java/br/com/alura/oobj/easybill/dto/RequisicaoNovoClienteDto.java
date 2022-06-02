package br.com.alura.oobj.easybill.dto;

import br.com.alura.oobj.easybill.model.Cliente;
import br.com.alura.oobj.easybill.model.Endereco;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

public class RequisicaoNovoClienteDto {

    @NotBlank
    private String nome;

    @NotBlank
    @Length(min=14, max=14)
    @Pattern(regexp = "^[\\d]{3}[.][\\d]{3}[.][\\d]{3}[-][\\d]{2}+$")
    private String cpf;

    @NotBlank
    @Length(min=10, max=11)
    private String telefone;

    @NotBlank
    private String email;

    @NotBlank
    private String rua;

    @NotBlank
    private String numero;

    private String complemento;

    @NotBlank
    private String bairro;

    @NotBlank
    private String cidade;

    @NotBlank
    private String estado;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Cliente toCliente() {
        Endereco endereco = new Endereco();
        endereco.setRua(rua);
        endereco.setNumero(numero);
        endereco.setComplemento(complemento);
        endereco.setBairro(bairro);
        endereco.setCidade(cidade);
        endereco.setEstado(estado);

        Cliente cliente = new Cliente();
        cliente.setNome(nome);
        cliente.setCpf(cpf);
        cliente.setTelefoneCliente(telefone);
        cliente.setEmail(email);
        cliente.setEndereco(endereco);
        return cliente;
    }

    public RequisicaoNovoClienteDto() {

    }

    public RequisicaoNovoClienteDto(Cliente cliente) {
        this.nome = cliente.getNome();
        this.cpf = cliente.getCpf();
        this.telefone = cliente.getTelefoneCliente();
        this.email = cliente.getEmail();
        this.rua = cliente.getEndereco().getRua();
        this.numero = cliente.getEndereco().getNumero();
        this.complemento = cliente.getEndereco().getComplemento();
        this.bairro = cliente.getEndereco().getBairro();
        this.cidade = cliente.getEndereco().getCidade();
        this.estado = cliente.getEndereco().getEstado();
    }
}
