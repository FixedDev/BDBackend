package me.fixeddev.basededatos.repositories;

import me.fixeddev.basededatos.models.Campus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin
public interface CampusRepository extends JpaRepository<Campus, Long> {
}