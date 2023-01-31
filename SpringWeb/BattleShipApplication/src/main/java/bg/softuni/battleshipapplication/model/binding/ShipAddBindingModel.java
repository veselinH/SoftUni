package bg.softuni.battleshipapplication.model.binding;

import bg.softuni.battleshipapplication.model.entity.Category;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

public class ShipAddBindingModel {

    private String name;
    private Long health;
    private Long power;
    private LocalDate created;
    private Category category;

    public ShipAddBindingModel() {
    }

    @NotNull
    @Size(min = 2, max = 10, message = "Name must be between 2 and 10 characters.")
    public String getName() {
        return name;
    }

    public ShipAddBindingModel setName(String name) {
        this.name = name;
        return this;
    }

    @NotNull
    @Positive(message = "The health must be positive.")
    public Long getHealth() {
        return health;
    }

    public ShipAddBindingModel setHealth(Long health) {
        this.health = health;
        return this;
    }

    @NotNull
    @Positive(message = "The power must be positive.")
    public Long getPower() {
        return power;
    }

    public ShipAddBindingModel setPower(Long power) {
        this.power = power;
        return this;
    }

    @NotNull(message = "You must select a date.")
    @PastOrPresent(message = "Created date cannot be in the future.")
    public LocalDate getCreated() {
        return created;
    }

    public ShipAddBindingModel setCreated(LocalDate created) {
        this.created = created;
        return this;
    }

    @NotNull(message = "You must select the category.")
    public Category getCategory() {
        return category;
    }

    public ShipAddBindingModel setCategory(Category category) {
        this.category = category;
        return this;
    }
}
