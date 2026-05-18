package com.falamaria.api.service;

import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.falamaria.api.dto.DenunciaRequest;
import com.falamaria.api.dto.DenunciaResponse;
import com.falamaria.api.entity.Denuncia;
import com.falamaria.api.entity.StatusDenuncia;
import com.falamaria.api.exception.DenunciaNaoEncontradaException;
import com.falamaria.api.mapper.DenunciaMapper;
import com.falamaria.api.repository.DenunciaRepository;

@Service
public class DenunciaService {
  private final DenunciaRepository denunciaRepository;
  private final DenunciaMapper denunciaMapper;

  public DenunciaService(DenunciaRepository denunciaRepository, DenunciaMapper denunciaMapper) {
    this.denunciaRepository = denunciaRepository;
    this.denunciaMapper = denunciaMapper;
  }

  @Transactional
  public DenunciaResponse criarDenuncia(DenunciaRequest denunciaRequest) {
    Denuncia denuncia = denunciaMapper.converterParaEntidade(denunciaRequest);
    denunciaRepository.save(denuncia);
    return denunciaMapper.converterParaDto(denuncia);
  }

  @Transactional(readOnly = true)
  public List<DenunciaResponse> buscarTodasDenuncias() {
    List<Denuncia> denuncias = denunciaRepository.findAll();
    return denuncias.stream()
        .map(denunciaMapper::converterParaDto)
        .toList();
  }

  @Transactional(readOnly = true)
  public DenunciaResponse buscarDenunciaPorId(Long id) {
    Denuncia denuncia = denunciaRepository.findById(id)
        .orElseThrow(() -> new DenunciaNaoEncontradaException("Denúncia com ID " + id + " não encontrada."));
    return denunciaMapper.converterParaDto(denuncia);
  }

  @Transactional(readOnly = true)
  public List<DenunciaResponse> buscarDenunciasPorStatus(StatusDenuncia status) {
    return denunciaRepository.findByStatus(status).stream()
        .map(denunciaMapper::converterParaDto)
        .toList();
  }

  @Transactional
  public DenunciaResponse atualizarStatusDenuncia(Long id, StatusDenuncia status) {
    Denuncia denuncia = denunciaRepository.findById(id)
        .orElseThrow(() -> new DenunciaNaoEncontradaException("Denúncia com ID " + id + " não encontrada."));
    denuncia.setStatus(status);
    return denunciaMapper.converterParaDto(denuncia);
  }

}
