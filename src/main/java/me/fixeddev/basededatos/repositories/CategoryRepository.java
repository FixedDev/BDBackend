package me.fixeddev.basededatos.repositories;

import me.fixeddev.basededatos.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin
public interface CategoryRepository extends JpaRepository<Category, Long> {
}