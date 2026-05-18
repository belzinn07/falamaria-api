package com.falamaria.api.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.falamaria.api.dto.DepoimentoRequest;
import com.falamaria.api.dto.DepoimentoResponse;
import com.falamaria.api.entity.Depoimento;
import com.falamaria.api.mapper.DepoimentoMapper;
import com.falamaria.api.repository.DepoimentoRepository;


@Service
public class DepoimentoService {

    private final DepoimentoRepository depoimentoRepository;
    private final DepoimentoMapper depoimentoMapper;

    public DepoimentoService(DepoimentoRepository depoimentoRepository, DepoimentoMapper depoimentoMapper) {
        this.depoimentoRepository = depoimentoRepository;
        this.depoimentoMapper = depoimentoMapper;
    }

    @Transactional
    public DepoimentoResponse criarDepoimento(DepoimentoRequest request) {
        Depoimento depoimento = depoimentoMapper.converterParaEntidade(request);
        depoimentoRepository.save(depoimento);
        return depoimentoMapper.converterParaDto(depoimento);

    }

    @Transactional(readOnly = true)
    public List<DepoimentoResponse> buscarTodosDepoimentos() {
        List<Depoimento> depoimentos = depoimentoRepository.findAll();
        return depoimentos.stream()
                .map(depoimentoMapper::converterParaDto)
                .toList();
    }

}
