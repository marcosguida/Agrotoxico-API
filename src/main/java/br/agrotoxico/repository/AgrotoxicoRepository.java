package br.agrotoxico.repository;

import br.agrotoxico.model.Agrotoxico;
import br.agrotoxico.model.TipoFormulacao;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import java.util.List;

@ApplicationScoped
public class AgrotoxicoRepository implements PanacheRepository<Agrotoxico> {

    public List<Agrotoxico> findByNomeComercial(String nomeComercial) {
        return list("nomeComercial LIKE ?1", "%" + nomeComercial + "%");
    }

    public List<Agrotoxico> findByTipoFormulacao(String tipoFormulacao) {
        return list("tipoFormulacao = ?1", TipoFormulacao.valueOf(null, tipoFormulacao));
    }
}
