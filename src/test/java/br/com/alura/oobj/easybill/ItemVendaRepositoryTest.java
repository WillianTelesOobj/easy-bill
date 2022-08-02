package br.com.alura.oobj.easybill;

import br.com.alura.oobj.easybill.model.*;
import br.com.alura.oobj.easybill.projection.VendasPorProdutoProjection;
import br.com.alura.oobj.easybill.repository.ClienteRepository;
import br.com.alura.oobj.easybill.repository.ItemVendaRepository;
import br.com.alura.oobj.easybill.repository.ProdutoRepository;
import br.com.alura.oobj.easybill.repository.VendaRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@ActiveProfiles("test")
public class ItemVendaRepositoryTest {

    @Autowired
    private ItemVendaRepository itemVendaRepository;
    @Autowired
    private ClienteRepository clienteRepository;
    @Autowired
    private ProdutoRepository produtoRepository;
    @Autowired
    private VendaRepository vendaRepository;

    @Test
    public void deveriaRetornarRelatorioDeVendas() {
        List<ItemVenda> itemVendas = criaItensVenda();
        itemVendaRepository.saveAll(itemVendas);
        List<VendasPorProdutoProjection> listaProjection = itemVendaRepository.relatorioVendasPorProduto();
        assertThat(listaProjection.get(0).getNomeProduto()).isEqualTo("Notebook Dell");
        assertThat(listaProjection.get(0).getQuantidadeVendas()).isEqualTo(9);
    }

    public List<ItemVenda> criaItensVenda() {
        ItemVenda itemVenda1 = new ItemVenda();
        ItemVenda itemVenda2 = new ItemVenda();
        List<ItemVenda> listaItemVenda = new ArrayList<>();
        Venda venda = criaVenda();
        Produto produto = criaProduto();

        itemVenda1.setQuantidade(5);
        itemVenda1.setObservacao("Obs. Produto 1");
        itemVenda1.setPrecoUnitario(produto.getPreco());
        itemVenda1.setVenda(venda);
        itemVenda1.setProduto(produto);
        itemVenda1.setPrecoUnitarioPromocional(produto.getPrecoPromocional());

        itemVenda2.setQuantidade(4);
        itemVenda2.setObservacao("Obs. Produto 2");
        itemVenda2.setPrecoUnitario(produto.getPreco());
        itemVenda2.setVenda(venda);
        itemVenda2.setProduto(produto);
        itemVenda2.setPrecoUnitarioPromocional(produto.getPrecoPromocional());

        listaItemVenda.add(itemVenda1);
        listaItemVenda.add(itemVenda2);
        return listaItemVenda;
    }

    public Produto criaProduto() {
        Produto produto = new Produto();
        produto.setNome("Notebook Dell");
        produto.setUrl("www.dell.com");
        produto.setDescricao("Notebook Inspiron 14");
        produto.setPreco(new BigDecimal("3400"));
        produto.setPrecoPromocional(new BigDecimal("3200"));
        produto.setClasseFiscal("1111.11.11");
        produtoRepository.save(produto);
        return produto;
    }

    public Venda criaVenda() {
        Venda venda = new Venda();
        Cliente cliente = criaCliente();
        venda.setDataCriacao(LocalDateTime.now());
        venda.setStatus(StatusVenda.REALIZADA);
        venda.setCliente(cliente);
        venda.setId(1L);
        vendaRepository.save(venda);
        return venda;
    }

    public Cliente criaCliente(){
        Cliente cliente = new Cliente();
        Endereco endereco = criaEnderaco();
        cliente.setNome("Willian Teste");
        cliente.setCpf("01234567899");
        cliente.setTelefone("62999999999");
        cliente.setEmail("teste@email.com");
        cliente.setEndereco(endereco);
        clienteRepository.save(cliente);
        return cliente;
    }

    public Endereco criaEnderaco() {
        Endereco endereco = new Endereco();
        endereco.setRua("José");
        endereco.setNumero("5");
        endereco.setComplemento("Teste");
        endereco.setBairro("Bairro Teste");
        endereco.setCidade("Salvador");
        endereco.setEstado("BA");
        return endereco;
    }
}
