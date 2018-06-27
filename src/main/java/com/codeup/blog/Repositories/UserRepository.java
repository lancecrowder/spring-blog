package com.codeup.blog.Repositories;

import com.codeup.blog.models.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
    User findByUsername(String username);

    User findById(long id);

    @Query(nativeQuery = true, value = "SELECT * FROM users LIMIT 1")
    User first();
}
