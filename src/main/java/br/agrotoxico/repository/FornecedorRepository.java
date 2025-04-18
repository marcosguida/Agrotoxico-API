package br.agrotoxico.repository;

import br.agrotoxico.model.Fornecedor;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import java.util.List;

/**
 * @author Marcos Ribeiro 
 */

@ApplicationScoped
public class FornecedorRepository implements PanacheRepository<Fornecedor> {
    
    public List<Fornecedor> findByNome(String nome) {
        return list("nome LIKE ?1", "%" + nome + "%");
    }
    
    public Fornecedor findByCnpj(String cnpj) {
        return find("cnpj", cnpj).firstResult();
    }
}
