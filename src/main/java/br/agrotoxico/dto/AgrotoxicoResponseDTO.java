package br.agrotoxico.dto;

import br.agrotoxico.model.Agrotoxico;
import br.agrotoxico.model.TipoFormulacao;

/*
 * @author Marcos Ribeiro 
 */

public record AgrotoxicoResponseDTO(
    Long id, 
    String nomeComercial, 
    TipoFormulacao tipoFormulacao,
    FabricanteResponseDTO fabricante
) {
    public AgrotoxicoResponseDTO(Agrotoxico agrotoxico) {
        this(
            agrotoxico.getId(), 
            agrotoxico.getNomeComercial(), 
            agrotoxico.getTipoFormulacao(),
            new FabricanteResponseDTO(agrotoxico.getFabricante())
        );
    }
}
