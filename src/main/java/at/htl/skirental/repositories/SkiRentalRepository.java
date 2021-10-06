package at.htl.skirental.repositories;

import at.htl.skirental.entity.Ski;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;
import java.util.List;

@ApplicationScoped
public class SkiRentalRepository implements PanacheRepository<Ski> {
    @Transactional
    public void addSki(Ski newSki) {
        persist(newSki);
    }

    public Ski findSki(Long id) {
        return findById(id);
    }

    public List<Ski> findAllSkis() {
        return listAll();
    }

    @Transactional
    public void update(Long id, Ski ski) {
        Ski updateSki = findSki(id);

        updateSki.setBrand(ski.getBrand());
        updateSki.setType(ski.getType());
        updateSki.setLength(ski.getLength());
        updateSki.setYear(ski.getYear());
    }

    @Transactional
    public void removeSki(Long id) {
        deleteById(id);
    }
}
