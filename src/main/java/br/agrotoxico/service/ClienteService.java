package br.agrotoxico.service;

import br.agrotoxico.dto.ClienteDTO;
import br.agrotoxico.dto.ClienteResponseDTO;
import br.agrotoxico.model.Cliente;
import br.agrotoxico.model.ContaUsuario;
import br.agrotoxico.model.StatusConta;
import br.agrotoxico.repository.ClienteRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.BadRequestException;
import jakarta.ws.rs.NotFoundException;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Claude
 */
public interface ClienteService {
    ClienteResponseDTO findById(Long id);
    List<ClienteResponseDTO> findAll();
    ClienteResponseDTO create(ClienteDTO dto);
    ClienteResponseDTO update(Long id, ClienteDTO dto);
    void delete(Long id);
    ClienteResponseDTO findByCpf(String cpf);
    ClienteResponseDTO findByEmail(String email);
}

@ApplicationScoped
public class ClienteServiceImpl implements ClienteService {

    @Inject
    ClienteRepository repository;

    @Override
    public ClienteResponseDTO findById(Long id) {
        Cliente cliente = repository.findByIdOptional(id)
                .orElseThrow(() -> new NotFoundException("Cliente não encontrado: " + id));
        return new ClienteResponseDTO(cliente);
    }

    @Override
    public List<ClienteResponseDTO> findAll() {
        return repository.listAll().stream()
                .map(ClienteResponseDTO