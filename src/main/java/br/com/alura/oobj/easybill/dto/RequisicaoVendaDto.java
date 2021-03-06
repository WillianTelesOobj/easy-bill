package br.com.alura.oobj.easybill.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Positive;
import java.util.ArrayList;
import java.util.List;

public class RequisicaoVendaDto {

    @Positive
    private Long clienteId;

    @NotEmpty
    private List<RequisicaoItemVendaDto> itensVenda = new ArrayList<>();

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

    public void adicionaItem(RequisicaoItemVendaDto requisicaoItemVendaDto) {
        itensVenda.add(requisicaoItemVendaDto);
    }
}
