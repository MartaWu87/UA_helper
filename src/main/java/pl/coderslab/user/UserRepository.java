package pl.coderslab.user;

import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<User, Long> {
    pl.coderslab.user.User findByName(String username);

    pl.coderslab.user.User findByMail(String email);
}

