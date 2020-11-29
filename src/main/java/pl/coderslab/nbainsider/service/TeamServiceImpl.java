package pl.coderslab.nbainsider.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.coderslab.nbainsider.entity.Team;
import pl.coderslab.nbainsider.entity.User;
import pl.coderslab.nbainsider.repository.TeamRepository;

import java.util.List;

@Service
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
}
