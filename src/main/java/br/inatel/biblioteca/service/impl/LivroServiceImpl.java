package br.inatel.biblioteca.service.impl;

import br.inatel.biblioteca.exception.CampoRequeridoException;
import br.inatel.biblioteca.model.dto.LivroDTO;
import br.inatel.biblioteca.model.entity.Livro;
import br.inatel.biblioteca.repository.LivroRepository;
import br.inatel.biblioteca.service.LivroService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

import static org.springframework.http.HttpStatus.NOT_FOUND;

@Service
@RequiredArgsConstructor
public class LivroServiceImpl implements LivroService {

    private final LivroRepository livroRepository;

    @Override
    @Transactional
    public String cadastrarLivro(LivroDTO livroDTO) {
        validInfo(livroDTO);
        ModelMapper modelMapper = new ModelMapper();
        Livro livro = modelMapper.map(livroDTO, Livro.class);
        livroRepository.save(livro);

        return livro.getId();
    }

    @Override
    public LivroDTO buscarLivro(String id) {
        Livro livro = livroRepository.findById(id).orElseThrow(() -> new ResponseStatusException(NOT_FOUND, "Livro não encontrado"));
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(livro, LivroDTO.class);
    }

    @Override
    @Transactional
    public LivroDTO atualizarLivro(String id, LivroDTO livroDTO) {
        validInfo(livroDTO);
        Livro livro = livroRepository.findById(id).orElseThrow(() -> new ResponseStatusException(NOT_FOUND, "Livro não encontrado"));
        ModelMapper modelMapper = new ModelMapper();
        Livro livroAtualizado = modelMapper.map(livroDTO, Livro.class);
        livroAtualizado.setId(livro.getId());
        livroRepository.save(livroAtualizado);

        return modelMapper.map(livroAtualizado, LivroDTO.class);
    }

    @Override
    @Transactional
    public void deletarLivro(String id) {
        Livro livro = livroRepository.findById(id).orElseThrow(() -> new ResponseStatusException(NOT_FOUND, "Livro não encontrado"));
        livroRepository.delete(livro);
    }

    @Override
    public List<LivroDTO> listarLivros() {
        List<Livro> livro = livroRepository.findAll();

        return livro.stream().map(livro1 -> new ModelMapper().map(livro1, LivroDTO.class)).toList();
    }

    private void validInfo(LivroDTO livroDTO) {
        if (livroDTO.getTitulo() == null || livroDTO.getTitulo().isEmpty()) {
            throw new CampoRequeridoException("Titulo não pode ser nulo ou vazio");
        }
        if (livroDTO.getAutor() == null || livroDTO.getAutor().isEmpty()) {
            throw new CampoRequeridoException("Autor não pode ser nulo ou vazio");
        }
        if (livroDTO.getEditora() == null || livroDTO.getEditora().isEmpty()) {
            throw new CampoRequeridoException("Editora não pode ser nulo ou vazio");
        }
        if (livroDTO.getAno() == null) {
            throw new CampoRequeridoException("Ano não pode ser nulo ou vazio");
        }
        if (livroDTO.getEstiloLiterario() == null || livroDTO.getEstiloLiterario().isEmpty()) {
            throw new CampoRequeridoException("Estilo Literario não pode ser nulo ou vazio");
        }
    }
}
