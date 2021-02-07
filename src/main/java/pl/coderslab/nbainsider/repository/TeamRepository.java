package pl.coderslab.nbainsider.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pl.coderslab.nbainsider.entity.Team;

import java.util.List;

@Repository
public interface TeamRepository extends JpaRepository <Team, Long>{

    @Query(value = "select count(u.id) as counter, t.name, t.id from users u inner join teams t on t.id = u.team_id group by t.name, t.id  order by 1 desc limit 5", nativeQuery = true)
    List<MostLikedTeam> findmostlikedteams();

    interface MostLikedTeam {
        Long getId();
        String getName();
        int getCounter();
    }

    @Query(value = "select count(u.id) as counter, t.name, t.id from users u inner join teams t on t.id = u.team_id group by t.name, t.id  order by 1 asc limit 15", nativeQuery = true)
    List<MostLikedTeam> findlesslikedteams();



   @Query(value = "select count(u.id) as counter from users u inner join teams t on t.id = u.team_id where t.id = :teamid", nativeQuery = true)
    int counter (@Param ("teamid") Long team_id);


    @Query(value = "SELECT * from Teams t Where t.users.login = :user ORDER BY t.name DESC LIMIT 1", nativeQuery = true)
   Team findTeamByUser(@Param("user") String user);


  @Query(value = "SELECT t.* FROM users u LEFT JOIN teams t on t.id = u.team_id WHERE u.login = ?1", nativeQuery = true)
  Team getTeamByUser(@Param("login") String login);


}
