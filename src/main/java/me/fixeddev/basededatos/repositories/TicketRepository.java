package me.fixeddev.basededatos.repositories;

import me.fixeddev.basededatos.models.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin
public interface TicketRepository extends JpaRepository<Ticket, Long> {
}