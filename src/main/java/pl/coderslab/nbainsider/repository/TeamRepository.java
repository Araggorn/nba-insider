package pl.coderslab.nbainsider.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pl.coderslab.nbainsider.entity.Team;

import java.util.List;

@Repository
public interface TeamRepository extends JpaRepository <Team, Long>{

    @Query(value = "select count(u.id), t.name from users u inner join teams t on t.id = u.team_id group by t.name  order by 1 desc limit 5", nativeQuery = true)
    List<Team> findmostlikedteams();



//@Query("select u from users u group by u.team")
//    List <Team> findmostlikedteams
}
