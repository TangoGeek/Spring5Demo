package ar.tangogeek.spring5webapp.controllers;

import ar.tangogeek.spring5webapp.repositories.BookRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BookController {

    BookRepository bookRepository;

    public BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }


    @RequestMapping ("/books")
    public String getBooks (Model model) {
        model.addAttribute("books", bookRepository.findAll());
        return "books"; //spring mvc will associate this with a view called books
    }

}
