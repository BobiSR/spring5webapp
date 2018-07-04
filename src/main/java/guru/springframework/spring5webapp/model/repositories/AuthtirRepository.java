package guru.springframework.spring5webapp.model.repositories;

import guru.springframework.spring5webapp.model.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthtirRepository  extends CrudRepository<Author, Long> {
}
