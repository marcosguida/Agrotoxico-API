package br.agrotoxico.dto;

import br.agrotoxico.model.Agrotoxico;
import br.agrotoxico.model.TipoFormulacao;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

/*
 * @author Marcos Ribeiro 
 */

public record AgrotoxicoDTO(
    @NotBlank(message = "Nome comercial não pode ser vazio") String nomeComercial,
    @NotNull(message = "Tipo de formulação não pode ser nulo") TipoFormulacao tipoFormulacao,
    @NotNull(message = "ID do fabricante não pode ser nulo") Long fabricanteId
) {}
