package br.com.alura.oobj.easybill.validator;

import br.com.alura.oobj.easybill.dto.RequisicaoNovoProdutoDto;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;

import static java.util.Objects.isNull;

@Component
public class PrecoPromocionalValidator {

    public void validacaoPrecoPromocional(RequisicaoNovoProdutoDto requisicaoNovoProdutoDto, BindingResult result){
        if(isNull(requisicaoNovoProdutoDto.getPrecoProduto()) || isNull(requisicaoNovoProdutoDto.getPrecoPromocionalProduto())){
            return;
        }
        Integer compare = requisicaoNovoProdutoDto.getPrecoProduto().compareTo(requisicaoNovoProdutoDto.getPrecoPromocionalProduto());
        if(compare.equals(1)){
            return;
        }
        result.rejectValue("precoPromocionalProduto", "", "O Preço Promocional do Produto deve ser menor que o Preço do Produto");
    }
}
