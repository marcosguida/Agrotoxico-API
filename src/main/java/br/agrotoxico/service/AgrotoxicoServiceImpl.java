package br.agrotoxico.service;

import br.agrotoxico.dto.AgrotoxicoDTO;
import br.agrotoxico.dto.AgrotoxicoResponseDTO;
import br.agrotoxico.model.Agrotoxico;
import br.agrotoxico.model.Fabricante;
import br.agrotoxico.model.TipoFormulacao;
import br.agrotoxico.repository.AgrotoxicoRepository;
import br.agrotoxico.repository.FabricanteRepository;
import br.agrotoxico.service.AgrotoxicoService;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.NotFoundException;

import java.util.List;
import java.util.stream.Collectors;

@ApplicationScoped
public class AgrotoxicoServiceImpl implements AgrotoxicoService {

    @Inject
    AgrotoxicoRepository agrotoxicoRepository;

    @Inject
    FabricanteRepository fabricanteRepository;

    @Override
    public AgrotoxicoResponseDTO findById(Long id) {
        Agrotoxico agrotoxico = agrotoxicoRepository.findByIdOptional(id)
                .orElseThrow(() -> new NotFoundException("Agrotóxico não encontrado"));
        return new AgrotoxicoResponseDTO(agrotoxico);
    }

    @Override
    public List<AgrotoxicoResponseDTO> findAll() {
        return agrotoxicoRepository.listAll().stream()
                .map(AgrotoxicoResponseDTO::new)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public AgrotoxicoResponseDTO create(AgrotoxicoDTO dto) {
        Fabricante fabricante = fabricanteRepository.findByIdOptional(dto.fabricanteId())
                .orElseThrow(() -> new NotFoundException("Fabricante não encontrado"));

        Agrotoxico agrotoxico = new Agrotoxico();
        agrotoxico.setNomeComercial(dto.nomeComercial());
        agrotoxico.setTipoFormulacao(dto.tipoFormulacao());
        agrotoxico.setFabricante(fabricante);

        agrotoxicoRepository.persist(agrotoxico);
        return new AgrotoxicoResponseDTO(agrotoxico);
    }

    @Override
    @Transactional
    public AgrotoxicoResponseDTO update(Long id, AgrotoxicoDTO dto) {
        Agrotoxico agrotoxico = agrotoxicoRepository.findByIdOptional(id)
                .orElseThrow(() -> new NotFoundException("Agrotóxico não encontrado"));

        Fabricante fabricante = fabricanteRepository.findByIdOptional(dto.fabricanteId())
                .orElseThrow(() -> new NotFoundException("Fabricante não encontrado"));

        agrotoxico.setNomeComercial(dto.nomeComercial());
        agrotoxico.setTipoFormulacao(dto.tipoFormulacao());
        agrotoxico.setFabricante(fabricante);

        agrotoxicoRepository.persist(agrotoxico);
        return new AgrotoxicoResponseDTO(agrotoxico);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        Agrotoxico agrotoxico = agrotoxicoRepository.findByIdOptional(id)
                .orElseThrow(() -> new NotFoundException("Agrotóxico não encontrado"));
        agrotoxicoRepository.delete(agrotoxico);
    }

    @Override
    @Transactional
    public void softDelete(Long id) {
        Agrotoxico agrotoxico = agrotoxicoRepository.findByIdOptional(id)
                .orElseThrow(() -> new NotFoundException("Agrotóxico não encontrado"));
        agrotoxicoRepository.delete(agrotoxico);
    }

    @Override
    public AgrotoxicoResponseDTO findByNomeComercial(String nomeComercial) {
        List<Agrotoxico> agrotoxicos = agrotoxicoRepository.findByNomeComercial(nomeComercial);
        if (agrotoxicos.isEmpty()) {
            throw new NotFoundException("Agrotóxico não encontrado");
        }
        return new AgrotoxicoResponseDTO(agrotoxicos.get(0));
    }

    @Override
    public List<AgrotoxicoResponseDTO> findByTipoFormulacao(String tipoFormulacao) {
        TipoFormulacao tipo = TipoFormulacao.valueOf(tipoFormulacao);
        return agrotoxicoRepository.list("tipoFormulacao", tipo).stream()
                .map(AgrotoxicoResponseDTO::new)
                .collect(Collectors.toList());
    }

    @Override
    public List<AgrotoxicoResponseDTO> findByFabricante(Long fabricanteId) {
        Fabricante fabricante = fabricanteRepository.findByIdOptional(fabricanteId)
                .orElseThrow(() -> new NotFoundException("Fabricante não encontrado"));
        
        return agrotoxicoRepository.list("fabricante", fabricante).stream()
                .map(AgrotoxicoResponseDTO::new)
                .collect(Collectors.toList());
    }
}