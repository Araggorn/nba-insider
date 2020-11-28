package pl.coderslab.nbainsider.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.coderslab.nbainsider.entity.Player;

@Repository
public interface PlayerRepository extends JpaRepository<Player, Long> {
}
