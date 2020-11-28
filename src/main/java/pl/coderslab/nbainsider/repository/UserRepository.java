package pl.coderslab.nbainsider.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.coderslab.nbainsider.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}