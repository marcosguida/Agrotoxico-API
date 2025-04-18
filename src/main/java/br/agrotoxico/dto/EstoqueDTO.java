package br.agrotoxico.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import java.time.LocalDate;

/**
 * @author Marcos Ribeiro 
 */

public record EstoqueDTO(
    @NotNull(message = "A Quantidade não pode ser nula")
    @Positive(message = "A Quantidade deve ser um número positivo")
    Integer quantidade,
    
    @NotNull(message = "A Data de entrada não pode ser nula")
    LocalDate dataEntrada,
    
    LocalDate dataValidade,
    
    @Size(max = 50, message = "O Lote deve ter no máximo 50 caracteres")
    String lote,
    
    @NotNull(message = "O Preço de compra não pode ser nulo")
    @Positive(message = "O Preço de compra deve ser um valor positivo")
    Double precoCompra,
    
    @NotNull(message = "O Preço de venda não pode ser nulo")
    @Positive(message = "O Preço de venda deve ser um valor positivo")
    Double precoVenda,
    
    @NotNull(message = "ID do agrotóxico não pode ser nulo")
    Long agrotoxicoId,
    
    @NotNull(message = "ID do fornecedor não pode ser nulo")
    Long fornecedorId
) {}
