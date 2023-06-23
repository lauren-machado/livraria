package br.inatel.biblioteca.service;

import br.inatel.biblioteca.model.dto.LivroDTO;

import java.util.List;

public interface LivroService {

    String cadastrarLivro(LivroDTO livroDTO);

    LivroDTO buscarLivro(String id);

    LivroDTO atualizarLivro(String id, LivroDTO livroDTO);

    void deletarLivro(String id);

    List<LivroDTO> listarLivros();
}
