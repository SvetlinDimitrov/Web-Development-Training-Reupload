package softuni.exam.models.entity;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
public class Offer extends BaseEntity {
    //    • price – accepts a positive number.
    //    • published on – a date in the "dd/MM/yyyy" format.
    //    • Constraint: The offers table has a relation with the apartments table.
    //    • Constraint: The offers table has a relation with the agents table.

    @Column(nullable = false,
            name = "price",
            columnDefinition = "decimal(19,2)")
    private BigDecimal price;

    @Column(nullable = false,
            name = "published_on",
            columnDefinition = "date")
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private LocalDate publishedOn;

    @ManyToOne(cascade = CascadeType.MERGE)
    private Agent agent;

    @ManyToOne(cascade = CascadeType.MERGE)
    private Apartment apartment;

    public BigDecimal getPrice() {
        return price;
    }

    public Offer setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    public LocalDate getPublishedOn() {
        return publishedOn;
    }

    public Offer setPublishedOn(LocalDate publishedOn) {
        this.publishedOn = publishedOn;
        return this;
    }

    public Agent getAgent() {
        return agent;
    }

    public Offer setAgent(Agent agent) {
        this.agent = agent;
        return this;
    }

    public Apartment getApartment() {
        return apartment;
    }

    public Offer setApartment(Apartment apartment) {
        this.apartment = apartment;
        return this;
    }
}
