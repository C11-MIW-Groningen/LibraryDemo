package nl.miwgroningen.ch11.vincent.libraryDemo.controllerrest;

import lombok.RequiredArgsConstructor;
import nl.miwgroningen.ch11.vincent.libraryDemo.model.Author;
import nl.miwgroningen.ch11.vincent.libraryDemo.repository.AuthorRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Vincent Velthuizen <v.r.velthuizen@pl.hanze.nl>
 * REST API for everything related to authors
 */

@RestController
@RequestMapping("/api/author")
@RequiredArgsConstructor
public class AuthorRestController {
    private final AuthorRepository authorRepository;

    @GetMapping("/list")
    protected List<Author> getAllAuthors() {
        return authorRepository.findAll();
    }

    @PostMapping("/new")
    protected Author saveAuthor(@RequestBody Author newAuthor) {
        return authorRepository.save(newAuthor);
    }
}
