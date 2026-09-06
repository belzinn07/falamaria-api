package com.falamaria.api.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DepoimentoRequest {
    
    private String nome;
    @NotBlank(message = "A mensagem é obrigatória")  
    private String mensagem;

}
