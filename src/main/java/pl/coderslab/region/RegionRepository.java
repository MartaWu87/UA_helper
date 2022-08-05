package pl.coderslab.region;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;

public interface RegionRepository extends JpaRepository<Region, Long> {


    Region findById(long id);
}
