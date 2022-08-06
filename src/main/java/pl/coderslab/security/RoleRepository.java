package pl.coderslab.security;

import org.springframework.data.jpa.repository.JpaRepository;


public interface RoleRepository extends JpaRepository <Role, Long> {
    Role findByName(String name);
}