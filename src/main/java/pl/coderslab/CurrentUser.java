package pl.coderslab;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

public class CurrentUser extends User{
    private final pl.coderslab.security.User user;

    public CurrentUser(Long id, String name, String password, Collection<? extends GrantedAuthority> authorities, pl.coderslab.security.User user) {
        super(name, password, authorities);
        this.user = user;
    }


    public pl.coderslab.security.User getUser(){
        return user;
    }
}