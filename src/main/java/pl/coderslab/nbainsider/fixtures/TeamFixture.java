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
            new Team(null, "Golden State Warriors", "warriors"),
            new Team(null, "Los Angeles Lakers", "lakers"),
            new Team(null, "Miami Heat", "MiamiHEAT"),
            new Team(null, "Houston Rockets", "HoustonRockets"),
            new Team(null, "Chicago Bulls", "chicagobulls"),
            new Team(null, "New York Knicks", "nyknicks"),
            new Team(null, "Los Angeles Clippers", "LAClippers"),
            new Team(null, "Atlanta Hawks", "ATLHawks"),
            new Team(null, "Boston Celtics", "celtics"),
            new Team(null, "Portland Trail Blazers", "trailblazers")
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

