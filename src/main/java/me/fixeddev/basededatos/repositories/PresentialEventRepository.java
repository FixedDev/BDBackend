package me.fixeddev.basededatos.repositories;

import me.fixeddev.basededatos.models.PresentialEvent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin
public interface PresentialEventRepository extends JpaRepository<PresentialEvent, Long> {
}