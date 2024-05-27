package me.fixeddev.basededatos.repositories;

import me.fixeddev.basededatos.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin
public interface RoleRepository extends JpaRepository<Role, Long> {
}