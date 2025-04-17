package br.agrotoxico.model;

import jakarta.persistence.*;
import java.time.LocalDate;

/**
 * @author Marcos Ribeiro
 */

@Entity
@Table(name = "cliente")
@PrimaryKeyJoinColumn(name = "pessoa_id")
public class Cliente extends PessoaFisica {

    @Column(name = "data_cadastro")
    private LocalDate dataCadastro;

    public Cliente() {
    }
    
    public Cliente(String nome, String email, String senha, String cpf) {
        super(nome, email, senha, cpf);
        this.dataCadastro = LocalDate.now();
    }

    public LocalDate getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(LocalDate dataCadastro) {
        this.dataCadastro = dataCadastro;
    }
}
