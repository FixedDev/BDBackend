package me.fixeddev.basededatos.models.converter;

import jakarta.persistence.AttributeConverter;
import me.fixeddev.basededatos.models.Event;

public class AssistanceTypeConverter implements AttributeConverter<Event.AssistanceType, String> {
    @Override
    public String convertToDatabaseColumn(Event.AssistanceType attribute) {
        if (attribute == null) {
            return "IN PERSON";
        }

        return switch (attribute) {
            case VIRTUAL -> "VIRTUAL";
            case IN_PERSON -> "IN PERSON";
        };
    }

    @Override
    public Event.AssistanceType convertToEntityAttribute(String dbData) {
        if (dbData == null) {
            return Event.AssistanceType.IN_PERSON;
        }

        return switch (dbData) {
            case "IN PERSON" -> Event.AssistanceType.IN_PERSON;
            default -> Event.AssistanceType.VIRTUAL;
        };
    }
}
