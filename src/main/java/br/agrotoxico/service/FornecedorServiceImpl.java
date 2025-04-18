package br.agrotoxico.service;

import br.agrotoxico.dto.FornecedorDTO;
import br.agrotoxico.dto.FornecedorResponseDTO;
import br.agrotoxico.model.Fornecedor;
import br.agrotoxico.repository.FornecedorRepository;
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
public class FornecedorServiceImpl implements FornecedorService {

    @Inject
    FornecedorRepository repository;

    @Override
    public FornecedorResponseDTO findById(Long id) {
        Fornecedor fornecedor = repository.findByIdOptional(id)
                .orElseThrow(() -> new NotFoundException("Fornecedor não encontrado: " + id));
        return new FornecedorResponseDTO(fornecedor);
    }

    @Override
    public List<FornecedorResponseDTO> findAll() {
        return repository.listAll().stream()
                .map(FornecedorResponseDTO::new)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public FornecedorResponseDTO create(FornecedorDTO dto) {

        // Verifica se já existe um fornecedor com o CNPJ informado
        if (repository.findByCnpj(dto.getCnpj()) != null) {
            throw new BadRequestException("Já existe um fornecedor cadastrado com o CNPJ: " + dto.getCnpj());
        }
        
        Fornecedor fornecedor = new Fornecedor();
        fornecedor.setNome(dto.getNome());
        fornecedor.setCnpj(dto.getCnpj());
        fornecedor.setTelefone(dto.getTelefone());
        fornecedor.setEmail(dto.getEmail());
        fornecedor.setWebsite(dto.getWebsite());
        
        repository.persist(fornecedor);
        return new FornecedorResponseDTO(fornecedor);
    }

    @Override
    @Transactional
    public FornecedorResponseDTO update(Long id, FornecedorDTO dto) {
        Fornecedor fornecedor = repository.findByIdOptional(id)
                .orElseThrow(() -> new NotFoundException("Fornecedor não encontrado: " + id));
        
        // Verifica se já existe outro fornecedor com o CNPJ informado
        Fornecedor existingFornecedor = repository.findByCnpj(dto.getCnpj());
        if (existingFornecedor != null && !existingFornecedor.getId().equals(id)) {
            throw new BadRequestException("Já existe um fornecedor cadastrado com o CNPJ: " + dto.getCnpj());
        }
        
        fornecedor.setNome(dto.getNome());
        fornecedor.setCnpj(dto.getCnpj());
        fornecedor.setTelefone(dto.getTelefone());
        fornecedor.setEmail(dto.getEmail());
        fornecedor.setWebsite(dto.getWebsite());
        
        repository.persist(fornecedor);
        return new FornecedorResponseDTO(fornecedor);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        Fornecedor fornecedor = repository.findByIdOptional(id)
                .orElseThrow(() -> new NotFoundException("Fornecedor não encontrado: " + id));
        
        if (!fornecedor.getItensEstoque().isEmpty()) {
            throw new BadRequestException("Não é possível excluir o fornecedor pois existem itens de estoque associados");
        }
        
        repository.delete(fornecedor);
    }

    @Override
    @Transactional
    public void softDelete(Long id) {
        delete(id);
    }

    @Override
    public List<FornecedorResponseDTO> findByNome(String nome) {
        return repository.findByNome(nome).stream()
                .map(FornecedorResponseDTO::new)
                .collect(Collectors.toList());
    }

    @Override
    public FornecedorResponseDTO findByCnpj(String cnpj) {
        Fornecedor fornecedor = repository.findByCnpj(cnpj);
        if (fornecedor == null) {
            throw new NotFoundException("Fornecedor não encontrado com CNPJ: " + cnpj);
        }
        return new FornecedorResponseDTO(fornecedor);
    }
}
