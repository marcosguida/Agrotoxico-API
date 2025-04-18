package br.agrotoxico.dto;

import br.agrotoxico.model.ClienteJuridico;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.*;

/**
 * @author Marcos Ribeiro
 */

public record ClienteJuridicoResponseDTO(
    Long id,
    String nome,
    String email,
    String cnpj,
    String inscricaoEstadual,
    String razaoSocial,
    @JsonFormat(pattern = "yyyy-MM-dd")
    LocalDate dataCadastro,
    ContaUsuarioResponseDTO contaUsuario
) {
    public ClienteJuridicoResponseDTO(ClienteJuridico cliente) {
        this(
            cliente.getId(),
            cliente.getNome(),
            cliente.getEmail(),
            cliente.getCnpj(),
            cliente.getInscricaoEstadual(),
            cliente.getRazaoSocial(),
            cliente.getDataCadastro(),
            cliente.getContaUsuario() != null ? new ContaUsuarioResponseDTO(cliente.getContaUsuario()) : null
        );
    }
}
