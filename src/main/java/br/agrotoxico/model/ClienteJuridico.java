package br.agrotoxico.model;

import jakarta.persistence.*;
import java.time.LocalDate;

/**
 * @author Marcos Ribeiro
 */

@Entity
@Table(name = "cliente_juridico")
@PrimaryKeyJoinColumn(name = "pessoa_id")
public class ClienteJuridico extends PessoaJuridica {

    @Column(name = "data_cadastro")
    private LocalDate dataCadastro;

    public ClienteJuridico() {
    }
    
    public ClienteJuridico(String nome, String email, String senha, String cnpj) {
        super(nome, email, senha, cnpj);
        this.dataCadastro = LocalDate.now();
    }

    public LocalDate getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(LocalDate dataCadastro) {
        this.dataCadastro = dataCadastro;
    }
}
