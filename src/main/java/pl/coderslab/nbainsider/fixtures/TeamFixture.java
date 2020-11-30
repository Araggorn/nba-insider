package pl.coderslab.nbainsider.fixtures;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.coderslab.nbainsider.entity.Team;
import pl.coderslab.nbainsider.entity.User;
import pl.coderslab.nbainsider.service.TeamService;
import pl.coderslab.nbainsider.service.UserService;

import java.util.Arrays;
import java.util.List;

@Component
public class TeamFixture {
    private TeamService teamService;

    private List<Team> teamList = Arrays.asList(
            new Team(null, "Golden State Warriors", "https://twitter.com/warriors"),
            new Team(null, "Los Angeles Lakers", "https://twitter.com/lakers"),
            new Team(null, "Miami Heat", "https://twitter.com/MiamiHEAT"),
            new Team(null, "Houston Rockets", "https://twitter.com/HoustonRockets"),
            new Team(null, "Chicago Bulls", "https://twitter.com/chicagobulls"),
            new Team(null, "New York Knicks", "https://twitter.com/nyknicks"),
            new Team(null, "Los Angeles Clippers", "https://twitter.com/LAClippers")
    );

    @Autowired
    public TeamFixture(TeamService teamService)
    {
        this.teamService = teamService;
    }

    public void loadIntoDB() {
        for (Team team : teamList) {
            teamService.add(team);
        }
    }
}

