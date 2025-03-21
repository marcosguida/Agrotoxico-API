package br.agrotoxico.dto;

import br.agrotoxico.model.Agrotoxico;
import br.agrotoxico.model.TipoFormulacao;

public record AgrotoxicoResponseDTO(Long id, String nomeComercial, TipoFormulacao tipoFormulacao) {

    public AgrotoxicoResponseDTO(Agrotoxico agrotoxico) {
        this(agrotoxico.getId(), agrotoxico.getNomeComercial(), agrotoxico.getTipoFormulacao());
    }
}
