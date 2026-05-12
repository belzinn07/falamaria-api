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


// por hoje é só, como fazer o commit? Para fazer um commit, você pode seguir os seguintes passos:
// 1. Certifique-se de que todas as alterações que deseja incluir no commit estejam salvas.
// 2. Abra o terminal ou prompt de comando e navegue até o diretório do seu projeto.
// 3. Use o comando `git add .` para adicionar todas as alterações ao staging area. Se você quiser adicionar apenas arquivos específicos, use `git add <nome_do_arquivo>`.
// 4. Depois de adicionar os arquivos, use o comando `git commit -m "sua mensagem de commit"` para criar o commit. A mensagem de commit deve ser uma descrição breve e clara das alterações que foram feitas.'
// vou fazer pelo terminal do vs code.
// para fazer o commit pelo terminal do VS Code, siga os mesmos passos mencionados anteriormente, mas execute os comandos diretamente no terminal integrado do VS Code. Aqui estão os passos detalhados:
// 1. Abra o terminal integrado no VS Code. Você pode fazer isso clicando em "Terminal" no menu superior e selecionando "New Terminal", ou usando o atalho de teclado (Ctrl + `).
// 2. Navegue até o diretório do seu projeto usando o comando `cd <caminho_do_seu_projeto>`. Por exemplo, se o seu projeto estiver na pasta "falamaria-api", você pode usar `cd falamaria-api`.
// 3. Use o comando `git add .` para adicionar todas as alterações ao staging area. Se você quiser adicionar apenas arquivos específicos, use `git add <nome_do_arquivo>`.
// 4. Depois de adicionar os arquivos, use o comando `git commit -m "