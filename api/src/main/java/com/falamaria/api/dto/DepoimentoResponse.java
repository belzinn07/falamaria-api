package com.falamaria.api.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DepoimentoResponse {
    
    private Long id;
    private String nome;
    private String mensagem;
    private String dataEnvio;    

}
