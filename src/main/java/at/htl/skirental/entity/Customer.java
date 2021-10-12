package at.htl.skirental.entity;

import org.eclipse.microprofile.openapi.annotations.media.Schema;

import javax.json.bind.annotation.JsonbProperty;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;
import java.util.Objects;

@Entity
@XmlRootElement
@Schema(description = "This is a Customer that rents a ski")
public class Customer {
    @OneToMany(mappedBy = "customer")
    List<Rental> rentals;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonbProperty("first_name")
    @Schema(required = true)
    private String firstName;
    @JsonbProperty("last_name")
    @Schema(required = true)
    private String lastName;

    public Long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return Objects.equals(rentals, customer.rentals) && Objects.equals(firstName, customer.firstName) && Objects.equals(lastName, customer.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(rentals, firstName, lastName);
    }
}
