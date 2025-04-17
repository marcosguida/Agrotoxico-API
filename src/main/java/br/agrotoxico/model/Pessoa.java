package br.agrotoxico.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

/**
 * @author Marcos Ribeiro 
 */

@Entity
@Table(name = "pessoa")
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "tipo_pessoa")
public abstract class Pessoa extends DefaultEntity {

    @NotBlank(message = "Nome não pode ser vazio")
    @Size(max = 300, message = "Nome deve ter no máximo 300 caracteres")
    @Column(nullable = false, length = 300)
    private String nome;
    
    @Email(message = "Email inválido")
    @Size(max = 100, message = "Email deve ter no máximo 100 caracteres")
    @Column(length = 100)
    private String email;
    
    @NotBlank(message = "Senha não pode ser vazia")
    @Size(min = 8, max = 100, message = "Senha deve ter entre 8 e 100 caracteres")
    @Column(nullable = false, length = 100)
    private String senha;
    
    @OneToOne(mappedBy = "pessoa", cascade = CascadeType.ALL, orphanRemoval = true)
    private ContaUsuario contaUsuario;

    public Pessoa() {
    }
    
    public Pessoa(String nome, String email, String senha) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
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
    
    public ContaUsuario getContaUsuario() {
        return contaUsuario;
    }
    
    public void setContaUsuario(ContaUsuario contaUsuario) {
        this.contaUsuario = contaUsuario;
    }
}
