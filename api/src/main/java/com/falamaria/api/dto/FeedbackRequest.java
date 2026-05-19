package com.falamaria.api.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FeedbackRequest {
 
    private String nome;
    private Integer nota;
    private String sugestao;

}
