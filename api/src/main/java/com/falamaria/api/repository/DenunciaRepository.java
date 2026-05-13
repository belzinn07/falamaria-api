package com.falamaria.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.falamaria.api.entity.Denuncia;
import com.falamaria.api.entity.StatusDenuncia;

public interface DenunciaRepository  extends JpaRepository<Denuncia, Long> {
   
    public List<Denuncia> buscarTodasDenuncias();
    public Denuncia buscarPorId(long id);
    public List<Denuncia> buscarPorStatus(StatusDenuncia status);
    
}
//como fazer um commit apenas do dto?Para fazer um commit apenas do DTO (Data Transfer Object), você pode seguir os seguintes passos:
//1. Certifique-se de que o DTO esteja em um arquivo separado, por exemplo, `DenunciaRequestDTO.java`.
//2. Adicione o arquivo do DTO ao seu sistema de controle de versão (como Git) usando o comando `git add src/main/java/com/falamaria/api/dto/DenunciaRequestDTO.java`.