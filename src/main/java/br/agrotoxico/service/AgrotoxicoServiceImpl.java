package br.agrotoxico.service;

import br.agrotoxico.dto.AgrotoxicoDTO;
import br.agrotoxico.dto.AgrotoxicoResponseDTO;
import br.agrotoxico.model.Agrotoxico;
import br.agrotoxico.model.Fabricante;
import br.agrotoxico.model.TipoFormulacao;
import br.agrotoxico.repository.AgrotoxicoRepository;
import br.agrotoxico.repository.FabricanteRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.NotFoundException;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Marcos Ribeiro 
 */
@ApplicationScoped
public class AgrotoxicoServiceImpl implements AgrotoxicoService {

    @Inject
    AgrotoxicoRepository repository;

    @Inject
    FabricanteRepository fabricanteRepository;

    @Override
    public AgrotoxicoResponseDTO findById(Long id) {
        Agrotoxico agrotoxico = repository.findByIdOptional(id)
                .orElseThrow(() -> new NotFoundException("Agrotóxico não encontrado: " + id));
        return new AgrotoxicoResponseDTO(agrotoxico);
    }

    @Override
    public List<AgrotoxicoResponseDTO> findAll() {
        return repository.listAll().stream()
                .map(AgrotoxicoResponseDTO::new)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public AgrotoxicoResponseDTO create(AgrotoxicoDTO dto) {
        Fabricante fabricante = fabricanteRepository.findByIdOptional(dto.fabricanteId())
                .orElseThrow(() -> new NotFoundException("Fabricante não encontrado: " + dto.fabricanteId()));
        
        Agrotoxico agrotoxico = new Agrotoxico();
        agrotoxico.setNomeComercial(dto.nomeComercial());
        agrotoxico.setDescricao(dto.descricao());
        agrotoxico.setCodigoBarras(dto.codigoBarras());
        agrotoxico.setTipoFormulacao(dto.tipoFormulacao());
        agrotoxico.setFabricante(fabricante);
        
        repository.persist(agrotoxico);
        return new AgrotoxicoResponseDTO(agrotoxico);
    }

    @Override
    @Transactional
    public AgrotoxicoResponseDTO update(Long id, AgrotoxicoDTO dto) {
        Agrotoxico agrotoxico = repository.findByIdOptional(id)
                .orElseThrow(() -> new NotFoundException("Agrotóxico não encontrado: " + id));
                
        Fabricante fabricante = fabricanteRepository.findByIdOptional(dto.fabricanteId())
                .orElseThrow(() -> new NotFoundException("Fabricante " + dto.fabricanteId() + " não encontrado."));
        
        agrotoxico.setNomeComercial(dto.nomeComercial());
        agrotoxico.setDescricao(dto.descricao());
        agrotoxico.setCodigoBarras(dto.codigoBarras());
        agrotoxico.setTipoFormulacao(dto.tipoFormulacao());
        agrotoxico.setFabricante(fabricante);
        
        repository.persist(agrotoxico);
        return new AgrotoxicoResponseDTO(agrotoxico);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        Agrotoxico agrotoxico = repository.findByIdOptional(id)
                .orElseThrow(() -> new NotFoundException("Agrotóxico não encontrado: " + id));
        repository.delete(agrotoxico);
    }

    @Override
    @Transactional
    public void softDelete(Long id) {
        delete(id);
    }

    @Override
    public AgrotoxicoResponseDTO findByNomeComercial(String nomeComercial) {
        List<Agrotoxico> agrotoxicos = repository.findByNomeComercial(nomeComercial);
        if (agrotoxicos.isEmpty()) {
            throw new NotFoundException("Agrotóxico " + nomeComercial + " não encontrado.");
        }
        return new AgrotoxicoResponseDTO(agrotoxicos.get(0));
    }

    @Override
    public List<AgrotoxicoResponseDTO> findByTipoFormulacao(String tipoFormulacao) {
        TipoFormulacao tipo = TipoFormulacao.valueOf(tipoFormulacao.toUpperCase());
        return repository.findByTipoFormulacao(tipo).stream()
                .map(AgrotoxicoResponseDTO::new)
                .collect(Collectors.toList());
    }

    @Override
    public List<AgrotoxicoResponseDTO> findByFabricante(Long fabricanteId) {
        Fabricante fabricante = fabricanteRepository.findByIdOptional(fabricanteId)
                .orElseThrow(() -> new NotFoundException("Fabricante não encontrado: " + fabricanteId));
        
        return repository.list("fabricante", fabricante).stream()
                .map(AgrotoxicoResponseDTO::new)
                .collect(Collectors.toList());
    }
}
