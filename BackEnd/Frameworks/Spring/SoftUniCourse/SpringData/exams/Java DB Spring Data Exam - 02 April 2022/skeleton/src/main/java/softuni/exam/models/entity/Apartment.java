package softuni.exam.models.entity;

import softuni.exam.util.enums.ApartmentType;

import javax.persistence.*;
import java.util.List;

@Entity
public class Apartment extends BaseEntity {
    //    • apartment type – the enumeration, one of the following – two_rooms, three_rooms, four_rooms
    //    • area – accepts number values that are more than or equal to 40.00.
    //    • Constraint: The apartment table has а relation with the towns table.
    @Enumerated(EnumType.STRING)
    @Column(nullable = false ,
            name = "apartment_type",
            columnDefinition = "varchar(255)")
    private ApartmentType apartmentType;

    @Column(nullable = false,
            name = "area",
            columnDefinition = "double")
    private Double area;

    @ManyToOne(cascade = {CascadeType.MERGE})
    private Town town;

    @OneToMany(cascade = CascadeType.MERGE , mappedBy = "apartment")
    private List<Offer> offers;

    public ApartmentType getApartmentType() {
        return apartmentType;
    }

    public Apartment setApartmentType(ApartmentType apartmentType) {
        this.apartmentType = apartmentType;
        return this;
    }

    public List<Offer> getOffers() {
        return offers;
    }

    public Apartment setOffers(List<Offer> offers) {
        this.offers = offers;
        return this;
    }

    public Double getArea() {
        return area;
    }

    public Apartment setArea(Double area) {
        this.area = area;
        return this;
    }

    public Town getTown() {
        return town;
    }

    public Apartment setTown(Town town) {
        this.town = town;
        return this;
    }
}
