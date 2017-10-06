package hh.minhhn.bookstore;

import hh.minhhn.bookstore.hh.minhhn.bookstore.domain.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.boot.CommandLineRunner;

import javax.transaction.Transactional;


@SpringBootApplication
public class BookstoreApplication {

    public static void main(String[] args) {
        SpringApplication.run(BookstoreApplication.class, args);
    }

    @Bean
    public CommandLineRunner demo(BookRepository bookRepository, CategoryRepository categoryRepository, UserRepository userRepository) {
        return (args) -> {
            categoryRepository.save(new Category("Productivity"));
            categoryRepository.save(new Category("Non-fiction"));
            categoryRepository.save(new Category("Fiction"));
            categoryRepository.save(new Category("Sci-Fi"));
            categoryRepository.save(new Category("Business"));

            bookRepository.save(new Book("Deep Work", "Cal Newport", 2016, "1455586692",16.90, categoryRepository.findByCategoryName("Productivity").get(0) ));
            bookRepository.save(new Book("So Good They Can't Ignore You", "Cal Newport", 2012, "1455509124", 14.70, categoryRepository.findByCategoryName("Productivity").get(0)));

            // Create users: admin/admin user/user
            User user1 = new User("user", "$2a$06$a7d0miTi9k78uo8X.ICNHu9QccoHskT7C6Cq3GC2wdIeuXI1k2/nq", "USER");
            User user2 = new User("admin", "$2a$06$a2lt7LDVO0VaMM/vAG0/K.9TLmflf75v5smJDDxyZ8NilGjedQftq", "ADMIN");
            userRepository.save(user1);
            userRepository.save(user2);

            for (Book book : bookRepository.findAll()
                    ) {
                System.out.println(book.toString());
            }

            for (Category category : categoryRepository.findAll()
                    ) {
                System.out.println(category.toString());
            }

            for (User user : userRepository.findAll()
                    ) {
                System.out.println(user.toString());
            }
        };
    }


}



