package br.com.alura.oobj.easybill.model;

import javax.persistence.*;

@Entity
@Table(name = "clientes")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false, name = "nome")
    private String nome;

    @Column(nullable = false, length = 14, name = "cpf")
    private String cpf;

    @Column(nullable = false, length = 11, name = "telefone")
    private String telefone;

    @Column(nullable = false, name = "email")
    private String email;

    @Column(nullable = false, name = "rua")
    private String rua;

    @Column(nullable = false, name = "numero")
    private String numero;

    @Column(name = "complemento")
    private String complemento;

    @Column(nullable = false, name = "bairro")
    private String bairro;

    @Column(nullable = false, name = "cidade")
    private String cidade;

    @Column(nullable = false, name = "estado")
    private String estado;

    public long getId() {
        return id;
    }

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

    public String getTelefoneCliente() {
        return telefone;
    }

    public void setTelefoneCliente(String telefoneCliente) {
        this.telefone = telefoneCliente;
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
}
