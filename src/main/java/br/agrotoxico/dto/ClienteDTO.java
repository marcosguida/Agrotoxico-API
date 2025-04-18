package br.agrotoxico.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.*;
import java.time.LocalDate;

/**
 * @author Marcos Ribeiro
 */

public class ClienteDTO {
    @NotBlank(message = "Nome não pode ser vazio")
    @Size(max = 400, message = "Nome deve ter no máximo 400 caracteres")
    private String nome;
    
    @Email(message = "Email inválido")
    @Size(max = 150, message = "Email deve ter no máximo 150 caracteres")
    private String email;
    
    @NotBlank(message = "Senha não pode ser vazia")
    @Size(min = 8, max = 120, message = "Senha deve ter no mínimo 8 e no máximo 120 caracteres")
    private String senha;
    
    @NotBlank(message = "CPF não pode ser vazio")
    @Pattern(regexp = "^\\d{3}\\.\\d{3}\\.\\d{3}-\\d{2}$", message = "CPF inválido. Use o formato: xxx.xxx.xxx-xx")
    private String cpf;
    
    @Size(max = 20, message = "RG deve ter no máximo 20 caracteres")
    private String rg;
    
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate dataNascimento;

    public ClienteDTO() {
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

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }
}
