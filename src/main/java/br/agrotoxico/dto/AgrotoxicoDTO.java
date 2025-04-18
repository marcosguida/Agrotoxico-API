package br.agrotoxico.dto;

import br.agrotoxico.model.TipoFormulacao;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

/**
 * @author Marcos Ribeiro 
 */

public record AgrotoxicoDTO(
    @NotBlank(message = "Nome comercial não pode ser vazio") 
    @Size(max = 400, message = "O Nome comercial deve ter no máximo 400 caracteres")
    String nomeComercial,
    
    @Size(max = 2100, message = "A Descrição deve ter no máximo 2100 caracteres")
    String descricao,
    
    @Size(max = 30, message = "O Código de barras deve ter no máximo 30 caracteres")
    String codigoBarras,
    
    @NotNull(message = "O Tipo de formulação não pode ser nulo") 
    TipoFormulacao tipoFormulacao,
    
    @NotNull(message = "ID do fabricante não pode ser nulo") 
    Long fabricanteId
) {}
