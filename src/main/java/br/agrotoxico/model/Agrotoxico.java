package br.agrotoxico.model;

import jakarta.persistence.*;

/**
 * @author Marcos Ribeiro 
 */
@Entity
@Table(name = "agrotoxico")
public class Agrotoxico extends DefaultEntity {

    @Column(nullable = false, length = 300)
    private String nomeComercial;
    
    @Column(length = 1000)
    private String descricao;
    
    @Column(name = "codigo_barras", length = 50)
    private String codigoBarras;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TipoFormulacao tipoFormulacao;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fabricante_id", nullable = false)
    private Fabricante fabricante;

    public Agrotoxico() {
        // Construtor padrão
    }
    
    public Agrotoxico(String nomeComercial, TipoFormulacao tipoFormulacao, Fabricante fabricante) {
        this.nomeComercial = nomeComercial;
        this.tipoFormulacao = tipoFormulacao;
        this.fabricante = fabricante;
    }

    public String getNomeComercial() {
        return nomeComercial;
    }

    public void setNomeComercial(String nomeComercial) {
        this.nomeComercial = nomeComercial;
    }
    
    public String getDescricao() {
        return descricao;
    }
    
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    
    public String getCodigoBarras() {
        return codigoBarras;
    }
    
    public void setCodigoBarras(String codigoBarras) {
        this.codigoBarras = codigoBarras;
    }

    public TipoFormulacao getTipoFormulacao() {
        return tipoFormulacao;
    }

    public void setTipoFormulacao(TipoFormulacao tipoFormulacao) {
        this.tipoFormulacao = tipoFormulacao;
    }

    public Fabricante getFabricante() {
        return fabricante;
    }

    public void setFabricante(Fabricante fabricante) {
        this.fabricante = fabricante;
    }
}
