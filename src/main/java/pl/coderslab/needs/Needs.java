package pl.coderslab.needs;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.mapping.ToOne;
import pl.coderslab.category.Category;
import pl.coderslab.user.User;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;


@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Needs {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @CreationTimestamp
    private LocalDateTime createDateTime;
    private String name;
    @OneToOne
    private Category category;
    @ManyToMany
    private List<User> user;

    public Needs(String name, Category category, List<User> user) {
        this.name = name;
        this.category = category;
        this.user = user;
    }
}