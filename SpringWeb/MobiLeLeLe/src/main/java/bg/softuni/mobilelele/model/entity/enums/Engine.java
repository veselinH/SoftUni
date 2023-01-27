package bg.softuni.mobilelele.model.entity.enums;

public enum Engine {
    GASOLINE("Gasoline"),
    DIESEL("Diesel"),
    ELECTRIC("Electric"),
    HYBRID("Hybrid");

    private final String value;

    private Engine(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
