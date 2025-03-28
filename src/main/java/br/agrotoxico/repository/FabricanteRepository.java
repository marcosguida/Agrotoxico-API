package br.agrotoxico.repository;

import br.agrotoxico.model.Fabricante;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.List;

@ApplicationScoped
public class FabricanteRepository implements PanacheRepository<Fabricante> {
    
    public List<Fabricante> findByNome(String nome) {
        return list("nome LIKE ?1", "%" + nome + "%");
    }
}
