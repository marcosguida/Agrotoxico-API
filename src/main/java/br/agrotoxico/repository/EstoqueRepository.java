package br.agrotoxico.repository;

import br.agrotoxico.model.Estoque;
import br.agrotoxico.model.Agrotoxico;
import br.agrotoxico.model.Fornecedor;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import java.time.LocalDate;
import java.util.List;

/**
 * @author Marcos Ribeiro 
 */

@ApplicationScoped
public class EstoqueRepository implements PanacheRepository<Estoque> {

    public List<Estoque> findByAgrotoxico(Agrotoxico agrotoxico) {
        return list("agrotoxico", agrotoxico);
    }
    
    public List<Estoque> findByFornecedor(Fornecedor fornecedor) {
        return list("fornecedor", fornecedor);
    }
    
    public List<Estoque> findByLote(String lote) {
        return list("lote", lote);
    }
    
    public List<Estoque> findByDataValidadeBefore(LocalDate data) {
        return list("dataValidade < ?1", data);
    }
    
    public List<Estoque> findLowStock(int quantidadeMinima) {
        return list("quantidade < ?1", quantidadeMinima);
    }
}
