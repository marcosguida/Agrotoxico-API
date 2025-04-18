package br.agrotoxico.dto;

import br.agrotoxico.model.Fornecedor;
import java.time.LocalDateTime;

/**
 * @author Marcos Ribeiro 
 */

public record FornecedorResponseDTO(
    Long id,
    String nome,
    String cnpj,
    String telefone,
    String email,
    String website,
    LocalDateTime dataCriacao,
    LocalDateTime dataAtualizacao
) {
    public FornecedorResponseDTO(Fornecedor fornecedor) {
        this(
            fornecedor.getId(), 
            fornecedor.getNome(), 
            fornecedor.getCnpj(),
            fornecedor.getTelefone(),
            fornecedor.getEmail(),
            fornecedor.getWebsite(),
            fornecedor.getDataCriacao(),
            fornecedor.getDataAtualizacao()
        );
    }
}
