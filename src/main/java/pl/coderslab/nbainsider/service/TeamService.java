package pl.coderslab.nbainsider.service;

import pl.coderslab.nbainsider.dto.TeamLikeDto;
import pl.coderslab.nbainsider.entity.Team;

import java.util.List;

public interface TeamService {

    List<Team> findAllTeams();

    Team findById(Long id);

    void add(Team team);

    List<TeamLikeDto> find4mostlikedteams();

    Team getTeamByUsers();

    List<TeamLikeDto> findleastlikedteams();

    Long count(Long id);


}
