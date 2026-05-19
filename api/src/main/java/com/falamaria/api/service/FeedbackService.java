package com.falamaria.api.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.falamaria.api.dto.FeedbackRequest;
import com.falamaria.api.dto.FeedbackResponse;
import com.falamaria.api.entity.Feedback;
import com.falamaria.api.mapper.FeedbackMapper;
import com.falamaria.api.repository.FeedbackRepository;

@Service
public class FeedbackService {
 
    private final FeedbackRepository repository;
    private final FeedbackMapper mapper;

    public FeedbackService(FeedbackRepository repository, FeedbackMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Transactional
    public FeedbackResponse criarFeedback(FeedbackRequest request){
        Feedback feedback = mapper.converterParaEntidade(request);
        repository.save(feedback);
        return mapper.converterParaDto(feedback);
    }

    @Transactional(readOnly = true)
    public List<FeedbackResponse> buscarTodosFeedbacks(){
        List<Feedback> feedbacks = repository.findAll();
        return feedbacks.stream()
                .map(mapper::converterParaDto)
                .toList();
    }


}
