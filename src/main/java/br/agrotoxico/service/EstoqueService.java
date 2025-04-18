package br.agrotoxico.service;

import br.agrotoxico.dto.EstoqueDTO;
import br.agrotoxico.dto.EstoqueResponseDTO;
import java.util.List;
import java.time.LocalDate;

/**
 * @author Marcos Ribeiro 
 */

public interface EstoqueService {
    
    EstoqueResponseDTO findById(Long id);
    List<EstoqueResponseDTO> findAll();
    EstoqueResponseDTO create(EstoqueDTO dto);
    EstoqueResponseDTO update(Long id, EstoqueDTO dto);
    void delete(Long id);
    void softDelete(Long id);
    List<EstoqueResponseDTO> findByAgrotoxico(Long agrotoxicoId);
    List<EstoqueResponseDTO> findByFornecedor(Long fornecedorId);
    List<EstoqueResponseDTO> findByLote(String lote);
    List<EstoqueResponseDTO> findByDataValidadeBefore(LocalDate data);
    List<EstoqueResponseDTO> findLowStock(int quantidadeMinima);
    EstoqueResponseDTO atualizarPrecoVenda(Long id, Double precoVenda);
    EstoqueResponseDTO atualizarQuantidade(Long id, Integer quantidade);
    List<EstoqueResponseDTO> findByDataValidade(String data);
}
