package pl.coderslab.nbainsider.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.coderslab.nbainsider.entity.Contact;

@Repository
public interface ContactRepository extends JpaRepository <Contact, Long> {
}
