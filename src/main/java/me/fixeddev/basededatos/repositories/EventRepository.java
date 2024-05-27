package me.fixeddev.basededatos.repositories;

import me.fixeddev.basededatos.models.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin
public interface EventRepository extends JpaRepository<Event, Long> {
}