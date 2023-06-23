package br.inatel.biblioteca.controller;

import br.inatel.biblioteca.model.dto.LivroDTO;
import br.inatel.biblioteca.service.LivroService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequestMapping("/livro")
@RequiredArgsConstructor
public class LivroController {

    private final LivroService livroService;

    @PostMapping
    @ResponseStatus(CREATED)
    public String cadastrarLivro(@RequestBody LivroDTO livroDTO) {
        return livroService.cadastrarLivro(livroDTO);
    }
}
