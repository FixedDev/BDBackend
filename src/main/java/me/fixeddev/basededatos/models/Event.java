package me.fixeddev.basededatos.models;

import jakarta.persistence.*;
import me.fixeddev.basededatos.models.converter.AssistanceTypeConverter;

import java.util.Date;
import java.util.Objects;
import java.util.Optional;

@Entity
@Table(name = "Events")
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "eventsId")
    private Long eventsId;

    @Column(nullable = false, name = "Name")
    private String name;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "categoryId", nullable = false)
    private Category category;

    @Column(nullable = false)
    private double cost;

    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "campusId", nullable = false)
    private Campus campus;

    @Column(nullable = false)
    private boolean numbered;

    @Column(nullable = false)
    private int capacity;

    @Column(nullable = false, name = "assistanceType")
    @Convert(converter = AssistanceTypeConverter.class)
    private AssistanceType assistanceType;

    public Event(Long eventsId, String name, Category category, double cost, Date date, Campus campus, boolean numbered, int capacity, AssistanceType assistanceType) {
        this.eventsId = eventsId;
        this.name = name;
        this.category = category;
        this.cost = cost;
        this.date = date;
        this.campus = campus;
        this.numbered = numbered;
        this.capacity = capacity;
        this.assistanceType = assistanceType;
    }

    public Event() {
    }

    public Long getEventsId() {
        return eventsId;
    }

    public void setEventsId(Long eventsId) {
        this.eventsId = eventsId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Campus getCampus() {
        return campus;
    }

    public void setCampus(Campus campus) {
        this.campus = campus;
    }

    public boolean isNumbered() {
        return numbered;
    }

    public void setNumbered(boolean numbered) {
        this.numbered = numbered;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public AssistanceType getAssistanceType() {
        return assistanceType;
    }

    public void setAssistanceType(AssistanceType assistanceType) {
        this.assistanceType = assistanceType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Event event = (Event) o;
        return Double.compare(event.cost, cost) == 0 && numbered == event.numbered && capacity == event.capacity && Objects.equals(eventsId, event.eventsId) && Objects.equals(name, event.name) && Objects.equals(category, event.category) && Objects.equals(date, event.date) && Objects.equals(campus, event.campus) && assistanceType == event.assistanceType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(eventsId, name, category, cost, date, campus, numbered, capacity, assistanceType);
    }

    @Override
    public String toString() {
        return "Event{" +
                "eventsId=" + eventsId +
                ", name='" + name + '\'' +
                ", category=" + category +
                ", cost=" + cost +
                ", date=" + date +
                ", campus=" + campus +
                ", numbered=" + numbered +
                ", capacity=" + capacity +
                ", assistanceType=" + assistanceType +
                '}';
    }

    public enum AssistanceType {
        IN_PERSON,
        VIRTUAL;

        public static Optional<AssistanceType> check(String val) {
            if (val.equals("IN PERSON")) {
                return Optional.of(IN_PERSON);
            }

            try {
                return Optional.of(AssistanceType.valueOf(val));
            } catch (Exception e) {/* do nothing */}
            return Optional.empty();
        }
    }
}