package bg.softuni.mobilelele.model.view;

import bg.softuni.mobilelele.model.entity.enums.Transmission;

import java.math.BigDecimal;
import java.time.Instant;

public class OfferDetailView {

    private Long id;
    private Integer mileage;
    private BigDecimal price;
    private String engineType;
    private Transmission transmissionType;
    private Instant created;
    private Instant modified;
    private String seller;
    private Integer year;
    private String brand;
    private String model;

    private String imageUrl;

    public Long getId() {
        return id;
    }

    public OfferDetailView setId(Long id) {
        this.id = id;
        return this;
    }

    public Integer getMileage() {
        return mileage;
    }

    public OfferDetailView setMileage(Integer mileage) {
        this.mileage = mileage;
        return this;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public OfferDetailView setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    public String getEngineType() {
        return engineType;
    }

    public OfferDetailView setEngineType(String engineType) {
        this.engineType = engineType;
        return this;
    }

    public Transmission getTransmissionType() {
        return transmissionType;
    }

    public OfferDetailView setTransmissionType(Transmission transmissionType) {
        this.transmissionType = transmissionType;
        return this;
    }

    public Instant getCreated() {
        return created;
    }

    public OfferDetailView setCreated(Instant created) {
        this.created = created;
        return this;
    }

    public Instant getModified() {
        return modified;
    }

    public OfferDetailView setModified(Instant modified) {
        this.modified = modified;
        return this;
    }

    public String getSeller() {
        return seller;
    }

    public OfferDetailView setSeller(String seller) {
        this.seller = seller;
        return this;
    }

    public Integer getYear() {
        return year;
    }

    public OfferDetailView setYear(Integer year) {
        this.year = year;
        return this;
    }

    public String getBrand() {
        return brand;
    }

    public OfferDetailView setBrand(String brand) {
        this.brand = brand;
        return this;
    }

    public String getModel() {
        return model;
    }

    public OfferDetailView setModel(String model) {
        this.model = model;
        return this;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public OfferDetailView setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
        return this;
    }
}
