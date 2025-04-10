package br.agrotoxico.dto;

import br.agrotoxico.model.Fabricante;
import java.time.LocalDateTime;

/**
 * @author Marcos Ribeiro 
 */
public record FabricanteResponseDTO(
    Long id,
    String nome,
    String cnpj,
    String telefone,
    String email,
    LocalDateTime dataCriacao,
    LocalDateTime dataAtualizacao
) {
    public FabricanteResponseDTO(Fabricante fabricante) {
        this(
            fabricante.getId(), 
            fabricante.getNome(), 
            fabricante.getCnpj(),
            fabricante.getTelefone(),
            fabricante.getEmail(),
            fabricante.getDataCriacao(),
            fabricante.getDataAtualizacao()
        );
    }
}
