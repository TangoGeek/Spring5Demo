package ar.tangogeek.spring5webapp.repositories;

import ar.tangogeek.spring5webapp.model.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author, Long> {
}
