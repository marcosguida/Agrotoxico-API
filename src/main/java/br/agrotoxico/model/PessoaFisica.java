package br.agrotoxico.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

/**
 * @author Marcos Ribeiro 
 */

@Entity
@Table(name = "pessoa_fisica")
@DiscriminatorValue("FISICA")
@PrimaryKeyJoinColumn(name = "pessoa_id")
public class PessoaFisica extends Pessoa {

    @NotBlank(message = "CPF não pode ser vazio")
    @Column(nullable = false, length = 14, unique = true)
    @Pattern(regexp = "^\\d{3}\\.\\d{3}\\.\\d{3}-\\d{2}$", message = "CPF inválido. Use o formato: xxx.xxx.xxx-xx")
    private String cpf;
    
    @Size(max = 20, message = "RG deve ter no máximo 20 caracteres")
    @Column(length = 20)
    private String rg;
    
    @Column(name = "data_nascimento")
    private java.time.LocalDate dataNascimento;

    public PessoaFisica() {
    }
    
    public PessoaFisica(String nome, String email, String senha, String cpf) {
        super(nome, email, senha);
        this.cpf = cpf;
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

    public java.time.LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(java.time.LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }
}
