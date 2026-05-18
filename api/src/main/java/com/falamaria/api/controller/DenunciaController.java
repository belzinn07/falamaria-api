package com.falamaria.api.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;

import com.falamaria.api.dto.DenunciaRequest;
import com.falamaria.api.dto.DenunciaResponse;
import com.falamaria.api.entity.StatusDenuncia;
import com.falamaria.api.service.DenunciaService;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;



@RestController
@RequestMapping("/denuncias")
public class DenunciaController {
    
    private final DenunciaService service;

    public DenunciaController(DenunciaService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<DenunciaResponse> criar(@RequestBody DenunciaRequest request) {
        return ResponseEntity.ok(service.criarDenuncia(request));
    }

    @GetMapping("/admin")
    public ResponseEntity<List<DenunciaResponse>> buscarTodas() {
        return ResponseEntity.ok(service.buscarTodasDenuncias());
    }

    @GetMapping("/admin/{id}")
    public ResponseEntity<DenunciaResponse> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(service.buscarDenunciaPorId(id));
    }

    @GetMapping("/admnin/{status}")
    public ResponseEntity<List<DenunciaResponse>> listarDenunciasPorStatus(@PathVariable StatusDenuncia status) {
        return ResponseEntity.ok(service.buscarDenunciasPorStatus(status));
    }
    
    @PatchMapping("/admin/{id}/status")
    public ResponseEntity<DenunciaResponse> atualizarStatus(@PathVariable Long id, @RequestParam StatusDenuncia status) {
        return ResponseEntity.ok(service.atualizarStatusDenuncia(id, status));
    }
    
}
