package pl.coderslab.nbainsider.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pl.coderslab.nbainsider.entity.Team;

import java.util.List;

@Repository
public interface TeamRepository extends JpaRepository <Team, Long>{

    @Query(value = "Select t FROM Team t order by t.users.size DESC LIMIT 3", nativeQuery = true)
    List<Team> find3mostlikedteams();


}
