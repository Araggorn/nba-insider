package pl.coderslab.nbainsider.service;

import pl.coderslab.nbainsider.dto.TeamLikeDto;
import pl.coderslab.nbainsider.entity.Team;
import pl.coderslab.nbainsider.entity.User;

import java.util.List;

public interface TeamService {

    List<Team> findAllTeams();

    Team findById(Long id);

    void add(Team team);

    List<TeamLikeDto> find4mostlikedteams();

    Team getTeamByUsers();


}
