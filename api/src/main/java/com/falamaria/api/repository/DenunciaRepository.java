package com.falamaria.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.falamaria.api.entity.Denuncia;
import com.falamaria.api.entity.StatusDenuncia;

public interface DenunciaRepository  extends JpaRepository<Denuncia, Long> {

    List<Denuncia> findByStatus(StatusDenuncia status);

}
