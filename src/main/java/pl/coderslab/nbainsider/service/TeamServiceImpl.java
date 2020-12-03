package pl.coderslab.nbainsider.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.coderslab.nbainsider.dto.TeamLikeDto;
import pl.coderslab.nbainsider.dto.UserItemDto;
import pl.coderslab.nbainsider.entity.Team;
import pl.coderslab.nbainsider.entity.User;
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
        return  teamRepository.findmostlikedteams();
    }

}
