package pl.coderslab.nbainsider.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pl.coderslab.nbainsider.entity.Player;
import pl.coderslab.nbainsider.entity.Team;

import java.util.List;

@Repository
public interface PlayerRepository extends JpaRepository<Player, Long> {

    @Query(value = "select count(u.id) as counter, p.last_name as lastName, p.first_name as firstName from users u inner join players p on p.id = u.player_id group by p.last_name, p.first_name  order by 1 desc limit 5", nativeQuery = true)
    List<MostLikedPlayer> findmostlikedplayers();

    interface MostLikedPlayer {
        int getCounter();

        Long getId();
        String getFirstName();
        String getLastName();
    }

    @Query(value = "SELECT CONCAT(p.first_name,' ' ,p.last_name) fullname FROM users u\n" +
            "    LEFT JOIN players p on p.id = u.player_id WHERE u.login = ?1", nativeQuery = true)
    String getPlayerByUser(@Param("login") String login);

    @Query(value = "SELECT p.* FROM users u\n" +
            "    LEFT JOIN players p on p.id = u.player_id WHERE u.login = ?1", nativeQuery = true)
    Player getPlayerFullInfoByUser(@Param("login") String login);
}
