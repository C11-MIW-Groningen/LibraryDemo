package nl.miwgroningen.ch11.vincent.libraryDemo.controller;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import nl.miwgroningen.ch11.vincent.libraryDemo.model.Book;
import nl.miwgroningen.ch11.vincent.libraryDemo.model.Copy;
import nl.miwgroningen.ch11.vincent.libraryDemo.repository.BookRepository;
import nl.miwgroningen.ch11.vincent.libraryDemo.repository.CopyRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

/**
 * @author Vincent Velthuizen <v.r.velthuizen@pl.hanze.nl>
 * Handle everything to do with physical copies of books
 */

@Controller
@RequestMapping("/copy")
@RequiredArgsConstructor
public class CopyController {
    private final BookRepository bookRepository;
    private final CopyRepository copyRepository;

    @GetMapping("/new/{bookId}")
    private String createNewCopy(@PathVariable("bookId") Long bookId) {
        Optional<Book> optionalBook = bookRepository.findById(bookId);

        if (optionalBook.isPresent()) {
            Copy copy = new Copy();
            copy.setBook(optionalBook.get());
            copyRepository.save(copy);
        }

        return "redirect:/book/all";
    }
}
