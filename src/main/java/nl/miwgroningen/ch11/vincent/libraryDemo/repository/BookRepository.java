package nl.miwgroningen.ch11.vincent.libraryDemo.repository;

import nl.miwgroningen.ch11.vincent.libraryDemo.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Vincent Velthuizen <v.r.velthuizen@pl.hanze.nl>
 * Get books from and write them to the DB
 */
public interface BookRepository extends JpaRepository<Book, Long> {
}
