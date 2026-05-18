package com.falamaria.api.mapper;

import java.time.LocalDateTime;

import com.falamaria.api.dto.DepoimentoRequest;
import com.falamaria.api.dto.DepoimentoResponse;
import com.falamaria.api.entity.Depoimento;

public class DepoimentoMapper {

    public Depoimento converterParaEntidade(DepoimentoRequest request) {
        if (request == null) {
            return null;
        }

        Depoimento depoimento = new Depoimento();
        depoimento.setNome(request.getNome());
        depoimento.setMensagem(request.getMensagem());
        depoimento.setDataEnvio(LocalDateTime.now());
        return depoimento;
    }

    public DepoimentoResponse converterParaDto(Depoimento depoimento) {
        if (depoimento == null) {
            return null;
        }

        DepoimentoResponse response = new DepoimentoResponse();
        response.setId(depoimento.getId());
        response.setNome(depoimento.getNome());
        response.setMensagem(depoimento.getMensagem());
        response.setDataEnvio(depoimento.getDataEnvio().toString());
        return response;
    }

}
