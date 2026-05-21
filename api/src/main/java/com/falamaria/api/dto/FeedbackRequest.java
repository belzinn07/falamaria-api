package com.falamaria.api.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FeedbackRequest {
 
    private String nome;
    @NotNull(message = "Nota é obrigatória") 
    @Min(value = 0, message = "Nota deve ser maior ou igual a 0")
    @Max(value = 10, message = "Nota deve ser menor ou igual a 10")
    private Integer nota;
    @NotBlank(message = "Sugestão é obrigatória") 
    private String sugestao;

}
