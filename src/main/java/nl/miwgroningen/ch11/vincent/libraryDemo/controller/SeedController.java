package nl.miwgroningen.ch11.vincent.libraryDemo.controller;

import lombok.RequiredArgsConstructor;
import nl.miwgroningen.ch11.vincent.libraryDemo.model.Author;
import nl.miwgroningen.ch11.vincent.libraryDemo.model.Book;
import nl.miwgroningen.ch11.vincent.libraryDemo.model.Copy;
import nl.miwgroningen.ch11.vincent.libraryDemo.repository.AuthorRepository;
import nl.miwgroningen.ch11.vincent.libraryDemo.repository.BookRepository;
import nl.miwgroningen.ch11.vincent.libraryDemo.repository.CopyRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Vincent Velthuizen <v.r.velthuizen@pl.hanze.nl>
 * Get some intial data in the database so I don't have to type everything everytime
 */

@Controller
@RequiredArgsConstructor
public class SeedController {
    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final CopyRepository copyRepository;

    @GetMapping("/seed")
    private String seedDatabase() {
        Author patrick = new Author();
        patrick.setFirstName("Patrick");
        patrick.setLastName("Rothfuss");
        authorRepository.save(patrick);

        Set<Author> authors = new HashSet<>();
        authors.add(patrick);

        Book nameOfTheWind = new Book();
        nameOfTheWind.setAuthors(authors);
        nameOfTheWind.setTitle("The Name of the Wind");
        bookRepository.save(nameOfTheWind);

        for (int copyIterator = 0; copyIterator < 3; copyIterator++) {
            Copy copy = new Copy();
            copy.setBook(nameOfTheWind);
            if (copyIterator % 2 != 0) {
                copy.setAvailable(false);
            }
            copyRepository.save(copy);
        }

        return "redirect:/";
    }
}
