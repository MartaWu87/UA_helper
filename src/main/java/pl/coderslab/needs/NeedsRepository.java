package pl.coderslab.needs;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NeedsRepository extends JpaRepository<Needs, Long> {

    @Query(value = "select * from needs where userId =?", nativeQuery=true)
            List<Needs>findByUserId();
}
