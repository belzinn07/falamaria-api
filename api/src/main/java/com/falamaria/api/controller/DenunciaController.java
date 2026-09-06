package com.falamaria.api.controller;

import java.util.List;

import com.falamaria.api.dto.DenunciaRequest;
import com.falamaria.api.dto.DenunciaResponse;
import com.falamaria.api.entity.StatusDenuncia;
import com.falamaria.api.service.DenunciaService;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/denuncias")
public class DenunciaController {

    private final DenunciaService service;

    public DenunciaController(DenunciaService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<DenunciaResponse> criar(@Valid @RequestBody DenunciaRequest request) {
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

    @GetMapping("/admin/status/{status}")
    public ResponseEntity<List<DenunciaResponse>> listarDenunciasPorStatus(@PathVariable StatusDenuncia status) {
        return ResponseEntity.ok(service.buscarDenunciasPorStatus(status));
    }

    @PatchMapping("/admin/{id}/status")
    public ResponseEntity<DenunciaResponse> atualizarStatus(@PathVariable Long id, @RequestParam StatusDenuncia status) {
        return ResponseEntity.ok(service.atualizarStatusDenuncia(id, status));
    }

}