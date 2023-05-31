package nl.miwgroningen.ch11.vincent.libraryDemo.repository;

import nl.miwgroningen.ch11.vincent.libraryDemo.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}
