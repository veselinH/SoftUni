package softuni.exam.models.entity;

import softuni.exam.models.entity.enums.ApartmentType;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "apartments")
public class Apartment extends BaseEntity{

    private ApartmentType apartmentType;
    private Double area;

    public Apartment() {
    }

    @Column(name = "apartment_type")
    public ApartmentType getApartmentType() {
        return apartmentType;
    }

    public void setApartmentType(ApartmentType apartmentType) {
        this.apartmentType = apartmentType;
    }

    @Column
    public Double getArea() {
        return area;
    }

    public void setArea(Double area) {
        this.area = area;
    }
}
