package br.agrotoxico.service;

import br.agrotoxico.dto.AgrotoxicoDTO;
import br.agrotoxico.dto.AgrotoxicoResponseDTO;
import java.util.List;

/*
 * @author Marcos Ribeiro 
 */

public interface AgrotoxicoService {
    
    AgrotoxicoResponseDTO findById(Long id);
    List<AgrotoxicoResponseDTO> findAll();
    AgrotoxicoResponseDTO create(AgrotoxicoDTO dto);
    AgrotoxicoResponseDTO update(Long id, AgrotoxicoDTO dto);
    void delete(Long id);
    void softDelete(Long id);
    AgrotoxicoResponseDTO findByNomeComercial(String nomeComercial);
    List<AgrotoxicoResponseDTO> findByTipoFormulacao(String tipoFormulacao);
    List<AgrotoxicoResponseDTO> findByFabricante(Long fabricanteId);
    
}
