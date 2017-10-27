package hh.minhhn.bookstore.hh.minhhn.bookstore.domain;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepository extends CrudRepository<User, Long> {
    //List<User> findByUsernameObject(String username);
    User findByUsername(String username);
}
