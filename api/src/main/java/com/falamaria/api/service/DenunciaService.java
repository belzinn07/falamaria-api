package com.falamaria.api.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.falamaria.api.dto.DenunciaRequestDTO;
import com.falamaria.api.dto.DenunciaResponseDTO;
import com.falamaria.api.entity.Denuncia;
import com.falamaria.api.entity.StatusDenuncia;
import com.falamaria.api.exception.DenunciaNaoEncontradaException;
import com.falamaria.api.repository.DenunciaRepository;

@Service
public class DenunciaService {
  private final DenunciaRepository denunciaRepository;

  public DenunciaService(DenunciaRepository denunciaRepository){
    this.denunciaRepository = denunciaRepository;
  }
  
    private Denuncia converterParaDenuncia(DenunciaRequestDTO denunciaRequestDTO){
    Denuncia denuncia = new Denuncia();
    denuncia.setNome(denunciaRequestDTO.getNome());
    denuncia.setDescricao(denunciaRequestDTO.getDescricao());
    denuncia.setLocalizacao(denunciaRequestDTO.getLocalizacao());
    denuncia.setContato(denunciaRequestDTO.getContato());
    denuncia.setArquivo(denunciaRequestDTO.getArquivo());
    denuncia.setDataEnvio(LocalDateTime.now());
    denuncia.setStatus(StatusDenuncia.PENDENTE);
    return denuncia;
  }  

  private DenunciaResponseDTO converterParaDto(Denuncia denuncia){
    DenunciaResponseDTO responseDTO = new DenunciaResponseDTO();
    responseDTO.setId(denuncia.getId());
    responseDTO.setNome(denuncia.getNome());
    responseDTO.setDescricao(denuncia.getDescricao());
    responseDTO.setLocalizacao(denuncia.getLocalizacao());
    responseDTO.setContato(denuncia.getContato());
    responseDTO.setArquivo(denuncia.getArquivo());
    responseDTO.setDataEnvio(denuncia.getDataEnvio().toString());
    responseDTO.setStatus(denuncia.getStatus().toString());
    return responseDTO;
  }
  
  @Transactional
  public DenunciaResponseDTO criarDenuncia(DenunciaRequestDTO denunciaRequestDTO){
   Denuncia denuncia = converterParaDenuncia(denunciaRequestDTO);
   denunciaRepository.save(denuncia);
   return converterParaDto(denuncia);
 }

 public List<DenunciaResponseDTO> buscarTodasDenuncias(){
    List<Denuncia> denuncias = denunciaRepository.findAll(); 
    return denuncias.stream()
    .map(this::converterParaDto)
    .toList(); 
  }

  @Transactional(readOnly = true)
public DenunciaResponseDTO buscarDenunciaPorId(Long id){
    Denuncia denuncia = denunciaRepository.findById(id)
        .orElseThrow(() -> new DenunciaNaoEncontradaException("Denúncia com ID " + id + " não encontrada."));
    return converterParaDto(denuncia);
}

@Transactional
public DenunciaResponseDTO atualizarStatusDenuncia(Long id, StatusDenuncia status){
    Denuncia denuncia = denunciaRepository.findById(id)
    .orElseThrow(() -> new DenunciaNaoEncontradaException("Denúncia com ID " + id + " não encontrada."));
    denuncia.setStatus(status);
    denunciaRepository.save(denuncia);
    return converterParaDto(denuncia);
}

}
