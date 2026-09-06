package com.falamaria.api.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.falamaria.api.dto.DepoimentoRequest;
import com.falamaria.api.dto.DepoimentoResponse;
import com.falamaria.api.service.DepoimentoService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/depoimentos")
public class DepoimentoController {

    private final DepoimentoService service;

    public DepoimentoController(DepoimentoService service){
        this.service = service;
    } 

    @PostMapping
    public ResponseEntity<DepoimentoResponse> criar(@Valid @RequestBody DepoimentoRequest request){
        return ResponseEntity.ok(service.criarDepoimento(request));
    }

    @GetMapping
    public ResponseEntity<List<DepoimentoResponse>> buscarTodos(){
        return ResponseEntity.ok(service.buscarTodosDepoimentos());
    }


}
