package br.agrotoxico.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

/**
 * @author Marcos Ribeiro 
 */

public class FabricanteDTO {
    @NotBlank(message = "Nome do fabricante não pode ser vazio")
    @Size(max = 300, message = "Nome do fabricante deve ter no máximo 300 caracteres")
    private String nome;

    @NotBlank(message = "CNPJ do fabricante não pode ser vazio")
    @Pattern(regexp = "^\\d{2}\\.\\d{3}\\.\\d{3}/\\d{4}-\\d{2}$", message = "CNPJ inválido. Use o formato: xx.xxx.xxx/xxxx-xx")
    private String cnpj;
    
    @Size(max = 20, message = "Telefone deve ter no máximo 20 caracteres")
    private String telefone;
    
    @Email(message = "Email inválido")
    @Size(max = 100, message = "Email deve ter no máximo 100 caracteres")
    private String email;

    public FabricanteDTO() {}

    public FabricanteDTO(String nome, String cnpj) {
        this.nome = nome;
        this.cnpj = cnpj;
    }
    
    public FabricanteDTO(String nome, String cnpj, String telefone, String email) {
        this.nome = nome;
        this.cnpj = cnpj;
        this.telefone = telefone;
        this.email = email;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }
    
    public String getTelefone() {
        return telefone;
    }
    
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
    
    public String getEmail() {
        return email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
}
