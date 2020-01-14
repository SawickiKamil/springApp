package com.Spring.springApp.bootstrap;

import com.Spring.springApp.model.Author;
import com.Spring.springApp.model.Book;
import com.Spring.springApp.repositories.AuthorRepository;
import com.Spring.springApp.repositories.BookRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private AuthorRepository authorRepository;
    private BookRepository bookRepository;

    public DevBootstrap(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        intiDate();
    }


    private void intiDate() {
        Author eric = new Author("Eric", "Evans");
        Book newBook = new Book("a title", "234", "Herbert Janusz");
        eric.getBooks().add(newBook);
        newBook.getAuthors().add(eric);

        authorRepository.save(eric);
        bookRepository.save(newBook);

        Author jon = new Author("Jon", "Goldbaum");
        Book oldBook = new Book("Run", "423", "Jeremy Gala");
        jon.getBooks().add(oldBook);

        authorRepository.save(jon);
        bookRepository.save(oldBook);
    }


}
