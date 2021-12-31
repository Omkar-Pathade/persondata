package com.example.firstjava.bootstrap;

import com.example.firstjava.model.Author;
import com.example.firstjava.model.Book;
import com.example.firstjava.model.Publisher;
import com.example.firstjava.repository.AuthorRepository;
import com.example.firstjava.repository.BookRepository;
import com.example.firstjava.repository.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;



@Component
public class BootstrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootstrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        Author eric=new Author("Eric","Evans");
        Book book=new Book("Domanin Design","1234");
        Publisher publisher=new Publisher();
        publisher.setName("Omkar");
        publisher.setAddressline1("Hudson");
        publisher.setCity("Ahmednager");
        publisher.setState("Mah");
        publisher.setZip(414003L);
        publisherRepository.save(publisher);

        eric.getBook().add(book);
        book.getAuthors().add(eric);
        book.setPublisher(publisher);
        publisher.getBooks().add(book);

        authorRepository.save(eric);
        bookRepository.save(book);
        //publisherRepository.save(publisher);


        Author rod = new Author("Rod", "Johnson");
        Book book1=new Book("J2EE","123456");
        rod.getBook().add(book1);
        book1.getAuthors().add(rod);
        book1.setPublisher(publisher);
        publisher.getBooks().add(book1);

        authorRepository.save(rod);
        bookRepository.save(book1);
        publisherRepository.save(publisher);

        System.out.println("No of Books: "+bookRepository.count());
        System.out.println("Publishers No of books: "+publisher.getBooks().size());
    }
}
