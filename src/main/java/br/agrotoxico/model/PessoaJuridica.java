package br.agrotoxico.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

/**
 * @author Marcos Ribeiro 
 */

@Entity
@Table(name = "pessoa_juridica")
@DiscriminatorValue("JURIDICA")
@PrimaryKeyJoinColumn(name = "pessoa_id")
public class PessoaJuridica extends Pessoa {

    @NotBlank(message = "CNPJ não pode ser vazio")
    @Column(nullable = false, length = 18, unique = true)
    @Pattern(regexp = "^\\d{2}\\.\\d{3}\\.\\d{3}/\\d{4}-\\d{2}$", message = "CNPJ inválido. Use o formato: xx.xxx.xxx/xxxx-xx")
    private String cnpj;
    
    @Column(name = "inscricao_estadual", length = 30)
    private String inscricaoEstadual;
    
    @Column(name = "razao_social", length = 300)
    private String razaoSocial;

    public PessoaJuridica() {
    }
    
    public PessoaJuridica(String nome, String email, String senha, String cnpj) {
        super(nome, email, senha);
        this.cnpj = cnpj;
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
