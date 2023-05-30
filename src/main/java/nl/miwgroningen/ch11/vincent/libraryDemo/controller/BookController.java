package nl.miwgroningen.ch11.vincent.libraryDemo.controller;

import lombok.RequiredArgsConstructor;
import nl.miwgroningen.ch11.vincent.libraryDemo.model.Book;
import nl.miwgroningen.ch11.vincent.libraryDemo.repository.BookRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * @author Vincent Velthuizen <v.r.velthuizen@pl.hanze.nl>
 * Handle all interaction with books
 */

@Controller
@RequiredArgsConstructor
public class BookController {
    private final BookRepository bookRepository;

    @GetMapping({"/", "/book/all"})
    private String showBookOverview(Model model) {
        model.addAttribute("allBooks", bookRepository.findAll());

        return "bookOverview";
    }

    @GetMapping("/book/new")
    private String showBookForm(Model model) {
        model.addAttribute("book", new Book());

        return "bookForm";
    }

    @PostMapping("/book/new")
    private String saveOrUpdateBook(@ModelAttribute("book") Book bookToBeSaved, BindingResult result) {
        if (!result.hasErrors()) {
            bookRepository.save(bookToBeSaved);
        }

        return "redirect:/book/all";
    }
}
