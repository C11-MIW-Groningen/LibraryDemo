package nl.miwgroningen.ch11.vincent.libraryDemo.repository;

import nl.miwgroningen.ch11.vincent.libraryDemo.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, Long> {
}
