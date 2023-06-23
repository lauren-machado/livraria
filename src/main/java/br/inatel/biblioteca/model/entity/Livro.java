package br.inatel.biblioteca.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.List;

@Document
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Livro {

    @Id
    private String id;

    private String titulo;

    private String autor;

    private String editora;

    private String ano;

    private List<String> estiloLiterario;

    @CreatedDate
    private LocalDateTime createdAt;

    @LastModifiedDate
    private LocalDateTime updatedAt;
}
