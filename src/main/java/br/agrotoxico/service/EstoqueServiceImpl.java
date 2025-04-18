package br.agrotoxico.service;

import br.agrotoxico.dto.EstoqueDTO;
import br.agrotoxico.dto.EstoqueResponseDTO;
import br.agrotoxico.model.Estoque;
import br.agrotoxico.model.Agrotoxico;
import br.agrotoxico.model.Fornecedor;
import br.agrotoxico.repository.EstoqueRepository;
import br.agrotoxico.repository.AgrotoxicoRepository;
import br.agrotoxico.repository.FornecedorRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.NotFoundException;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Marcos Ribeiro 
 */

@ApplicationScoped
public class EstoqueServiceImpl implements EstoqueService {

    @Inject
    EstoqueRepository repository;
    
    @Inject
    AgrotoxicoRepository agrotoxicoRepository;
    
    @Inject
    FornecedorRepository fornecedorRepository;

    @Override
    public EstoqueResponseDTO findById(Long id) {
        Estoque estoque = repository.findByIdOptional(id)
                .orElseThrow(() -> new NotFoundException("Item de estoque não encontrado: " + id));
        return new EstoqueResponseDTO(estoque);
    }

    @Override
    public List<EstoqueResponseDTO> findAll() {
        return repository.listAll().stream()
                .map(EstoqueResponseDTO::new)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public EstoqueResponseDTO create(EstoqueDTO dto) {
        Agrotoxico agrotoxico = agrotoxicoRepository.findByIdOptional(dto.agrotoxicoId())
                .orElseThrow(() -> new NotFoundException("Agrotóxico não encontrado: " + dto.agrotoxicoId()));
                
        Fornecedor fornecedor = fornecedorRepository.findByIdOptional(dto.fornecedorId())
                .orElseThrow(() -> new NotFoundException("Fornecedor não encontrado: " + dto.fornecedorId()));
        
        Estoque estoque = new Estoque();
        estoque.setQuantidade(dto.quantidade());
        estoque.setDataEntrada(dto.dataEntrada());
        estoque.setDataValidade(dto.dataValidade());
        estoque.setLote(dto.lote());
        estoque.setPrecoCompra(dto.precoCompra());
        estoque.setPrecoVenda(dto.precoVenda());
        estoque.setAgrotoxico(agrotoxico);
        estoque.setFornecedor(fornecedor);
        
        repository.persist(estoque);
        return new EstoqueResponseDTO(estoque);
    }

    @Override
    @Transactional
    public EstoqueResponseDTO update(Long id, EstoqueDTO dto) {
        Estoque estoque = repository.findByIdOptional(id)
                .orElseThrow(() -> new NotFoundException("Item de estoque não encontrado: " + id));
                
        Agrotoxico agrotoxico = agrotoxicoRepository.findByIdOptional(dto.agrotoxicoId())
                .orElseThrow(() -> new NotFoundException("Agrotóxico não encontrado: " + dto.agrotoxicoId()));
                
        Fornecedor fornecedor = fornecedorRepository.findByIdOptional(dto.fornecedorId())
                .orElseThrow(() -> new NotFoundException("Fornecedor não encontrado: " + dto.fornecedorId()));
        
        estoque.setQuantidade(dto.quantidade());
        estoque.setDataEntrada(dto.dataEntrada());
        estoque.setDataValidade(dto.dataValidade());
        estoque.setLote(dto.lote());
        estoque.setPrecoCompra(dto.precoCompra());
        estoque.setPrecoVenda(dto.precoVenda());
        estoque.setAgrotoxico(agrotoxico);
        estoque.setFornecedor(fornecedor);
        
        repository.persist(estoque);
        return new EstoqueResponseDTO(estoque);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        Estoque estoque = repository.findByIdOptional(id)
                .orElseThrow(() -> new NotFoundException("Item de estoque não encontrado: " + id));
        repository.delete(estoque);
    }

    @Override
    @Transactional
    public void softDelete(Long id) {
        delete(id);
    }

    @Override
    public List<EstoqueResponseDTO> findByAgrotoxico(Long agrotoxicoId) {
        Agrotoxico agrotoxico = agrotoxicoRepository.findByIdOptional(agrotoxicoId)
                .orElseThrow(() -> new NotFoundException("Agrotóxico não encontrado: " + agrotoxicoId));
                
        return repository.findByAgrotoxico(agrotoxico).stream()
                .map(EstoqueResponseDTO::new)
                .collect(Collectors.toList());
    }

    @Override
    public List<EstoqueResponseDTO> findByFornecedor(Long fornecedorId) {
        Fornecedor fornecedor = fornecedorRepository.findByIdOptional(fornecedorId)
                .orElseThrow(() -> new NotFoundException("Fornecedor não encontrado: " + fornecedorId));
                
        return repository.findByFornecedor(fornecedor).stream()
                .map(EstoqueResponseDTO::new)
                .collect(Collectors.toList());
    }

    @Override
    public List<EstoqueResponseDTO> findByLote(String lote) {
        return repository.findByLote(lote).stream()
                .map(EstoqueResponseDTO::new)
                .collect(Collectors.toList());
    }

    @Override
    public List<EstoqueResponseDTO> findByDataValidadeBefore(LocalDate data) {
        return repository.findByDataValidadeBefore(data).stream()
                .map(EstoqueResponseDTO::new)
                .collect(Collectors.toList());
    }

    @Override
    public List<EstoqueResponseDTO> findLowStock(int quantidadeMinima) {
        return repository.findLowStock(quantidadeMinima).stream()
                .map(EstoqueResponseDTO::new)
                .collect(Collectors.toList());
    }

    @Override
    public EstoqueResponseDTO atualizarPrecoVenda(Long id, Double precoVenda) {
        throw new UnsupportedOperationException("Unimplemented method 'atualizarPrecoVenda'");
    }

    @Override
    public EstoqueResponseDTO atualizarQuantidade(Long id, Integer quantidade) {
        throw new UnsupportedOperationException("Unimplemented method 'atualizarQuantidade'");
    }

    @Override
    public List<EstoqueResponseDTO> findByDataValidade(String data) {
        throw new UnsupportedOperationException("Unimplemented method 'findByDataValidade'");
    }
}
