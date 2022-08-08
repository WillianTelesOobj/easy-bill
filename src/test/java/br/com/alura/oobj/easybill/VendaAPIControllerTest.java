package br.com.alura.oobj.easybill;

import br.com.alura.oobj.easybill.dto.RequisicaoItemVendaDto;
import br.com.alura.oobj.easybill.dto.RequisicaoVendaDto;
import br.com.alura.oobj.easybill.model.Cliente;
import br.com.alura.oobj.easybill.model.Endereco;
import br.com.alura.oobj.easybill.model.Produto;
import br.com.alura.oobj.easybill.repository.ClienteRepository;
import br.com.alura.oobj.easybill.repository.ProdutoRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Profile;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.math.BigDecimal;
import java.net.URI;

@RunWith(SpringRunner.class)
@Profile("test")
@AutoConfigureMockMvc
@SpringBootTest
@ActiveProfiles("test")
public class VendaAPIControllerTest {

    @Autowired
    private WebApplicationContext webApplicationContext;
    private MockMvc mockMvc;
    @Autowired
    private ClienteRepository clienteRepository;
    @Autowired
    private ProdutoRepository produtoRepository;
    private ObjectMapper objectMapper = new ObjectMapper();
    @Before
    public void setup() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Test
    public void deveriaDevolver400CasoDadosDeCriacaoDeVendaEstejamIncorretos() throws Exception {
        URI uri = new URI("/api/vendas");
        String json = "{\"clienteId\": 5,\"  \"itensVenda\": [\" {\"quantidade\": 6, \"produtoId\": 3},\" {\"quantidade\": 1, \"produtoId\": 1}\" ]}";

        mockMvc
                .perform(MockMvcRequestBuilders
                        .post(uri)
                        .content(json)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers
                        .status()
                        .is(400));
    }

    @Test
    public void deveriaDevolver201CasoDadosDeCriacaoDeVendaEstejamCorretos() throws Exception {
        Cliente cliente = clienteTeste();
        RequisicaoVendaDto requisicaoVendaDto = criaRequisicaoVendaDto(cliente);
        String requisicaoVendaDtoJson = objectMapper.writeValueAsString(requisicaoVendaDto);

        URI uri = new URI("/api/vendas");

        mockMvc.perform(MockMvcRequestBuilders
                        .post(uri)
                        .content(requisicaoVendaDtoJson)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().is(201))
                .andExpect(MockMvcResultMatchers.header().exists("Location"));
    }

    private RequisicaoVendaDto criaRequisicaoVendaDto(Cliente cliente) {
        RequisicaoVendaDto requisicaoVendaDto = new RequisicaoVendaDto();
        requisicaoVendaDto.setClienteId(cliente.getId());

        RequisicaoItemVendaDto requisicaoItemVendaDto = new RequisicaoItemVendaDto();
        requisicaoItemVendaDto.setObservacao("Teste");
        requisicaoItemVendaDto.setQuantidade(2);

        Produto produto = produtoTeste();
        requisicaoItemVendaDto.setProdutoId(produto.getId());

        requisicaoVendaDto.adicionaItem(requisicaoItemVendaDto);
        return requisicaoVendaDto;
    }

    private Endereco enderecoTeste() {
        Endereco endereco = new Endereco();
        endereco.setRua("Rua 5");
        endereco.setNumero("5");
        endereco.setComplemento("");
        endereco.setBairro("Bairro Teste");
        endereco.setCidade("Salvador");
        endereco.setEstado("BA");
        return endereco;
    }

    private Cliente clienteTeste() {
        Cliente cliente = new Cliente();
        cliente.setNome("José");
        cliente.setCpf("555.555.555-55");
        cliente.setTelefone("55555555555");
        cliente.setEmail("teste@teste.com.br");
        cliente.setEndereco(enderecoTeste());
        clienteRepository.save(cliente);
        return cliente;
    }

    private Produto produtoTeste() {
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
}
