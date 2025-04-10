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
    @Size(max = 300, message = "Nome comercial deve ter no máximo 300 caracteres")
    String nomeComercial,
    
    @Size(max = 2000, message = "Descrição deve ter no máximo 2000 caracteres")
    String descricao,
    
    @Size(max = 60, message = "Código de barras deve ter no máximo 60 caracteres")
    String codigoBarras,
    
    @NotNull(message = "Tipo de formulação não pode ser nulo") 
    TipoFormulacao tipoFormulacao,
    
    @NotNull(message = "ID do fabricante não pode ser nulo") 
    Long fabricanteId
) {}