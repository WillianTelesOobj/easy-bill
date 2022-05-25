package br.com.alura.oobj.easybill.dto;

import br.com.alura.oobj.easybill.model.Cliente;

import java.util.List;
import java.util.stream.Collectors;

public class DevolveClienteDto {

    private String nomeCompletoCliente;

    private String cpfCliente;

    private String telefoneCelularCliente;

    private String emailCliente;

    private String ruaEnderecoCliente;

    private String numeroEnderecoCliente;

    private String complementoEnderecoCliente;

    private String bairroEnderecoCliente;

    private String cidadeEnderecoCliente;

    private String estadoEnderecoCliente;

    public String getNomeCompletoCliente() {
        return nomeCompletoCliente;
    }

    public String getCpfCliente() {
        return cpfCliente;
    }

    public String getTelefoneCelularCliente() {
        return telefoneCelularCliente;
    }

    public String getEmailCliente() {
        return emailCliente;
    }

    public String getRuaEnderecoCliente() {
        return ruaEnderecoCliente;
    }

    public String getNumeroEnderecoCliente() {
        return numeroEnderecoCliente;
    }

    public String getComplementoEnderecoCliente() {
        return complementoEnderecoCliente;
    }

    public String getBairroEnderecoCliente() {
        return bairroEnderecoCliente;
    }

    public String getCidadeEnderecoCliente() {
        return cidadeEnderecoCliente;
    }

    public String getEstadoEnderecoCliente() {
        return estadoEnderecoCliente;
    }

    public DevolveClienteDto(Cliente cliente) {
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

    public static List<DevolveClienteDto> converter(List<Cliente> clientes) {
        return clientes.stream()
                .map(DevolveClienteDto::new)
                .collect(Collectors.toList());
    }
}
