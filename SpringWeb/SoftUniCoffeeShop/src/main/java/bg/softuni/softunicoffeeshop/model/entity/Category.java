package bg.softuni.softunicoffeeshop.model.entity;

import bg.softuni.softunicoffeeshop.model.entity.enums.CategoryNameEnum;
import jakarta.persistence.*;

import java.lang.annotation.Target;

@Entity
@Table(name = "category")
public class Category extends BaseEntity {

    private CategoryNameEnum name;
    private Integer neededTime;

    public Category() {
    }

    @Column
    @Enumerated(EnumType.STRING)
    public CategoryNameEnum getName() {
        return name;
    }

    public Category setName(CategoryNameEnum name) {
        this.name = name;
        return this;
    }

    @Column(name = "needed_time", nullable = false)
    public Integer getNeededTime() {
        return neededTime;
    }

    public Category setNeededTime(Integer neededTime) {
        this.neededTime = neededTime;
        return this;
    }
}
