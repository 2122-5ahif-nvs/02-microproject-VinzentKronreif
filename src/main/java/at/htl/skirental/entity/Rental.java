package at.htl.skirental.entity;

import org.eclipse.microprofile.openapi.annotations.media.Schema;

import javax.json.bind.annotation.JsonbDateFormat;
import javax.json.bind.annotation.JsonbProperty;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.time.LocalDate;

@XmlRootElement
@NamedQueries({
        @NamedQuery(name = "Rental.getRentalByCustomer", query = "select r from Rental r where r.customer = :customer")
})
@Entity
@Schema(description = "This is a Rental; it combines the Customer and the ski that is rented.")
public class Rental {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @ManyToOne
    Ski ski;

    @ManyToOne
    Customer customer;

    @JsonbProperty("start_date")
    @JsonbDateFormat("dd-MM-yyyy")
    @Schema(implementation = String.class, format = "date", required = true)
    private LocalDate startDate;
    @JsonbProperty("end_date")
    @JsonbDateFormat("dd-MM-yyyy")
    @Schema(implementation = String.class, format = "date", required = true)
    private LocalDate endDate;

    @JsonbProperty("price")
    @Schema(required = true)
    double price;

    public Long getId() {
        return id;
    }

    public Rental() {
    }

    public Ski getSki() {
        return ski;
    }

    public void setSki(Ski ski) {
        this.ski = ski;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }


}
