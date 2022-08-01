package pl.coderslab;

import pl.coderslab.security.User;

public interface UserService {
    User findByName(String name);
    void saveUser(User user);
}