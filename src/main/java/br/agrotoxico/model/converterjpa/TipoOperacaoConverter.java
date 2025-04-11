package br.agrotoxico.model.converterjpa;

import br.agrotoxico.model.TipoOperacao;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

/**
 * @author Marcos Ribeiro
 */

@Converter(autoApply = true)
public class TipoOperacaoConverter implements AttributeConverter<TipoOperacao, String> {

    @Override
    public String convertToDatabaseColumn(TipoOperacao tipoOperacao) {
        if (tipoOperacao == null) {
            return null;
        }
        return tipoOperacao.name();
    }

    @Override
    public TipoOperacao convertToEntityAttribute(String dbData) {
        if (dbData == null || dbData.isEmpty()) {
            return null;
        }
        return TipoOperacao.valueOf(dbData);
    }
}
