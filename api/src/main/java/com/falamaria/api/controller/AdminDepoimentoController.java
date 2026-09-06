package com.falamaria.api.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.falamaria.api.dto.DepoimentoResponse;
import com.falamaria.api.service.DepoimentoService;

@RestController
@RequestMapping("/admin/depoimentos")   
public class AdminDepoimentoController {
    private final DepoimentoService service;

    public AdminDepoimentoController(DepoimentoService service){
        this.service = service;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<DepoimentoResponse> excluir(@PathVariable Long id){
        return ResponseEntity.ok(service.excluirDepoimento(id));
    }    
    
}
