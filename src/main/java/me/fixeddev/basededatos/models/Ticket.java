package me.fixeddev.basededatos.models;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "Tickets")
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ticketsId")
    private Long ticketsId;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "eventId", nullable = false)
    private Event event;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "userId")
    private User user;

    public Ticket(Long ticketsId, Event event, User user) {
        this.ticketsId = ticketsId;
        this.event = event;
        this.user = user;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "ticketsId=" + ticketsId +
                ", event=" + event +
                ", user=" + user +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ticket ticket = (Ticket) o;
        return Objects.equals(ticketsId, ticket.ticketsId) && Objects.equals(event, ticket.event) && Objects.equals(user, ticket.user);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ticketsId, event, user);
    }

    public Long getTicketsId() {
        return ticketsId;
    }

    public void setTicketsId(Long ticketsId) {
        this.ticketsId = ticketsId;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Ticket() {
    }
}