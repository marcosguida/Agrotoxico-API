package br.agrotoxico.model;

import jakarta.persistence.*;
import java.util.List;

/*
 * @author Marcos Ribeiro 
 */

@Entity
@Table(name = "fabricante")
public class Fabricante {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 300)
    private String nome;

    @Column(nullable = false, length = 20)
    private String cnpj;

    @OneToMany(mappedBy = "fabricante", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Agrotoxico> agrotoxicos;

    public Fabricante() {}

    public Fabricante(String nome, String cnpj) {
        this.nome = nome;
        this.cnpj = cnpj;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public List<Agrotoxico> getAgrotoxicos() {
        return agrotoxicos;
    }

    public void setAgrotoxicos(List<Agrotoxico> agrotoxicos) {
        this.agrotoxicos = agrotoxicos;
    }
}
