package br.inatel.biblioteca.repository;

import br.inatel.biblioteca.model.entity.Livro;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LivroRepository extends MongoRepository<Livro, String> {
}
