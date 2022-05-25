package br.com.alura.oobj.easybill.model;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Venda {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, name = "dataHoraVenda")
    private LocalDateTime dataHoraVenda; //coloco  = LocalDateTime.now()?

    @Column(nullable = false, name = "statusVenda")
    private Enum<StatusVenda> statusVenda;

    @ManyToOne
//    @Column(nullable = false, name = "cliente")
    private Cliente cliente;

    public Long getId() {
        return id;
    }

    public LocalDateTime getDataHoraVenda() {
        return dataHoraVenda;
    }

    public void setDataHoraVenda(LocalDateTime dataHoraVenda) {
        this.dataHoraVenda = dataHoraVenda;
    }

    public Enum<StatusVenda> getStatusVenda() {
        return statusVenda;
    }

    public void setStatusVenda(Enum<StatusVenda> statusVenda) {
        this.statusVenda = statusVenda;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
}
