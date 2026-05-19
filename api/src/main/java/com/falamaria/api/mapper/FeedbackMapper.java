package com.falamaria.api.mapper;

import java.time.LocalDateTime;

import org.springframework.stereotype.Component;

import com.falamaria.api.dto.FeedbackRequest;
import com.falamaria.api.dto.FeedbackResponse;
import com.falamaria.api.entity.Feedback;

@Component
public class FeedbackMapper {

    public Feedback converterParaEntidade(FeedbackRequest request) {
        if (request == null) {
            return null;
        }

        Feedback feedback = new Feedback();
        feedback.setNome(request.getNome());
        feedback.setNota(request.getNota());
        feedback.setSugestao(request.getSugestao());
        feedback.setDataEnvio(LocalDateTime.now());
        return feedback;

    }

    public FeedbackResponse converterParaDto(Feedback feedback) {
        if (feedback == null) {
            return null;
        }

        FeedbackResponse response = new FeedbackResponse();
        response.setId(feedback.getId());
        response.setNome(feedback.getNome());
        response.setNota(feedback.getNota());
        response.setSugestao(feedback.getSugestao());
        response.setDataEnvio(feedback.getDataEnvio().toString());
        return response;

    }
}
