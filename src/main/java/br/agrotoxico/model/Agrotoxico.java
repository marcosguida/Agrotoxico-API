package br.agrotoxico.model;

import jakarta.persistence.*;

/*
 * @author Marcos Ribeiro 
 */

@Entity
@Table(name = "agrotoxico")
public class Agrotoxico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 300)
    private String nomeComercial;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TipoFormulacao tipoFormulacao;

    @ManyToOne
    @JoinColumn(name = "fabricante_id", nullable = false)
    private Fabricante fabricante;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomeComercial() {
        return nomeComercial;
    }

    public void setNomeComercial(String nomeComercial) {
        this.nomeComercial = nomeComercial;
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
