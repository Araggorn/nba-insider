package pl.coderslab.nbainsider.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.coderslab.nbainsider.entity.User;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    User findByEmail(String email);

    List<User> findAllByActiveTrue();

    boolean existsByLogin(String login);

    User getByLogin(String login);


}
