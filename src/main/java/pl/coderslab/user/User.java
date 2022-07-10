package pl.coderslab.user;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pl.coderslab.category.Category;
import pl.coderslab.needs.Needs;
import pl.coderslab.region.Region;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String adres;
//    @Email !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
    private String mail;
    private String password;
    @Size(min = 7, max = 11)
    private String phone;
//    @Size(min = 26, max = 32)
    private String accountNumber;
    private String description;
    @ManyToOne
    private Region region;
    @ManyToOne
    private Category category;
//    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @ManyToMany
    private Set<Needs> needs;

    public User(String name, String adres, String mail, String password, String phone, String accountNumber, String description, Region region, Category category, Set<Needs> needs) {
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

//    public static List<User> create() {
//        List<User> result = new ArrayList<>();
//        result.add(new User("Camping nr 171 Krakowianka", "30-427, Żywiecka Boczna 2, Kraków", "camping@krakowianka.pl", "Camp", "122681417", "26 1470 0002 2008 8277 2000 0001", "jsdfjg aseefjkja fjehfha fsawefr"));
//        result.add(new User("Karmelici Bosi", "Czerna 79, 32-065 Krzeszowice", "czerna@karmel.pl", "Camp1", "122820065", "262 1090 2590 0000 0001 4327 3604", "Klasztor pw. św. Eliasza proroka"));
//        return result;
//    }
