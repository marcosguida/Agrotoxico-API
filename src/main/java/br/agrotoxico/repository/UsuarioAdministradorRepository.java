package br.agrotoxico.repository;

import br.agrotoxico.model.Cliente;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import java.util.Optional;

/**
 * @author Marcos Ribeiro
 */

@ApplicationScoped
public class UsuarioAdministradorRepository implements PanacheRepository<UsuarioAdministrador> {
    
    public Optional<UsuarioAdministrador> findByCnpj(String cnpj) {
        return find("cnpj", cnpj).firstResultOptional();
    }
    
    public Optional<UsuarioAdministrador> findByEmail(String email) {
        return find("email", email).firstResultOptional();
    }
    
    public boolean existsByCnpj(String cnpj) {
        return count("cnpj", cnpj) > 0;
    }
    
    public boolean existsByEmail(String email) {
        return count("email", email) > 0;
    }
}
