package com.example.firstjava.bootstrap;

import com.example.firstjava.model.Author;
import com.example.firstjava.model.Book;
import com.example.firstjava.repository.AuthorRepository;
import com.example.firstjava.repository.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootstrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;

    public BootstrapData(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        Author eric=new Author("Eric","Evans");
        Book book=new Book("Domanin Design","1234");
        eric.getBooks().add(book);
        book.getAuthors().add(eric);

        authorRepository.save(eric);
        bookRepository.save(book);


        Author rod = new Author("Rod", "Johnson");
        Book book1=new Book("J2EE","123456");
        rod.getBooks().add(book1);
        book1.getAuthors().add(rod);

        authorRepository.save(rod);
        bookRepository.save(book1);

        System.out.println("No of Books: "+bookRepository.count());
    }
}
