package br.agrotoxico.model;

import br.agrotoxico.model.TipoFormulacao;
import jakarta.persistence.*;

@Entity
@Table(name = "agrotoxico")
public class Agrotoxico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nomeComercial;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TipoFormulacao tipoFormulacao;

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
}
