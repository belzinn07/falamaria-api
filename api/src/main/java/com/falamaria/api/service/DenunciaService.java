package com.falamaria.api.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import com.falamaria.api.dto.DenunciaRequestDTO;
import com.falamaria.api.dto.DenunciaResponseDTO;
import com.falamaria.api.entity.Denuncia;
import com.falamaria.api.entity.StatusDenuncia;
import com.falamaria.api.exception.DenunciaNaoEncontradaException;
import com.falamaria.api.repository.DenunciaRepository;

@Service
public class DenunciaService {
  private DenunciaRepository denunciaRepository;
  //Aqui fazemos a injeção de dependência do `DenunciaRepository` através do construtor da classe `DenunciaService`. Isso permite que o Spring gerencie a criação e a injeção do repositório, facilitando o acesso aos dados das denúncias. Além disso, atingimos o principio da inversão de dependência pois a classe `DenunciaService` depende de uma abstração (`DenunciaRepository`) em vez de uma implementação concreta, o que torna o código mais flexível e testável.
  public DenunciaService(DenunciaRepository denunciaRepository){
    this.denunciaRepository = denunciaRepository;
  }
  
  //pensando arquiteturalmente, em vez de expor diretamente a entidade `Denuncia` para as camadas superiores, como controladores ou clientes, utilizamos os DTOs (`DenunciaRequestDTO` e `DenunciaResponseDTO`) para encapsular os dados de entrada e saída. Isso promove uma separação clara entre a camada de serviço e a camada de apresentação, permitindo que a estrutura interna da entidade `Denuncia` possa ser modificada sem afetar as interfaces externas. Além disso, os DTOs podem ser personalizados para atender às necessidades específicas de cada operação, como criar uma denúncia ou buscar denúncias, sem expor detalhes desnecessários da entidade.
    private Denuncia converterParaDenuncia(DenunciaRequestDTO denunciaRequestDTO){
    Denuncia denuncia = new Denuncia();
    denuncia.setNome(denunciaRequestDTO.getNome());
    denuncia.setDescricao(denunciaRequestDTO.getDescricao());
    denuncia.setLocalizacao(denunciaRequestDTO.getLocalizacao());
    denuncia.setContato(denunciaRequestDTO.getContato());
    denuncia.setArquivo(denunciaRequestDTO.getArquivo());
    denuncia.setDataEnvio(LocalDateTime.now());
    denuncia.setStatus(StatusDenuncia.PENDENTE);
    return denuncia;
  }  

  private DenunciaResponseDTO converterParaDto(Denuncia denuncia){
    DenunciaResponseDTO responseDTO = new DenunciaResponseDTO();
    responseDTO.setId(denuncia.getId());
    responseDTO.setNome(denuncia.getNome());
    responseDTO.setDescricao(denuncia.getDescricao());
    responseDTO.setLocalizacao(denuncia.getLocalizacao());
    responseDTO.setContato(denuncia.getContato());
    responseDTO.setArquivo(denuncia.getArquivo());
    responseDTO.setDataEnvio(denuncia.getDataEnvio().toString());
    responseDTO.setStatus(denuncia.getStatus().toString());
    return responseDTO;
  }
  
  public DenunciaResponseDTO criarDenuncia(DenunciaRequestDTO denunciaRequestDTO){
   
   Denuncia denuncia = converterParaDenuncia(denunciaRequestDTO);
   denunciaRepository.save(denuncia);
   return converterParaDto(denuncia);

   //O método `criarDenuncia` recebe um objeto `DenunciaRequestDTO`, converte-o para uma entidade `Denuncia`, salva a entidade no repositório e, em seguida, converte a entidade salva de volta para um `DenunciaResponseDTO` para retornar como resposta.

 }

 public List<DenunciaResponseDTO> buscarTodasDenuncias(){

    List<Denuncia> denuncias = denunciaRepository.findAll(); 
    if (denuncias.isEmpty()) {
        throw new DenunciaNaoEncontradaException("Nenhuma denúncia encontrada.");
    }

    return denuncias.stream()
    .map(this::converterParaDto)
    .toList(); 
    //O método `buscarTodasDenuncias` busca todas as denúncias no repositório usando o método `buscarTodasDenuncias`, verifica se a lista de denúncias está vazia e, se estiver, lança uma exceção `DenunciaNaoEncontradaException`. Caso contrário, ele converte cada entidade `Denuncia` para um `DenunciaResponseDTO` usando o método `converterParaDto` e retorna a lista de DTOs.
   
    
  }

 public DenunciaResponseDTO buscarDenunciaPorId(Long id){
    Denuncia denuncia = denunciaRepository.findById(id).orElse(null);
    verificarSeExisteDenuncia(id, denuncia);
    return converterParaDto(denuncia);
 //O método `buscarDenunciaPorId` recebe um ID, busca a denúncia correspondente no repositório usando o método `buscarPorId`, e então converte a entidade `Denuncia` encontrada para um `DenunciaResponseDTO` antes de retorná-la. 
}

 private void verificarSeExisteDenuncia(Long id, Denuncia denuncia) {
    if (denuncia == null) {
        throw new DenunciaNaoEncontradaException("Denúncia com ID " + id + " não encontrada.");
    }
 }

public DenunciaResponseDTO atualizarStatusDenuncia(Long id, StatusDenuncia status){
    Denuncia denuncia = denunciaRepository.findById(id).orElseThrow(() -> new DenunciaNaoEncontradaException("Denúncia com ID " + id + " não encontrada."));
    denuncia.setStatus(status);
    denunciaRepository.save(denuncia);
    return converterParaDto(denuncia);
    //O método `atualizarStatusDenuncia` recebe um ID e um novo status, busca a denúncia correspondente no repositório, atualiza o status da denúncia, salva a entidade atualizada de volta no repositório e retorna a denúncia atualizada como um `DenunciaResponseDTO`.
    }

}
