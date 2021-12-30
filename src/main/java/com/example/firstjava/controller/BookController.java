package com.example.firstjava.controller;

import com.example.firstjava.repository.BookRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BookController {

    private BookRepository bookRepository;

    public BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @GetMapping("/books")
    private String books(Model model){

        model.addAttribute("Books", bookRepository.findAll());
        return "Books";
    }
}
