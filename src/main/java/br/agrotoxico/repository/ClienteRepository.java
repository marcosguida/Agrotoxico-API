package br.agrotoxico.repository;

import br.agrotoxico.model.Cliente;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import java.util.Optional;

/**
 * @author Marcos Ribeiro
 */

@ApplicationScoped
public class ClienteRepository implements PanacheRepository<Cliente> {
    
    public Optional<Cliente> findByCpf(String cpf) {
        return find("cpf", cpf).firstResultOptional();
    }
    
    public Optional<Cliente> findByEmail(String email) {
        return find("email", email).firstResultOptional();
    }
    
    public boolean existsByCpf(String cpf) {
        return count("cpf", cpf) > 0;
    }
    
    public boolean existsByEmail(String email) {
        return count("email", email) > 0;
    }
}
