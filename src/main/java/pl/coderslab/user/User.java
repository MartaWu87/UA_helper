package pl.coderslab.user;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pl.coderslab.security.Role;
import pl.coderslab.category.Category;
import pl.coderslab.needs.Needs;
import pl.coderslab.region.Region;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, unique = true, length = 60)
    private String name;
    @Column(nullable = false)
    private String adres;
    @Email
    @Column(nullable = false, unique = true)
    private String mail;
    @Column(nullable = false)
    private String password;

    private String phone;

    private String accountNumber;
    private String description;
    @ManyToOne
    private Region region;
    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "users_categories", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "category_id"))
    private Set<Category> categories = new HashSet<Category>();
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private Set<Needs> needs;

    private int enabled;
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles;

    public User(Long id, String name, String adres, String mail, String password, String phone, String accountNumber, String description, Region region, Set<Category> categories, Set<Needs> needs, int enabled) {
        this.id = id;
        this.name = name;
        this.adres = adres;
        this.mail = mail;
        this.password = password;
        this.phone = phone;
        this.accountNumber = accountNumber;
        this.description = description;
        this.region = region;
        this.categories = categories;
        this.needs = needs;
        this.enabled = enabled;
    }

    public void addCategory(Category category) {
        this.categories.add(category);
        category.getUsers().add(this);
    }

    public void removeCategory(Category category) {
        this.categories.remove(category);
        category.getUsers().remove(this);
    }
}

