package pl.coderslab.region;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pl.coderslab.user.User;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Region {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String voivodship;
    @OneToMany
    private List<User> user = new ArrayList<User>();

    public Region(long id, String voivodship) {
        this.id = id;
        this.voivodship = voivodship;
    }
}
