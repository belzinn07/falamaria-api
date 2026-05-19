package com.falamaria.api.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FeedbackResponse {
    
    private Long id;
    private String nome;
    private Integer nota;
    private String sugestao;
    private String dataEnvio;

}
