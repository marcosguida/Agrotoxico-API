package br.agrotoxico.dto;

import br.agrotoxico.model.Fabricante;

/*
 * @author Marcos Ribeiro 
 */

public record FabricanteResponseDTO(
    Long id,
    String nome,
    String cnpj
) {
    public FabricanteResponseDTO(Fabricante fabricante) {
        this(fabricante.getId(), fabricante.getNome(), fabricante.getCnpj());
    }
}
