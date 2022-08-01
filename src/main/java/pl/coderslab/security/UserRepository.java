package pl.coderslab.security;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface UserRepository extends JpaRepository<User, Long> {
    pl.coderslab.security.User findByName(String username);
    pl.coderslab.security.User findByMail (String email);


    }

