package com.falamaria.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.falamaria.api.entity.Denuncia;
import com.falamaria.api.entity.StatusDenuncia;
@Repository
public interface DenunciaRepository  extends JpaRepository<Denuncia, Long> {

    List<Denuncia> findByStatus(StatusDenuncia status);

}
