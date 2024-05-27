package me.fixeddev.basededatos.controller;

import me.fixeddev.basededatos.models.Event;
import me.fixeddev.basededatos.models.PresentialEvent;
import me.fixeddev.basededatos.models.VirtualEvent;
import me.fixeddev.basededatos.repositories.CampusRepository;
import me.fixeddev.basededatos.repositories.CategoryRepository;
import me.fixeddev.basededatos.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/events")
public class EventController {

    @Autowired
    private EventService eventService;
    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private CampusRepository campusRepository;

    @PostMapping("/virtual")
    public ResponseEntity<VirtualEvent> createVirtualEvent(@RequestBody EventDTO eventDto) {
        Event event = new Event();
        event.setName(eventDto.getName());

        System.out.println(eventDto.getCategory());
        System.out.println(eventDto.getCampus());

        event.setCategory(categoryRepository.findById((long) eventDto.getCategory()).orElseThrow());
        event.setCost(eventDto.getCost());
        event.setDate(eventDto.getDate());
        event.setCampus(campusRepository.findById((long) eventDto.getCampus()).orElseThrow());
        event.setNumbered(eventDto.isNumbered());
        event.setCapacity(eventDto.getCapacity());
        event.setAssistanceType(Event.AssistanceType.check(eventDto.getAssistanceType()).orElseThrow());

        VirtualEvent virtualEvent = eventService.createVirtualEvent(event, eventDto.getLink());
        return ResponseEntity.status(HttpStatus.CREATED).body(virtualEvent);
    }

    @PostMapping("/presential")
    public ResponseEntity<PresentialEvent> createPresentialEvent(@RequestBody EventDTO eventDto) {
        Event event = new Event();
        event.setName(eventDto.getName());
        event.setCategory(categoryRepository.findById((long) eventDto.getCategory()).orElseThrow());
        event.setCost(eventDto.getCost());
        event.setDate(eventDto.getDate());
        event.setCampus(campusRepository.findById((long) eventDto.getCampus()).orElseThrow());
        event.setNumbered(eventDto.isNumbered());
        event.setCapacity(eventDto.getCapacity());
        event.setAssistanceType(Event.AssistanceType.check(eventDto.getAssistanceType()).orElseThrow());

        PresentialEvent presentialEvent = eventService.createPresentialEvent(event, eventDto.getLink());
        return ResponseEntity.status(HttpStatus.CREATED).body(presentialEvent);
    }
}