package com.example.firstjava.controller;

import com.example.firstjava.repository.AuthorRepository;
import com.example.firstjava.repository.BookRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BookController {

    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;

    public BookController(BookRepository bookRepository, AuthorRepository authorRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
    }

    @RequestMapping("/books")
    private String getBooks(Model model){

        System.out.println(bookRepository.findAll());
        model.addAttribute("books", bookRepository.findAll());
        return "books/list";
    }
    @RequestMapping("/authors")
    private String getAuthors(Model model){

        //System.out.println(authorRepository.findAll().toString());
        model.addAttribute("authors", authorRepository.findAll());
        return "authors/alist";
    }
}
