package me.fixeddev.basededatos.repositories;

import me.fixeddev.basededatos.models.VirtualEvent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin
public interface VirtualEventRepository extends JpaRepository<VirtualEvent, Long> {
}