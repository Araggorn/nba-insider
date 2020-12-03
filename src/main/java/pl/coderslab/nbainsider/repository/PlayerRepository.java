package pl.coderslab.nbainsider.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pl.coderslab.nbainsider.entity.Player;
import pl.coderslab.nbainsider.entity.Team;

import java.util.List;

@Repository
public interface PlayerRepository extends JpaRepository<Player, Long> {

    @Query (value= "select count(u.id), p.last_name, p.first_name fullname from users u inner join players p on p.id = u.player_id group by p.last_name, p.first_name  order by 1 desc limit 5", nativeQuery = true)
    List<Player> findmostlikedplayers();
}
