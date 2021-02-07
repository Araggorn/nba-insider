package pl.coderslab.nbainsider.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.coderslab.nbainsider.app.SecurityUtils;
import pl.coderslab.nbainsider.dto.TeamLikeDto;
import pl.coderslab.nbainsider.entity.Team;
import pl.coderslab.nbainsider.repository.TeamRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class TeamServiceImpl implements TeamService {

    TeamRepository teamRepository;

    @Autowired
    public TeamServiceImpl(TeamRepository teamRepository) {
        this.teamRepository = teamRepository;
    }

    @Override
    public List<Team> findAllTeams() {
        return teamRepository.findAll();
    }

    @Override
    public Team findById(Long id) {
        return teamRepository.getOne(id);
    }
    @Override
    public void add(Team team) {
        teamRepository.save(team);
    }

    @Override
    public List<TeamLikeDto> find4mostlikedteams() {
        return  teamRepository.findmostlikedteams()
                .stream()
                .map(team -> new TeamLikeDto(team.getCounter(), team.getId(), team.getName()))
                .collect(Collectors.toList());
    }

    @Override
    public Team getTeamByUsers() {
       return teamRepository.getTeamByUser(SecurityUtils.username());
    }

    @Override
    public List<TeamLikeDto> findleastlikedteams() {
        return teamRepository.findlesslikedteams()
                .stream()
                .map(team -> new TeamLikeDto(team.getCounter(), team.getId(), team.getName()))
                .collect(Collectors.toList());
    }

    @Override
    public Long count(Long id) {
        return teamRepository.counter(id);
    }
}
