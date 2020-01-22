package com.bookstore.service;

import com.bookstore.dao.Dao;
import com.bookstore.entity.Author;
import com.bookstore.repository.AuthorRepository;
import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
public class BookstoreService {

    private final AuthorRepository authorRepository;
    private final Dao dao;

    public BookstoreService(AuthorRepository authorRepository, Dao dao) {
        this.authorRepository = authorRepository;
        this.dao = dao;
    }

    public void directFetching() {
        // direct fetching via Spring Data **direct fetching via Spring Data uses findById()
        Optional<Author> resultSD = authorRepository.findById(1L);
        System.out.println("Direct fetching via Spring Data result: " + resultSD.get());

        // direct fetching via EntityManager **direct fetching via JPA EntityManager uses find()
        Optional<Author> resultEM = dao.find(Author.class, 1L);
        System.out.println("Direct fetching via EntityManager result: " + resultEM.get());

        // direct fetching via Session  ** direct fetching via Hibernate Session uses get()
        Optional<Author> resultHS = dao.findViaSession(Author.class, 1L);
        System.out.println("Direct fetching via Session result: " + resultHS.get());
    }
}
