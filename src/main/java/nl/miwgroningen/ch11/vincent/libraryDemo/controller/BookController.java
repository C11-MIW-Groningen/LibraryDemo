package nl.miwgroningen.ch11.vincent.libraryDemo.controller;

import lombok.RequiredArgsConstructor;
import nl.miwgroningen.ch11.vincent.libraryDemo.model.Book;
import nl.miwgroningen.ch11.vincent.libraryDemo.repository.AuthorRepository;
import nl.miwgroningen.ch11.vincent.libraryDemo.repository.BookRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Optional;

/**
 * @author Vincent Velthuizen <v.r.velthuizen@pl.hanze.nl>
 * Handle all interaction with books
 */

@Controller
@RequiredArgsConstructor
public class BookController {
    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;

    @GetMapping({"/", "/book/all"})
    private String showBookOverview(Model model) {
        model.addAttribute("allBooks", bookRepository.findAll());

        return "bookOverview";
    }

    @GetMapping("/book/new")
    private String showNewBookForm(Model model) {
        model.addAttribute("book", new Book());
        model.addAttribute("allAuthors", authorRepository.findAll());

        return "bookForm";
    }

    @GetMapping("/book/edit/{bookId}")
    private String showEditBookForm(@PathVariable("bookId") Long bookId, Model model) {
        Optional<Book> optionalBook = bookRepository.findById(bookId);

        if (optionalBook.isPresent()) {
            model.addAttribute("book", optionalBook.get());
            model.addAttribute("allAuthors", authorRepository.findAll());
            return "bookForm";
        }

        return "redirect:/book/all";
    }

    @PostMapping("/book/new")
//    @PreAuthorize("hasRole('ADMIN')")
    public String saveOrUpdateBook(@ModelAttribute("book") Book bookToBeSaved, BindingResult result) {

        if (!result.hasErrors()) {
            bookRepository.save(bookToBeSaved);
        }

        return "redirect:/book/all";
    }

    @GetMapping("/book/delete/{bookId}")
    private String deleteBook(@PathVariable("bookId") Long bookId) {
        Optional<Book> optionalBook = bookRepository.findById(bookId);

        optionalBook.ifPresent(bookRepository::delete);

        return "redirect:/book/all";
    }

    @GetMapping("/book/details/{title}")
    private String showBookDetails(@PathVariable("title") String title, Model model) {
        Optional<Book> optionalBook = bookRepository.findByTitle(title);

        if (optionalBook.isPresent()) {
            model.addAttribute("bookToShowDetailsFor", optionalBook.get());

            return "bookDetails";
        }

        return "redirect:/book/all";
    }
}
