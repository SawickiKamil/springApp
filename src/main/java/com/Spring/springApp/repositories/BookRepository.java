package com.Spring.springApp.repositories;

import com.Spring.springApp.model.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {

}
