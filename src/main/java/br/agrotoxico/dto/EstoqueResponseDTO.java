package br.agrotoxico.dto;

import br.agrotoxico.model.Estoque;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * @author Marcos Ribeiro 
 */

public record EstoqueResponseDTO(
    Long id,
    Integer quantidade,
    LocalDate dataEntrada,
    LocalDate dataValidade,
    String lote,
    Double precoCompra,
    Double precoVenda,
    AgrotoxicoResponseDTO agrotoxico,
    FornecedorResponseDTO fornecedor,
    LocalDateTime dataCriacao,
    LocalDateTime dataAtualizacao
) {
    public EstoqueResponseDTO(Estoque estoque) {
        this(
            estoque.getId(),
            estoque.getQuantidade(),
            estoque.getDataEntrada(),
            estoque.getDataValidade(),
            estoque.getLote(),
            estoque.getPrecoCompra(),
            estoque.getPrecoVenda(),
            new AgrotoxicoResponseDTO(estoque.getAgrotoxico()),
            new FornecedorResponseDTO(estoque.getFornecedor()),
            estoque.getDataCriacao(),
            estoque.getDataAtualizacao()
        );
    }
}
