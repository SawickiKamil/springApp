package com.Spring.springApp.repositories;

import com.Spring.springApp.model.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author, Long> {
}
