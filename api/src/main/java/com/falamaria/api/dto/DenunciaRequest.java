package com.falamaria.api.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DenunciaRequest{
    private String nome;
    @NotBlank(message = "A descrição é obrigatória")
    private String descricao;
    @NotBlank(message = "A localização é obrigatória")
    private String localizacao;
    private String contato;
    private String arquivo;

}