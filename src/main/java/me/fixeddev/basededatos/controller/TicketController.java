package me.fixeddev.basededatos.controller;

import me.fixeddev.basededatos.models.Event;
import me.fixeddev.basededatos.models.Ticket;
import me.fixeddev.basededatos.models.TicketRequest;
import me.fixeddev.basededatos.models.User;
import me.fixeddev.basededatos.repositories.EventRepository;
import me.fixeddev.basededatos.repositories.TicketRepository;
import me.fixeddev.basededatos.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/api/tickets")
public class TicketController {

    @Autowired
    private TicketRepository ticketService;

    @Autowired
    private EventRepository eventService;

    @Autowired
    private UserRepository userService;

    @PostMapping
    public ResponseEntity<Ticket> createTicket(@RequestBody TicketRequest ticketRequest) {
        Optional<Event> event = eventService.findById(ticketRequest.eventId());
        Optional<User> user = userService.findById(ticketRequest.userId());

        if (event.isEmpty() || user.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        Ticket ticket = new Ticket();
        ticket.setEvent(event.get());
        ticket.setUser(user.get());

        Ticket createdTicket = ticketService.save(ticket);
        return new ResponseEntity<>(createdTicket, HttpStatus.CREATED);
    }
}

