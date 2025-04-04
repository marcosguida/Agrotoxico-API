package br.agrotoxico.dto;

import br.agrotoxico.model.Fabricante;
import jakarta.validation.constraints.NotBlank;

/*
 * @author Marcos Ribeiro 
 */

public class FabricanteDTO {
    @NotBlank(message = "Nome do fabricante não pode ser vazio")
    private String nome;

    @NotBlank(message = "CNPJ do fabricante não pode ser vazio")
    private String cnpj;

    public FabricanteDTO() {}

    public FabricanteDTO(String nome, String cnpj) {
        this.nome = nome;
        this.cnpj = cnpj;
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
}
