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

    public static interface MostLikedTeam {
        Long getId();
        String getName();
        int getCounter();
    }

    //Team findTeamByUser (String login);

    @Query(value = "SELECT * from Teams t Where t.users.login = :user ORDER BY t.name DESC LIMIT 1", nativeQuery = true)
   Team findTeamByUser(@Param("user") String user);

    // TODO nie działa
  List<Team> getTeamByUsers(String login);


}
