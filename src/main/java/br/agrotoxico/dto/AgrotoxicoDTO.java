package br.agrotoxico.dto;

import br.agrotoxico.model.TipoFormulacao;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class AgrotoxicoDTO {

    @NotBlank(message = "O nome comercial do agrotóxico não pode estar em branco")
    private String nomeComercial;

    @NotNull(message = "O tipo de formulação não pode ser nulo")
    private TipoFormulacao tipoFormulacao;

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
