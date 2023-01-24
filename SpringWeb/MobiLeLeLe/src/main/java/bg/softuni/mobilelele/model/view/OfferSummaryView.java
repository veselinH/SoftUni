package bg.softuni.mobilelele.model.view;

import bg.softuni.mobilelele.model.entity.enums.Engine;
import bg.softuni.mobilelele.model.entity.enums.Transmission;

import java.math.BigDecimal;
import java.time.Instant;

public class OfferSummaryView {

    private String description;
    private Engine engine;
    private String imageUrl;
    private Integer mileage;
    private BigDecimal price;
    private Transmission transmission;
    private Integer year;
    private Instant created;
    private Instant modified;
    private String model;
}
