package pl.coderslab.security;

import pl.coderslab.user.User;

public interface UserService {
    User findByName(String name);

    void saveUser(User user);
}