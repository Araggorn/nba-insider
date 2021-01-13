package pl.coderslab.nbainsider.fixtures;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.coderslab.nbainsider.entity.Team;
import pl.coderslab.nbainsider.service.TeamService;
import java.util.Arrays;
import java.util.List;

@Component
public class TeamFixture {
    private final TeamService teamService;

    private final List<Team> teamList = Arrays.asList(
            new Team(null, "Golden State Warriors", "warriors"),
            new Team(null, "Los Angeles Lakers", "lakers"),
            new Team(null, "Miami Heat", "MiamiHEAT"),
            new Team(null, "Houston Rockets", "HoustonRockets"),
            new Team(null, "Chicago Bulls", "chicagobulls"),
            new Team(null, "New York Knicks", "nyknicks"),
            new Team(null, "Los Angeles Clippers", "LAClippers"),
            new Team(null, "Atlanta Hawks", "ATLHawks"),
            new Team(null, "Boston Celtics", "celtics"),
            new Team(null, "Portland Trail Blazers", "trailblazers"),
            new Team(null, "Oklahoma City Thunder", "okcthunder"),
            new Team(null, "San Antonio Spurs", "spurs"),
            new Team(null, "Toronto Raptors", "Raptors"),
            new Team(null, "Dallas Mavericks", "dallasmavs"),
            new Team(null, "Denver Nuggets", "nuggets"),
            new Team(null, "New Orleans Pelicans", "PelicansNBA"),
            new Team(null, "Charlotte Hornets", "hornets"),
            new Team(null, "Orlando Magic", "OrlandoMagic"),
            new Team(null, "Washington Wizards", "WashWizards"),
            new Team(null, "Brooklyn Nets", "BrooklynNets"),
            new Team(null, "Cleveland Cavaliers", "cavs"),
            new Team(null, "Utah Jazz", "utahjazz"),
            new Team(null, "Sacramento Kings", "SacramentoKings"),
            new Team(null, "Indiana Pacers", "Pacers"),
            new Team(null, "Memphis Grizzlies", "memgrizz"),
            new Team(null, "Phoenix Suns", "Suns"),
            new Team(null, "Philadelphia 76ers", "sixers" ),
            new Team(null, "Detroit Pistons", "DetroitPistons"),
            new Team(null, "Milwaukee Bucks", "Bucks"),
            new Team(null, "Minnesota Timberwolves", "Timberwolves" )
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

