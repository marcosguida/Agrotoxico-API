package br.agrotoxico.dto;

import br.agrotoxico.model.ContaUsuario;
import br.agrotoxico.model.StatusConta;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotNull;

/**
 * @author Marcos Ribeiro 
 */

public record ContaUsuarioResponseDTO(
    Long id,
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    LocalDateTime ultimoAcesso,
    StatusConta statusConta,
    Integer tentativasLogin,
    Boolean bloqueado,
    @JsonFormat(pattern = "yyyy-MM-dd")
    LocalDate dataExpiracaoSenha
) {
    public ContaUsuarioResponseDTO(ContaUsuario contaUsuario) {
        this(
            contaUsuario.getId(),
            contaUsuario.getUltimoAcesso(),
            contaUsuario.getStatusConta(),
            contaUsuario.getTentativasLogin(),
            contaUsuario.getBloqueado(),
            contaUsuario.getDataExpiracaoSenha()
        );
    }
}
