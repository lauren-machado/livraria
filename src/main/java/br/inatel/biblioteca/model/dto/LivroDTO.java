package br.inatel.biblioteca.model.dto;

import lombok.Data;

import java.util.List;

@Data
public class LivroDTO {

    private String id;

    private String titulo;

    private String autor;

    private String editora;

    private String sinopse;

    private Integer ano;

    private List<String> estiloLiterario;
}
