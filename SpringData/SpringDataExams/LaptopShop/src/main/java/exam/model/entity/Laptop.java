package exam.model.entity;

import exam.model.entity.enums.WarrantyType;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "laptops")
public class Laptop extends BaseEntity {

    private String macAddress;
    private Double cpuSpeed;
    private Integer ram;
    private Integer storage;
    private String description;
    private BigDecimal price;
    private WarrantyType warrantyType;
    private Shop shop;

    public Laptop() {
    }

    @Column(name = "mac_address", unique = true, nullable = false)
    public String getMacAddress() {
        return macAddress;
    }

    public void setMacAddress(String macAddress) {
        this.macAddress = macAddress;
    }

    @Column(name = "cpu_speed", nullable = false)
    public Double getCpuSpeed() {
        return cpuSpeed;
    }

    public void setCpuSpeed(Double cpuSpeed) {
        this.cpuSpeed = cpuSpeed;
    }

    @Column(nullable = false)
    public Integer getRam() {
        return ram;
    }

    public void setRam(Integer ram) {
        this.ram = ram;
    }

    @Column(nullable = false)
    public Integer getStorage() {
        return storage;
    }

    public void setStorage(Integer storage) {
        this.storage = storage;
    }

    @Column(nullable = false, columnDefinition = "TEXT")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Column(nullable = false)
    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Column(name = "warranty_type", nullable = false)
    @Enumerated(EnumType.ORDINAL)
    public WarrantyType getWarrantyType() {
        return warrantyType;
    }

    public void setWarrantyType(WarrantyType warrantyType) {
        this.warrantyType = warrantyType;
    }

    @ManyToOne
    public Shop getShop() {
        return shop;
    }

    public void setShop(Shop shop) {
        this.shop = shop;
    }

    @Override
    public String toString() {
        return String.format("Laptop - %s\n" +
                        "*Cpu speed - %.2f\n" +
                        "**Ram - %d\n" +
                        "***Storage - %d\n" +
                        "****Price - %.2f\n" +
                        "#Shop name - %s\n" +
                        "##Town - %s",
                getMacAddress(),
                getCpuSpeed(),
                getRam(),
                getStorage(),
                getPrice(),
                getShop().getName(),
                getShop().getTown().getName());
    }
}
