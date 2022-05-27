package br.com.alura.oobj.easybill.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Positive;
import java.util.List;

public class RequisicaoVendaDto {

    @Positive
    private Long clienteId;

    @NotEmpty
    private List<RequisicaoItemVendaDto> itensVenda;

    public RequisicaoVendaDto() {
    }

    public Long getClienteId() {
        return clienteId;
    }

    public void setClienteId(Long clienteId) {
        this.clienteId = clienteId;
    }

    public List<RequisicaoItemVendaDto> getItensVenda() {
        return itensVenda;
    }

    public void setItensVenda(List<RequisicaoItemVendaDto> itensVenda) {
        this.itensVenda = itensVenda;
    }
}
