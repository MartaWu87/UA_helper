package pl.coderslab.category;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pl.coderslab.needs.Needs;

import java.util.List;


public interface CategoryRepository extends JpaRepository<Category, Long> {

    @Query(value = "select * from category where user_id =?", nativeQuery=true)
    List<Needs> findAllByUserId(Long id);
}
