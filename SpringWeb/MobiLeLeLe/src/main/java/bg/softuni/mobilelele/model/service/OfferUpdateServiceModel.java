package bg.softuni.mobilelele.model.service;

import bg.softuni.mobilelele.model.entity.enums.Engine;
import bg.softuni.mobilelele.model.entity.enums.Transmission;

import java.math.BigDecimal;

public class OfferUpdateServiceModel {
    private Long id;
    private Integer mileage;
    private BigDecimal price;
    private Engine engine;
    private Transmission transmission;
    private Integer year;

    private String imageUrl;

    private String description;

    public Long getId() {
        return id;
    }

    public OfferUpdateServiceModel setId(Long id) {
        this.id = id;
        return this;
    }

    public Integer getMileage() {
        return mileage;
    }

    public OfferUpdateServiceModel setMileage(Integer mileage) {
        this.mileage = mileage;
        return this;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public OfferUpdateServiceModel setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    public Engine getEngineType() {
        return engine;
    }

    public OfferUpdateServiceModel setEngineType(Engine engineType) {
        this.engine = engineType;
        return this;
    }

    public Transmission getTransmission() {
        return transmission;
    }

    public OfferUpdateServiceModel setTransmission(Transmission transmission) {
        this.transmission = transmission;
        return this;
    }

    public Integer getYear() {
        return year;
    }

    public OfferUpdateServiceModel setYear(Integer year) {
        this.year = year;
        return this;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public OfferUpdateServiceModel setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public OfferUpdateServiceModel setDescription(String description) {
        this.description = description;
        return this;
    }
}
