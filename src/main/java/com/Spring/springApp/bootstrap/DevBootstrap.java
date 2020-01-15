package com.Spring.springApp.bootstrap;

import com.Spring.springApp.model.Author;
import com.Spring.springApp.model.Book;
import com.Spring.springApp.model.Publisher;
import com.Spring.springApp.repositories.AuthorRepository;
import com.Spring.springApp.repositories.BookRepository;
import com.Spring.springApp.repositories.PublisherRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private AuthorRepository authorRepository;
    private BookRepository bookRepository;
    private PublisherRepository publisherRepository;

    public DevBootstrap(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        intiDate();
    }


    private void intiDate() {

        Publisher publisher = new Publisher();
        publisher.setName("Ben Barrel");
        publisher.setAddress("Poland, Wroclaw");
        publisherRepository.save(publisher);

        Author eric = new Author("Eric", "Evans");
        Book newBook = new Book("a title", "234", publisher);
        eric.getBooks().add(newBook);
        newBook.getAuthors().add(eric);

        authorRepository.save(eric);
        bookRepository.save(newBook);

        Author jon = new Author("Jon", "Goldbaum");
        Book oldBook = new Book("Run", "423", publisher);
        jon.getBooks().add(oldBook);

        authorRepository.save(jon);
        bookRepository.save(oldBook);
    }


}
