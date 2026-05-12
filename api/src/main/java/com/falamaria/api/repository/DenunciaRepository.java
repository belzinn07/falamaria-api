package com.falamaria.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.falamaria.api.Denuncia;
import com.falamaria.api.entity.StatusDenuncia;

public interface DenunciaRepository  extends JpaRepository<Denuncia, Long> {
   
    public List<Denuncia> buscarTodasDenuncias();
    public Denuncia buscarPorId(long id);
    public List<Denuncia> buscarPorStatus(StatusDenuncia status);
    
}
