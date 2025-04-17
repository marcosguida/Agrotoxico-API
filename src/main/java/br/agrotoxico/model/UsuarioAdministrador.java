package br.agrotoxico.model;

import jakarta.persistence.*;
import java.time.LocalDate;

/**
 * @author Marcos Ribeiro
 */

@Entity
@Table(name = "usuario_administrador")
@PrimaryKeyJoinColumn(name = "pessoa_id")
public class UsuarioAdministrador extends PessoaJuridica {

    @Column(length = 100)
    private String cargo;
    
    @Column(length = 100)
    private String departamento;
    
    @Column(name = "nivel_acesso", length = 50)
    private String nivelAcesso;

    public UsuarioAdministrador() {
    }
    
    public UsuarioAdministrador(String nome, String email, String senha, String cnpj, 
                              String cargo, String departamento, String nivelAcesso) {
        super(nome, email, senha, cnpj);
        this.cargo = cargo;
        this.departamento = departamento;
        this.nivelAcesso = nivelAcesso;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public String getNivelAcesso() {
        return nivelAcesso;
    }

    public void setNivelAcesso(String nivelAcesso) {
        this.nivelAcesso = nivelAcesso;
    }
}
