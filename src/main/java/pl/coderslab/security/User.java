package pl.coderslab.security;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pl.coderslab.Role;
import pl.coderslab.category.Category;
import pl.coderslab.needs.Needs;
import pl.coderslab.region.Region;

import javax.persistence.*;
import javax.validation.constraints.Email;
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
    @Column (nullable = false, unique = true, length = 60)
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
    @ManyToMany
    private Set<Category> category;
    @OneToMany
    private Set<Needs> needs;

    private int enabled;
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles;

    public User(Long id, String name, String adres, String mail, String password, String phone, String accountNumber, String description, Region region, Set<Category> category, Set<Needs> needs) {
        this.id = id;
        this.name = name;
        this.adres = adres;
        this.mail = mail;
        this.password = password;
        this.phone = phone;
        this.accountNumber = accountNumber;
        this.description = description;
        this.region = region;
        this.category = category;
        this.needs = needs;
    }
}

