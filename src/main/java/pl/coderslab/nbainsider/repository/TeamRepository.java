package pl.coderslab.nbainsider.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.coderslab.nbainsider.entity.Team;

@Repository
public interface TeamRepository extends JpaRepository <Team, Long>{
}
