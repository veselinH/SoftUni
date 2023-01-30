package bg.softuni.battleshipapplication.model.entity;

import bg.softuni.battleshipapplication.model.entity.enums.CategoryEnum;
import jakarta.persistence.*;

@Entity
@Table(name = "categories")
public class Category extends BaseEntity{

    private CategoryEnum name;
    private String description;

    public Category() {
    }

    @Enumerated(EnumType.STRING)
    @Column(unique = true, nullable = false)
    public CategoryEnum getName() {
        return name;
    }

    public Category setName(CategoryEnum name) {
        this.name = name;
        return this;
    }

    @Column
    public String getDescription() {
        return description;
    }

    public Category setDescription(String description) {
        this.description = description;
        return this;
    }
}
