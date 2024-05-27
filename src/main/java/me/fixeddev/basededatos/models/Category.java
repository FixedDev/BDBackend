package me.fixeddev.basededatos.models;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "Categories")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "categoriesId")
    private Long categoriesId;

    @Column(nullable = false, name = "Name")
    private String name;

    public Category(Long categoriesId, String name) {
        this.categoriesId = categoriesId;
        this.name = name;
    }

    public Category() {
    }

    public Long getCategoryId() {
        return categoriesId;
    }

    public void setCategoriesId(Long categoriesId) {
        this.categoriesId = categoriesId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Category category = (Category) o;
        return Objects.equals(categoriesId, category.categoriesId) && Objects.equals(name, category.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(categoriesId, name);
    }

    @Override
    public String toString() {
        return "Category{" +
                "categoriesId=" + categoriesId +
                ", name='" + name + '\'' +
                '}';
    }
}