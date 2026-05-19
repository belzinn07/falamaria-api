package com.falamaria.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.falamaria.api.entity.Feedback;

public interface FeedbackRepository extends JpaRepository<Feedback, Long>{
    
}