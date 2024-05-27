package me.fixeddev.basededatos.service;

import jakarta.transaction.Transactional;
import me.fixeddev.basededatos.models.Event;
import me.fixeddev.basededatos.models.PresentialEvent;
import me.fixeddev.basededatos.models.VirtualEvent;
import me.fixeddev.basededatos.repositories.EventRepository;
import me.fixeddev.basededatos.repositories.PresentialEventRepository;
import me.fixeddev.basededatos.repositories.VirtualEventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EventService {
    @Autowired
    private EventRepository eventRepository;

    @Autowired
    private VirtualEventRepository virtualEventRepository;

    @Autowired
    private PresentialEventRepository presentialEventRepository;

    @Transactional
    public VirtualEvent createVirtualEvent(Event event, String link) {
        Event savedEvent = eventRepository.save(event);
        VirtualEvent virtualEvent = new VirtualEvent();
        virtualEvent.setEvent(savedEvent);
        virtualEvent.setLink(link);

        System.out.println(virtualEvent);
        System.out.println(virtualEvent.getEvent());
        return virtualEventRepository.save(virtualEvent);
    }

    @Transactional
    public PresentialEvent createPresentialEvent(Event event, String location) {
        Event savedEvent = eventRepository.save(event);
        PresentialEvent presentialEvent = new PresentialEvent();
        presentialEvent.setEvent(savedEvent);
        presentialEvent.setLocation(location);

        System.out.println(presentialEvent);
        System.out.println(presentialEvent.getEvent());

        return presentialEventRepository.save(presentialEvent);
    }
}

