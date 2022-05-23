package br.com.alura.oobj.easybill.dto;

import br.com.alura.oobj.easybill.model.Cliente;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

public class RequisicaoNovoClienteDto {

    @NotBlank
    private String nomeCompletoCliente;

    @NotBlank
    @Length(min=14, max=14)
    @Pattern(regexp = "^[\\d]{3}[.][\\d]{3}[.][\\d]{3}[-][\\d]{2}+$")
    private String cpfCliente;

    @NotBlank
    @Length(min=10, max=11)
    private String telefoneCelularCliente;

    @NotBlank
    private String emailCliente;

    @NotBlank
    private String ruaEnderecoCliente;

    @NotBlank
    private String numeroEnderecoCliente;

    private String complementoEnderecoCliente;

    @NotBlank
    private String bairroEnderecoCliente;

    @NotBlank
    private String cidadeEnderecoCliente;

    @NotBlank
    private String estadoEnderecoCliente;

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

    public String getTelefoneCelularCliente() {
        return telefoneCelularCliente;
    }

    public void setTelefoneCelularCliente(String telefoneCelularCliente) {
        this.telefoneCelularCliente = telefoneCelularCliente;
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

    public Cliente toCliente() {
        Cliente cliente = new Cliente();
        cliente.setNomeCompletoCliente(nomeCompletoCliente);
        cliente.setCpfCliente(cpfCliente);
        cliente.setTelefoneCliente(telefoneCelularCliente);
        cliente.setEmailCliente(emailCliente);
        cliente.setRuaEnderecoCliente(ruaEnderecoCliente);
        cliente.setNumeroEnderecoCliente(numeroEnderecoCliente);
        cliente.setComplementoEnderecoCliente(complementoEnderecoCliente);
        cliente.setBairroEnderecoCliente(bairroEnderecoCliente);
        cliente.setCidadeEnderecoCliente(cidadeEnderecoCliente);
        cliente.setEstadoEnderecoCliente(estadoEnderecoCliente);
        return cliente;
    }

    public RequisicaoNovoClienteDto() {

    }

    public RequisicaoNovoClienteDto(Cliente cliente) {
        this.nomeCompletoCliente = cliente.getNomeCompletoCliente();
        this.cpfCliente = cliente.getCpfCliente();
        this.telefoneCelularCliente = cliente.getTelefoneCliente();
        this.emailCliente = cliente.getEmailCliente();
        this.ruaEnderecoCliente = cliente.getRuaEnderecoCliente();
        this.numeroEnderecoCliente = cliente.getNumeroEnderecoCliente();
        this.complementoEnderecoCliente = cliente.getComplementoEnderecoCliente();
        this.bairroEnderecoCliente = cliente.getBairroEnderecoCliente();
        this.cidadeEnderecoCliente = cliente.getCidadeEnderecoCliente();
        this.estadoEnderecoCliente = cliente.getEstadoEnderecoCliente();
    }
}
