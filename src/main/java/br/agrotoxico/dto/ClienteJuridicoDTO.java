package br.agrotoxico.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.*;
import java.time.LocalDate;

/**
 * @author Marcos Ribeiro
 */

public class ClienteJuridicoDTO {
    @NotBlank(message = "Nome não pode ser vazio")
    @Size(max = 300, message = "Nome deve ter no máximo 300 caracteres")
    private String nome;
    
    @Email(message = "Email inválido")
    @Size(max = 100, message = "Email deve ter no máximo 100 caracteres")
    private String email;
    
    @NotBlank(message = "Senha não pode ser vazia")
    @Size(min = 8, max = 100, message = "Senha deve ter entre 8 e 100 caracteres")
    private String senha;
    
    @NotBlank(message = "CNPJ não pode ser vazio")
    @Pattern(regexp = "^\\d{2}\\.\\d{3}\\.\\d{3}/\\d{4}-\\d{2}$", message = "CNPJ inválido. Use o formato: xx.xxx.xxx/xxxx-xx")
    private String cnpj;
    
    @Size(max = 30, message = "Inscrição Estadual deve ter no máximo 30 caracteres")
    private String inscricaoEstadual;
    
    @Size(max = 300, message = "Razão Social deve ter no máximo 300 caracteres")
    private String razaoSocial;

    public ClienteJuridicoDTO() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getInscricaoEstadual() {
        return inscricaoEstadual;
    }

    public void setInscricaoEstadual(String inscricaoEstadual) {
        this.inscricaoEstadual = inscricaoEstadual;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }
}
