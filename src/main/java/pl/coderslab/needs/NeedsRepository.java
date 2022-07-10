package pl.coderslab.needs;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pl.coderslab.user.User;

import java.util.Calendar;
import java.util.List;

@Repository
public interface NeedsRepository extends JpaRepository<Needs, Long> {
}
