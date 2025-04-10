package br.agrotoxico.model;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Marcos Ribeiro 
 */
@Entity
@Table(name = "fabricante")
public class Fabricante extends DefaultEntity {

    @Column(nullable = false, length = 300)
    private String nome;

    @Column(nullable = false, length = 20, unique = true)
    private String cnpj;
    
    @Column(length = 20)
    private String telefone;
    
    @Column(length = 100)
    private String email;

    @OneToMany(mappedBy = "fabricante", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Agrotoxico> agrotoxicos = new ArrayList<>();

    public Fabricante() {
        // Construtor padrão
    }

    public Fabricante(String nome, String cnpj) {
        this.nome = nome;
        this.cnpj = cnpj;
    }
    
    public Fabricante(String nome, String cnpj, String telefone, String email) {
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

    public List<Agrotoxico> getAgrotoxicos() {
        return agrotoxicos;
    }

    public void setAgrotoxicos(List<Agrotoxico> agrotoxicos) {
        this.agrotoxicos = agrotoxicos;
    }
    
    public void addAgrotoxico(Agrotoxico agrotoxico) {
        agrotoxicos.add(agrotoxico);
        agrotoxico.setFabricante(this);
    }
    
    public void removeAgrotoxico(Agrotoxico agrotoxico) {
        agrotoxicos.remove(agrotoxico);
        agrotoxico.setFabricante(null);
    }
}
