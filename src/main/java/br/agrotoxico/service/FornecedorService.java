package br.agrotoxico.service;

import br.agrotoxico.dto.FornecedorDTO;
import br.agrotoxico.dto.FornecedorResponseDTO;
import java.util.List;

/**
 * @author Marcos Ribeiro 
 */

public interface FornecedorService {

    FornecedorResponseDTO findById(Long id);
    List<FornecedorResponseDTO> findAll();
    FornecedorResponseDTO create(FornecedorDTO dto);
    FornecedorResponseDTO update(Long id, FornecedorDTO dto);
    void delete(Long id);
    void softDelete(Long id);
    List<FornecedorResponseDTO> findByNome(String nome);
    FornecedorResponseDTO findByCnpj(String cnpj);
}
