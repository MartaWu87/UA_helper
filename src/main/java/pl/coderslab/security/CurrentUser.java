package pl.coderslab.security;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

public class CurrentUser extends User {
    private final pl.coderslab.user.User user;

    public CurrentUser(Long id, String name, String password, Collection<? extends GrantedAuthority> authorities, pl.coderslab.user.User user) {
        super(name, password, authorities);
        this.user = user;
    }

    public pl.coderslab.user.User getUser() {
        return user;
    }
}