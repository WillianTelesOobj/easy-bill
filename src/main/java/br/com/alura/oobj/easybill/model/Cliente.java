package br.com.alura.oobj.easybill.model;

import javax.persistence.*;

@Entity
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false, name = "nomeCompletoCliente")
    private String nomeCompletoCliente;

    @Column(nullable = false, name = "cpfCliente")
    private String cpfCliente;

    @Column(nullable = false, name = "telefoneCliente")
    private String telefoneCliente;

    @Column(nullable = false, name = "emailCliente")
    private String emailCliente;

    @Column(nullable = false, name = "ruaEnderecoCliente")
    private String ruaEnderecoCliente;

    @Column(nullable = false, name = "numeroEnderecoCliente")
    private String numeroEnderecoCliente;

    @Column(name = "complementoEnderecoCliente")
    private String complementoEnderecoCliente;

    @Column(nullable = false, name = "bairroEnderecoCliente")
    private String bairroEnderecoCliente;

    @Column(nullable = false, name = "cidadeEnderecoCliente")
    private String cidadeEnderecoCliente;

    @Column(nullable = false, name = "estadoEnderecoCliente")
    private String estadoEnderecoCliente;

    public long getId() {
        return id;
    }

    public String getNomeCompletoCliente() {
        return nomeCompletoCliente;
    }

    public void setNomeCompletoCliente(String nomeCompletoCliente) {
        this.nomeCompletoCliente = nomeCompletoCliente;
    }

    public String getCpfCliente() {
        return cpfCliente;
    }

    public void setCpfCliente(String cpfCliente) {
        this.cpfCliente = cpfCliente;
    }

    public String getTelefoneCliente() {
        return telefoneCliente;
    }

    public void setTelefoneCliente(String telefoneCliente) {
        this.telefoneCliente = telefoneCliente;
    }

    public String getEmailCliente() {
        return emailCliente;
    }

    public void setEmailCliente(String emailCliente) {
        this.emailCliente = emailCliente;
    }

    public String getRuaEnderecoCliente() {
        return ruaEnderecoCliente;
    }

    public void setRuaEnderecoCliente(String ruaEnderecoCliente) {
        this.ruaEnderecoCliente = ruaEnderecoCliente;
    }

    public String getNumeroEnderecoCliente() {
        return numeroEnderecoCliente;
    }

    public void setNumeroEnderecoCliente(String numeroEnderecoCliente) {
        this.numeroEnderecoCliente = numeroEnderecoCliente;
    }

    public String getComplementoEnderecoCliente() {
        return complementoEnderecoCliente;
    }

    public void setComplementoEnderecoCliente(String complementoEnderecoCliente) {
        this.complementoEnderecoCliente = complementoEnderecoCliente;
    }

    public String getBairroEnderecoCliente() {
        return bairroEnderecoCliente;
    }

    public void setBairroEnderecoCliente(String bairroEnderecoCliente) {
        this.bairroEnderecoCliente = bairroEnderecoCliente;
    }

    public String getCidadeEnderecoCliente() {
        return cidadeEnderecoCliente;
    }

    public void setCidadeEnderecoCliente(String cidadeEnderecoCliente) {
        this.cidadeEnderecoCliente = cidadeEnderecoCliente;
    }

    public String getEstadoEnderecoCliente() {
        return estadoEnderecoCliente;
    }

    public void setEstadoEnderecoCliente(String estadoEnderecoCliente) {
        this.estadoEnderecoCliente = estadoEnderecoCliente;
    }
}
