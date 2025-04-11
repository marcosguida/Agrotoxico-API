package br.agrotoxico.model.converterjpa;

import br.agrotoxico.model.TipoFormulacao;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

/**
 * @author Marcos Ribeiro
 */

@Converter(autoApply = true)
public class TipoFormulacaoConverter implements AttributeConverter<TipoFormulacao, String> {

    @Override
    public String convertToDatabaseColumn(TipoFormulacao tipoFormulacao) {
        if (tipoFormulacao == null) {
            return null;
        }
        return tipoFormulacao.name();
    }

    @Override
    public TipoFormulacao convertToEntityAttribute(String dbData) {
        if (dbData == null || dbData.isEmpty()) {
            return null;
        }
        return TipoFormulacao.valueOf(dbData);
    }
}
