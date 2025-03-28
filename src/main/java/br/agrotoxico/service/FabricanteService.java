package br.agrotoxico.service;

import br.agrotoxico.dto.FabricanteDTO;
import br.agrotoxico.dto.FabricanteResponseDTO;
import java.util.List;

public interface FabricanteService {

    FabricanteResponseDTO findById(Long id);
    List<FabricanteResponseDTO> findAll();
    FabricanteResponseDTO create(FabricanteDTO dto);
    FabricanteResponseDTO update(Long id, FabricanteDTO dto);
    void delete(Long id);
    void softDelete(Long id);
    List<FabricanteResponseDTO> findByNome(String nome);
    FabricanteResponseDTO findByCnpj(String cnpj);
    
}
