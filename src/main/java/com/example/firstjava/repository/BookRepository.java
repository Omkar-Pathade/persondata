package com.example.firstjava.repository;

import com.example.firstjava.model.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book,Long> {
}
