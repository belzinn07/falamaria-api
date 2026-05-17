package com.falamaria.api.mapper;

import java.time.LocalDateTime;

import org.springframework.stereotype.Component;

import com.falamaria.api.dto.DenunciaRequestDTO;
import com.falamaria.api.dto.DenunciaResponseDTO;
import com.falamaria.api.entity.Denuncia;
import com.falamaria.api.entity.StatusDenuncia;

@Component
public class DenunciaMapper {

    public Denuncia converterParaDenuncia(DenunciaRequestDTO denunciaRequestDTO) {
        if (denunciaRequestDTO == null){
            return null;
        }    

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

    public DenunciaResponseDTO converterParaDto(Denuncia denuncia) {
        if (denuncia == null){
            return null;
        }    

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

}