package pl.coderslab.needs;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import pl.coderslab.category.Category;
import pl.coderslab.security.User;

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
    @ManyToOne
    private User user;

    public Needs(long id, LocalDateTime createDateTime, String name, Category category) {
        this.id = id;
        this.createDateTime = createDateTime;
        this.name = name;
        this.category = category;
    }
}