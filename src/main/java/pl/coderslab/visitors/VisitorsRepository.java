package pl.coderslab.visitors;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.user.User;

public interface VisitorsRepository extends JpaRepository<User, Long> {
}
