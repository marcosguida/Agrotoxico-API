package br.agrotoxico.dto;

import br.agrotoxico.model.Cliente;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

/**
 * @author Marcos Ribeiro
 */

public record ClienteResponseDTO(
    Long id,
    String nome,
    String email,
    String cpf,
    String rg,
    @JsonFormat(pattern = "yyyy-MM-dd")
    LocalDate dataNascimento,
    @JsonFormat(pattern = "yyyy-MM-dd")
    LocalDate dataCadastro,
    ContaUsuarioResponseDTO contaUsuario
) {
    public ClienteResponseDTO(Cliente cliente) {
        this(
            cliente.getId(),
            cliente.getNome(),
            cliente.getEmail(),
            cliente.getCpf(),
            cliente.getRg(),
            cliente.getDataNascimento(),
            cliente.getDataCadastro(),
            cliente.getContaUsuario() != null ? new ContaUsuarioResponseDTO(cliente.getContaUsuario()) : null
        );
    }
}
