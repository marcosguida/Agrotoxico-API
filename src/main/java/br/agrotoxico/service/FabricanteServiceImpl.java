package br.agrotoxico.service;

import br.agrotoxico.dto.FabricanteDTO;
import br.agrotoxico.dto.FabricanteResponseDTO;
import br.agrotoxico.model.Fabricante;
import br.agrotoxico.repository.FabricanteRepository;
import br.agrotoxico.service.FabricanteService;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.NotFoundException;

import java.util.List;
import java.util.stream.Collectors;

@ApplicationScoped
public class FabricanteServiceImpl implements FabricanteService {

    @Inject
    FabricanteRepository fabricanteRepository;

    @Override
    public FabricanteResponseDTO findById(Long id) {
        Fabricante fabricante = fabricanteRepository.findByIdOptional(id)
                .orElseThrow(() -> new NotFoundException("Fabricante não encontrado"));
        return new FabricanteResponseDTO(fabricante);
    }

    @Override
    public List<FabricanteResponseDTO> findAll() {
        return fabricanteRepository.listAll().stream()
                .map(FabricanteResponseDTO::new)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public FabricanteResponseDTO create(FabricanteDTO dto) {
        if (fabricanteRepository.find("cnpj", dto.getCnpj()).firstResult() != null) {
            throw new IllegalArgumentException("CNPJ já cadastrado");
        }

        Fabricante fabricante = new Fabricante(dto.getNome(), dto.getCnpj());
        fabricanteRepository.persist(fabricante);
        return new FabricanteResponseDTO(fabricante);
    }

    @Override
    @Transactional
    public FabricanteResponseDTO update(Long id, FabricanteDTO dto) {
        Fabricante fabricante = fabricanteRepository.findByIdOptional(id)
                .orElseThrow(() -> new NotFoundException("Fabricante não encontrado"));

        fabricante.setNome(dto.getNome());
        fabricante.setCnpj(dto.getCnpj());

        fabricanteRepository.persist(fabricante);
        return new FabricanteResponseDTO(fabricante);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        Fabricante fabricante = fabricanteRepository.findByIdOptional(id)
                .orElseThrow(() -> new NotFoundException("Fabricante não encontrado"));
        fabricanteRepository.delete(fabricante);
    }

    @Override
    @Transactional
    public void softDelete(Long id) {
        Fabricante fabricante = fabricanteRepository.findByIdOptional(id)
                .orElseThrow(() -> new NotFoundException("Fabricante não encontrado"));
        fabricanteRepository.delete(fabricante);
    }

    @Override
    public List<FabricanteResponseDTO> findByNome(String nome) {
        return fabricanteRepository.findByNome(nome).stream()
                .map(FabricanteResponseDTO::new)
                .collect(Collectors.toList());
    }

    @Override
    public FabricanteResponseDTO findByCnpj(String cnpj) {
        Fabricante fabricante = fabricanteRepository.find("cnpj", cnpj).firstResult();
        if (fabricante == null) {
            throw new NotFoundException("Fabricante não encontrado");
        }
        return new FabricanteResponseDTO(fabricante);
    }

}
