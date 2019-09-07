package ar.tangogeek.spring5webapp.controllers;

import ar.tangogeek.spring5webapp.repositories.AuthorRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AuthorController {

    AuthorRepository authorRepository;

    public AuthorController(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }


    @RequestMapping ("/authors")
    public String getBooks (Model model) {
        model.addAttribute("authors", authorRepository.findAll());
        return "authors"; //spring mvc will associate this with a view called books
    }

}
