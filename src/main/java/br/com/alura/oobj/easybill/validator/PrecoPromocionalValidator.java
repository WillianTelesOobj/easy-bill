package br.com.alura.oobj.easybill.validator;

import br.com.alura.oobj.easybill.dto.RequisicaoNovoProduto;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;

import static java.util.Objects.isNull;

@Component
public class PrecoPromocionalValidator {

    public void validacaoPrecoPromocional(RequisicaoNovoProduto requisicaoNovoProduto, BindingResult result){
        if(isNull(requisicaoNovoProduto.getPrecoProduto()) || isNull(requisicaoNovoProduto.getPrecoPromocionalProduto())){
            return;
        }
        Integer compare = requisicaoNovoProduto.getPrecoProduto().compareTo(requisicaoNovoProduto.getPrecoPromocionalProduto());
        if(compare.equals(1)){
            return;
        }
        result.rejectValue("precoPromocionalProduto", "", "O Preço Promocional do Produto deve ser menor que o Preço do Produto");
    }
}
