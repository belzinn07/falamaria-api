package com.falamaria.api.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.falamaria.api.dto.FeedbackRequest;
import com.falamaria.api.dto.FeedbackResponse;
import com.falamaria.api.service.FeedbackService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/feedbacks")
public class FeedbackController {
    private final FeedbackService service;

    public FeedbackController(FeedbackService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<FeedbackResponse> criar(@Valid @RequestBody FeedbackRequest request){
        return ResponseEntity.ok(service.criarFeedback(request));
    }

    @GetMapping("/admin")
    public ResponseEntity<List<FeedbackResponse>> buscarTodos(){
       return ResponseEntity.ok(service.buscarTodosFeedbacks());
    }

}
