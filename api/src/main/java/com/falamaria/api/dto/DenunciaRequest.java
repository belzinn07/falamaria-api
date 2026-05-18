package com.falamaria.api.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DenunciaRequest{
    private String nome;
    private String descricao;
    private String localizacao;
    private String contato;
    private String arquivo;

}