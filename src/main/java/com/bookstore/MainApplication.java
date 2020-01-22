package com.bookstore;

import com.bookstore.service.BookstoreService;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class MainApplication {

    private final BookstoreService bookstoreService;

    public MainApplication(BookstoreService bookstoreService) {
        this.bookstoreService = bookstoreService;
    }

    public static void main(String[] args) {
        SpringApplication.run(MainApplication.class, args);
    }

    @Bean
    public ApplicationRunner init() {
        return args -> {
            
            bookstoreService.directFetching();
        };
    }
}

/*Direct Fetching Via Spring Data findById(), JPA EntityManager And Hibernate Session

Description: Direct fetching via Spring Data, EntityManager and Hibernate Session examples.

Key points:

direct fetching via Spring Data uses findById()
direct fetching via JPA EntityManager uses find()
direct fetching via Hibernate Session uses get()
 * 
 */
