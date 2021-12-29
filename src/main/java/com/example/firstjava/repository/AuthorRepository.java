package com.example.firstjava.repository;

import com.example.firstjava.model.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author,Long> {

}
