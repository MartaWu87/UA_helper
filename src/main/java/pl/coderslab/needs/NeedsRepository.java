package pl.coderslab.needs;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface NeedsRepository extends JpaRepository<Needs, Long> {

    @Query(value = "select * from needs where user_id =?", nativeQuery=true)
            List<Needs>findAllByUserId(Long id);
}
