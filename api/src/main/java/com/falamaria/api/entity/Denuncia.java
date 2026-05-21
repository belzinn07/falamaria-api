package com.falamaria.api.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "denuncias")
@Getter 
@Setter 
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Denuncia {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, length = 255)
    private String nome;
    @Column(nullable = false)
    private String descricao;
    @Column(nullable = false, length = 255)
    private String localizacao;
    @Column(nullable = false, length = 255)
    private String contato;
    @Column(nullable = false, length = 255)
    private String arquivo;
    private LocalDateTime dataEnvio;
    @Enumerated(EnumType.STRING)
    private StatusDenuncia status;
}
