package br.inatel.biblioteca.controller;

import br.inatel.biblioteca.model.dto.LivroDTO;
import br.inatel.biblioteca.service.LivroService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

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

    @GetMapping("/{id}")
    @ResponseStatus(OK)
    public LivroDTO buscarLivro(@PathVariable String id) {
        return livroService.buscarLivro(id);
    }

    @PutMapping("/{id}")
    @ResponseStatus(OK)
    public LivroDTO atualizarLivro(@PathVariable String id, @RequestBody LivroDTO livroDTO) {
        return livroService.atualizarLivro(id, livroDTO);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(OK)
    public void deletarLivro(@PathVariable String id) {
        livroService.deletarLivro(id);
    }

    @GetMapping("/listar")
    @ResponseStatus(OK)
    public List<LivroDTO> listarLivros() {
        return livroService.listarLivros();
    }
}
