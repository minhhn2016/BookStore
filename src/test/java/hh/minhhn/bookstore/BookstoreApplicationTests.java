package hh.minhhn.bookstore;

import static org.assertj.core.api.Assertions.assertThat;

import hh.minhhn.bookstore.hh.minhhn.bookstore.domain.BookRepository;
import hh.minhhn.bookstore.hh.minhhn.bookstore.web.BookController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BookstoreApplicationTests {

	@Autowired
	private BookController controller;

	@Test
	public void contextLoads() throws Exception {
        assertThat(controller).isNotNull();
	}

}
