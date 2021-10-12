package at.htl.skirental.entity;

import org.eclipse.microprofile.openapi.annotations.media.Schema;

import javax.json.bind.annotation.JsonbProperty;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@Entity
@XmlRootElement
@Schema(description = "This is a Ski. It can be rented by a customer.")
public class Ski {
    @OneToMany(mappedBy = "ski")
    List<Rental> rentals;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonbProperty("brand")
    @Schema(required = true)
    private String brand;
    @JsonbProperty("type")
    @Schema(required = true)
    private SkiType type;
    @JsonbProperty("length")
    @Schema(required = true)
    private int length;
    @JsonbProperty("year")
    @Schema(required = true)
    private int year;

    public Ski() {
    }

    public Long getId() {
        return id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public SkiType getType() {
        return type;
    }

    public void setType(SkiType type) {
        this.type = type;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
}
