package com.falamaria.api.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;

import com.falamaria.api.dto.DenunciaRequestDTO;
import com.falamaria.api.dto.DenunciaResponseDTO;
import com.falamaria.api.entity.StatusDenuncia;
import com.falamaria.api.service.DenunciaService;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/denuncias")
public class DenunciaController {
    
    private final DenunciaService service;

    public DenunciaController(DenunciaService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<DenunciaResponseDTO> criar(@RequestBody DenunciaRequestDTO request) {
        return ResponseEntity.ok(service.criarDenuncia(request));
    }

    @GetMapping
    public ResponseEntity<List<DenunciaResponseDTO>> buscarTodas() {
        return ResponseEntity.ok(service.buscarTodasDenuncias());
    }

    @GetMapping("/{id}")
    public ResponseEntity<DenunciaResponseDTO> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(service.buscarDenunciaPorId(id));
    }

    @PatchMapping("/{id}/status")
    public ResponseEntity<DenunciaResponseDTO> atualizarStatus(@PathVariable Long id, @RequestParam StatusDenuncia status) {
        return ResponseEntity.ok(service.atualizarStatusDenuncia(id, status));
    }
    
}
