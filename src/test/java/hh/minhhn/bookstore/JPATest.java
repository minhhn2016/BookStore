package hh.minhhn.bookstore;

import static org.assertj.core.api.Assertions.assertThat;

import hh.minhhn.bookstore.hh.minhhn.bookstore.domain.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@DataJpaTest
public class JPATest {
    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    /*@Autowired
    private UserRepository userTestRepository;*/

    @Test
    public void findByBookTitleShouldReturnBook() {
        List<Book> books = bookRepository.findByTitle("Deep Work");
        assertThat(books).hasSize(1);
        assertThat(books.get(0).getTitle()).isEqualTo("Deep Work");
    }

    @Test
    public void createNewBook() {
        Book book = new Book("abc","def",2000,"123456789",0.00, categoryRepository.findByCategoryName("Fiction").get(0));
        bookRepository.save(book);
        assertThat(book.getId()).isNotNull();
    }

    @Test
    public void deleteBook() {
        List<Book> books = bookRepository.findByTitle("Deep Work");
        bookRepository.delete(books.get(0));
        assertThat(bookRepository.findByTitle("Deep Work")).hasSize(0);
    }


    @Test
    public void findByCategoryNameShouldReturnCategory() {
        List<Category> categories = categoryRepository.findByCategoryName("Productivity");
        assertThat(categories).hasSize(1);
        assertThat(categories.get(0).getCategoryName()).isEqualTo("Productivity");
    }



    @Test
    public void createNewCategory() {
        Category category = new Category("test");
        categoryRepository.save(category);
        assertThat(category.getCategoryId()).isNotNull();
    }

    @Test
    public void deleteCategory() {
        List<Category> categories = categoryRepository.findByCategoryName("Business");
        categoryRepository.delete(categories.get(0));
        assertThat(categoryRepository.findByCategoryName("Business")).hasSize(0);
    }

    /*@Test
    public void findByUserNameShouldReturnUser() {
        List<User> users = userTestRepository.findByUsernameObject("user");
        assertThat(users).hasSize(1);
        assertThat(users.get(0).getUsername()).isEqualTo("user");
    }

    @Test
    public void createNewUser() {
        User user = new User("test", "$2a$08$y3t/pWlcUTUlBryhpHJ4JefxibrxgMudKYeKYl5eWL/bct70DKZeG", "USER");
        userTestRepository.save(user);
        assertThat(user.getUsername()).isNotNull();
    }*/
}
