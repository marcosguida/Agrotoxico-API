package br.agrotoxico.service;

import br.agrotoxico.dto.FabricanteDTO;
import br.agrotoxico.dto.FabricanteResponseDTO;
import br.agrotoxico.model.Fabricante;
import br.agrotoxico.repository.FabricanteRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.BadRequestException;
import jakarta.ws.rs.NotFoundException;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Marcos Ribeiro 
 */
@ApplicationScoped
public class FabricanteServiceImpl implements FabricanteService {

    @Inject
    FabricanteRepository repository;

    @Override
    public FabricanteResponseDTO findById(Long id) {
        Fabricante fabricante = repository.findByIdOptional(id)
                .orElseThrow(() -> new NotFoundException("Fabricante não encontrado: " + id));
        return new FabricanteResponseDTO(fabricante);
    }

    @Override
    public List<FabricanteResponseDTO> findAll() {
        return repository.listAll().stream()
                .map(FabricanteResponseDTO::new)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public FabricanteResponseDTO create(FabricanteDTO dto) {
        Fabricante fabricante = new Fabricante();
        fabricante.setNome(dto.getNome());
        fabricante.setCnpj(dto.getCnpj());
        fabricante.setTelefone(dto.getTelefone());
        fabricante.setEmail(dto.getEmail());
        
        repository.persist(fabricante);
        return new FabricanteResponseDTO(fabricante);
    }

    @Override
    @Transactional
    public FabricanteResponseDTO update(Long id, FabricanteDTO dto) {
        Fabricante fabricante = repository.findByIdOptional(id)
                .orElseThrow(() -> new NotFoundException("Fabricante não encontrado: " + id));
        
        fabricante.setNome(dto.getNome());
        fabricante.setCnpj(dto.getCnpj());
        fabricante.setTelefone(dto.getTelefone());
        fabricante.setEmail(dto.getEmail());
        
        repository.persist(fabricante);
        return new FabricanteResponseDTO(fabricante);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        Fabricante fabricante = repository.findByIdOptional(id)
                .orElseThrow(() -> new NotFoundException("Fabricante não encontrado: " + id));
        
        if (!fabricante.getAgrotoxicos().isEmpty()) {
            throw new BadRequestException("Não é possível excluir o fabricante pois existem agrotóxicos associados");
        }
        
        repository.delete(fabricante);
    }

    @Override
    @Transactional
    public void softDelete(Long id) {
        delete(id);
    }

    @Override
    public List<FabricanteResponseDTO> findByNome(String nome) {
        return repository.findByNome(nome).stream()
                .map(FabricanteResponseDTO::new)
                .collect(Collectors.toList());
    }

    @Override
    public FabricanteResponseDTO findByCnpj(String cnpj) {
        Fabricante fabricante = repository.find("cnpj", cnpj).firstResult();
        if (fabricante == null) {
            throw new NotFoundException("Fabricante não encontrado com CNPJ: " + cnpj);
        }
        return new FabricanteResponseDTO(fabricante);
    }
}
