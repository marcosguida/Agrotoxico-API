package br.agrotoxico.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * @author Marcos Ribeiro
 */

 public record UsuarioAdministradorResponseDTO(
    Long id,
    String nome,
    String email,
    String cnpj,
    String inscricaoEstadual,
    String razaoSocial,
    String cargo,
    String departamento,
    String nivelAcesso,
    ContaUsuarioResponseDTO contaUsuario
) {
    public UsuarioAdministradorResponseDTO(UsuarioAdministrador admin) {
        this(
            admin.getId(),
            admin.getNome(),
            admin.getEmail(),
            admin.getCnpj(),
            admin.getInscricaoEstadual(),
            admin.getRazaoSocial(),
            admin.getCargo(),
            admin.getDepartamento(),
            admin.getNivelAcesso(),
            admin.getContaUsuario() != null ? new ContaUsuarioResponseDTO(admin.getContaUsuario()) : null
        );
    }
}
