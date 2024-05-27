package me.fixeddev.basededatos.models;
import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "PresentialEvents")
public class PresentialEvent {
    @Id
    private Long eventId;

    @Column(nullable = false)
    private String location;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @MapsId
    @JoinColumn(name = "eventId")
    private Event event;


    public PresentialEvent() {
    }

    public PresentialEvent(Long eventId, String location, Event event) {
        this.eventId = eventId;
        this.location = location;
        this.event = event;
    }

    public Long getEventId() {
        return eventId;
    }

    public void setEventId(Long eventId) {
        this.eventId = eventId;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
        this.eventId = event.getEventsId();
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PresentialEvent that = (PresentialEvent) o;
        return Objects.equals(eventId, that.eventId) && Objects.equals(location, that.location) && Objects.equals(event, that.event);
    }

    @Override
    public int hashCode() {
        return Objects.hash(eventId, location, event);
    }

    @Override
    public String toString() {
        return "PresentialEvent{" +
                "eventId=" + eventId +
                ", location='" + location + '\'' +
                ", event=" + event +
                '}';
    }
}