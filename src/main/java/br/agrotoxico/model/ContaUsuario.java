package br.agrotoxico.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * @author Marcos Ribeiro
 */

@Entity
@Table(name = "conta_usuario")
public class ContaUsuario extends DefaultEntity {

    @Column(name = "ultimo_acesso")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime ultimoAcesso;
    
    @Enumerated(EnumType.STRING)
    @Column(name = "status_conta", nullable = false)
    private StatusConta statusConta;
    
    @Column(name = "tentativas_login")
    private Integer tentativasLogin;
    
    @Column
    private Boolean bloqueado;
    
    @Column(name = "data_expiracao_senha")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate dataExpiracaoSenha;
    
    @OneToOne
    @JoinColumn(name = "pessoa_id", nullable = false)
    private Pessoa pessoa;

    public ContaUsuario() {
        this.tentativasLogin = 0;
        this.bloqueado = false;
        this.statusConta = StatusConta.ATIVA;
        this.dataExpiracaoSenha = LocalDate.now().plusMonths(3); // Senha válida por 3 meses
    }

    public LocalDateTime getUltimoAcesso() {
        return ultimoAcesso;
    }

    public void setUltimoAcesso(LocalDateTime ultimoAcesso) {
        this.ultimoAcesso = ultimoAcesso;
    }

    public StatusConta getStatusConta() {
        return statusConta;
    }

    public void setStatusConta(StatusConta statusConta) {
        this.statusConta = statusConta;
    }

    public Integer getTentativasLogin() {
        return tentativasLogin;
    }

    public void setTentativasLogin(Integer tentativasLogin) {
        this.tentativasLogin = tentativasLogin;
    }

    public Boolean getBloqueado() {
        return bloqueado;
    }

    public void setBloqueado(Boolean bloqueado) {
        this.bloqueado = bloqueado;
    }

    public LocalDate getDataExpiracaoSenha() {
        return dataExpiracaoSenha;
    }

    public void setDataExpiracaoSenha(LocalDate dataExpiracaoSenha) {
        this.dataExpiracaoSenha = dataExpiracaoSenha;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }
}
