package hh.minhhn.bookstore;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import hh.minhhn.bookstore.hh.minhhn.bookstore.domain.Book;
import hh.minhhn.bookstore.hh.minhhn.bookstore.domain.BookRepository;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.boot.CommandLineRunner;


@SpringBootApplication
public class BookstoreApplication {

    public static void main(String[] args) {
        SpringApplication.run(BookstoreApplication.class, args);
    }

    @Bean
    public CommandLineRunner demo(BookRepository repository) {
        return (args) -> {
            repository.save(new Book("Deep Work", "Cal Newport", 2016, "1455586692", 16.90));
            repository.save(new Book("So Good They Can't Ignore You", "Cal Newport", 2012, "1455509124", 14.70));

            for (Book book : repository.findAll()
                    ) {
                System.out.println(book.toString());
            }
        };
    }
}



