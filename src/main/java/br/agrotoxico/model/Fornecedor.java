package br.agrotoxico.model;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Marcos Ribeiro 
 */

@Entity
@Table(name = "fornecedor")
public class Fornecedor extends DefaultEntity {

    @Column(nullable = false, length = 300)
    private String nome;

    @Column(nullable = false, length = 20, unique = true)
    private String cnpj;
    
    @Column(length = 20)
    private String telefone;
    
    @Column(length = 100)
    private String email;
    
    @Column(length = 200)
    private String website;

    @OneToMany(mappedBy = "fornecedor", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Estoque> itensEstoque = new ArrayList<>();

    @ManyToMany
    @JoinTable(
        name = "fornecedor_agrotoxico",
        joinColumns = @JoinColumn(name = "fornecedor_id"),
        inverseJoinColumns = @JoinColumn(name = "agrotoxico_id")
    )
    private List<Agrotoxico> agrotoxicosFornecidos = new ArrayList<>();

    public Fornecedor() {
    }

    public Fornecedor(String nome, String cnpj) {
        this.nome = nome;
        this.cnpj = cnpj;
    }
    
    public Fornecedor(String nome, String cnpj, String telefone, String email, String website) {
        this.nome = nome;
        this.cnpj = cnpj;
        this.telefone = telefone;
        this.email = email;
        this.website = website;
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
    
    public String getWebsite() {
        return website;
    }
    
    public void setWebsite(String website) {
        this.website = website;
    }

    public List<Estoque> getItensEstoque() {
        return itensEstoque;
    }

    public void setItensEstoque(List<Estoque> itensEstoque) {
        this.itensEstoque = itensEstoque;
    }
    
    public void addItemEstoque(Estoque estoque) {
        itensEstoque.add(estoque);
        estoque.setFornecedor(this);
    }
    
    public void removeItemEstoque(Estoque estoque) {
        itensEstoque.remove(estoque);
        estoque.setFornecedor(null);
    }
    
    public List<Agrotoxico> getAgrotoxicosFornecidos() {
        return agrotoxicosFornecidos;
    }
    
    public void setAgrotoxicosFornecidos(List<Agrotoxico> agrotoxicosFornecidos) {
        this.agrotoxicosFornecidos = agrotoxicosFornecidos;
    }
    
    public void addAgrotoxicoFornecido(Agrotoxico agrotoxico) {
        this.agrotoxicosFornecidos.add(agrotoxico);
    }
    
    public void removeAgrotoxicoFornecido(Agrotoxico agrotoxico) {
        this.agrotoxicosFornecidos.remove(agrotoxico);
    }
}
