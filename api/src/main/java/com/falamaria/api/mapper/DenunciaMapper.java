package com.falamaria.api.mapper;

import java.time.LocalDateTime;

import org.springframework.stereotype.Component;

import com.falamaria.api.dto.DenunciaRequest;
import com.falamaria.api.dto.DenunciaResponse;
import com.falamaria.api.entity.Denuncia;
import com.falamaria.api.entity.StatusDenuncia;

@Component
public class DenunciaMapper {

    public Denuncia converterParaEntidade(DenunciaRequest denunciaRequest) {
        if (denunciaRequest == null){
            return null;
        }    

        Denuncia denuncia = new Denuncia();
        denuncia.setNome(denunciaRequest.getNome());
        denuncia.setDescricao(denunciaRequest.getDescricao());
        denuncia.setLocalizacao(denunciaRequest.getLocalizacao());
        denuncia.setContato(denunciaRequest.getContato());
        denuncia.setArquivo(denunciaRequest.getArquivo());
        denuncia.setDataEnvio(LocalDateTime.now());
        denuncia.setStatus(StatusDenuncia.PENDENTE);
        return denuncia;
    }

    public DenunciaResponse converterParaDto(Denuncia denuncia) {
        if (denuncia == null){
            return null;
        }    

        DenunciaResponse response = new DenunciaResponse();
        response.setId(denuncia.getId());
        response.setNome(denuncia.getNome());
        response.setDescricao(denuncia.getDescricao());
        response.setLocalizacao(denuncia.getLocalizacao());
        response.setContato(denuncia.getContato());
        response.setArquivo(denuncia.getArquivo());
        response.setDataEnvio(denuncia.getDataEnvio().toString());
        response.setStatus(denuncia.getStatus().toString());
        return response;
    }

}