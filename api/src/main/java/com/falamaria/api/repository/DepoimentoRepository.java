package com.falamaria.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.falamaria.api.entity.Depoimento;
@Repository
public interface DepoimentoRepository extends JpaRepository<Depoimento, Long> {

}
