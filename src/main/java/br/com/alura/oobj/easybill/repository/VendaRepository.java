package br.com.alura.oobj.easybill.repository;

import br.com.alura.oobj.easybill.model.Venda;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VendaRepository extends JpaRepository<Venda, Long> {

}
