package com.falamaria.api.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "denuncia")
@Getter 
@Setter 
public class Denuncia {
    
    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private Long id;
    private String descricao;
    private String localizacao;
    private String contato;
    private String arquivo;
    private LocalDateTime dataEnvio;
    private StatusDenuncia status;
}

