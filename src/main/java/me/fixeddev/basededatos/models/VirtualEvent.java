package me.fixeddev.basededatos.models;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "VirtualEvents")
public class VirtualEvent {
    @Id
    private Long eventId;

    @Column(nullable = false)
    private String link;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @MapsId
    @JoinColumn(name = "eventId")
    private Event event;


    public VirtualEvent() {
    }

    public VirtualEvent(Long eventId, String link, Event event) {
        this.eventId = eventId;
        this.link = link;
        this.event = event;
    }

    public Long getEventId() {
        return eventId;
    }

    public void setEventId(Long eventId) {
        this.eventId = eventId;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
        this.eventId = event.getEventsId();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        VirtualEvent that = (VirtualEvent) o;
        return Objects.equals(eventId, that.eventId) && Objects.equals(link, that.link) && Objects.equals(event, that.event);
    }

    @Override
    public int hashCode() {
        return Objects.hash(eventId, link, event);
    }

    @Override
    public String toString() {
        return "VirtualEvent{" +
                "eventId=" + eventId +
                ", link='" + link + '\'' +
                ", event=" + event +
                '}';
    }
}