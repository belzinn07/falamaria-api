package com.falamaria.api.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "denuncias")
@Getter 
@Setter 
public class Denuncia {
    
    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private Long id;
    private String nome;
    @NotBlank(message = "A descrição é obrigatória")
    private String descricao;
    @NotBlank(message = "A localização é obrigatória")
    private String localizacao; 
    private String contato;
    private String arquivo;
    private LocalDateTime dataEnvio;
    @Enumerated(EnumType.STRING)
    private StatusDenuncia status;
}
