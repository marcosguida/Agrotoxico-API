package br.agrotoxico.service;

import br.agrotoxico.dto.AgrotoxicoDTO;
import br.agrotoxico.dto.AgrotoxicoResponseDTO;
import br.agrotoxico.model.Agrotoxico;
import br.agrotoxico.repository.AgrotoxicoRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.NotFoundException;
import java.util.List;
import java.util.stream.Collectors;

@ApplicationScoped
public class AgrotoxicoService {

    @Inject
    AgrotoxicoRepository repository;

    public List<AgrotoxicoResponseDTO> findAll() {
        return repository.findAll().stream()
                .map(AgrotoxicoResponseDTO::new)
                .collect(Collectors.toList());
    }

    public AgrotoxicoResponseDTO findById(Long id) {
        Agrotoxico agrotoxico = repository.findById(id);
        if (agrotoxico == null) {
            throw new NotFoundException("Agrotóxico não encontrado com o ID: " + id);
        }
        return new AgrotoxicoResponseDTO(agrotoxico);
    }

    public List<AgrotoxicoResponseDTO> findByNomeComercial(String nomeComercial) {
        return repository.findByNomeComercial(nomeComercial).stream()
                .map(AgrotoxicoResponseDTO::new)
                .collect(Collectors.toList());
    }

    public List<AgrotoxicoResponseDTO> findByTipoFormulacao(String tipoFormulacao) {
        return repository.findByTipoFormulacao(tipoFormulacao).stream()
                .map(AgrotoxicoResponseDTO::new)
                .collect(Collectors.toList());
    }

    @Transactional
    public AgrotoxicoResponseDTO create(AgrotoxicoDTO dto) {
        Agrotoxico agrotoxico = new Agrotoxico();
        updateEntityFromDTO(agrotoxico, dto);
        repository.persist(agrotoxico);
        return new AgrotoxicoResponseDTO(agrotoxico);
    }

    @Transactional
    public AgrotoxicoResponseDTO update(Long id, AgrotoxicoDTO dto) {
        Agrotoxico agrotoxico = repository.findById(id);
        if (agrotoxico == null) {
            throw new NotFoundException("Agrotóxico não encontrado com o ID: " + id);
        }
        updateEntityFromDTO(agrotoxico, dto);
        repository.persist(agrotoxico);
        return new AgrotoxicoResponseDTO(agrotoxico);
    }

    @Transactional
    public void delete(Long id) {
        Agrotoxico agrotoxico = repository.findById(id);
        if (agrotoxico == null) {
            throw new NotFoundException("Agrotóxico não encontrado com o ID: " + id);
        }
        repository.delete(agrotoxico);
    }

    private void updateEntityFromDTO(Agrotoxico agrotoxico, AgrotoxicoDTO dto) {
        agrotoxico.setNomeComercial(dto.getNomeComercial());
        agrotoxico.setTipoFormulacao(dto.getTipoFormulacao());
    }
}
