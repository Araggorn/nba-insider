package pl.coderslab.nbainsider.fixtures;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import pl.coderslab.nbainsider.entity.Player;
import pl.coderslab.nbainsider.entity.Team;
import pl.coderslab.nbainsider.entity.User;
import pl.coderslab.nbainsider.service.PlayerService;
import pl.coderslab.nbainsider.service.TeamService;
import pl.coderslab.nbainsider.service.UserService;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

@Component
@Profile("local")
public class UserFixture {
    private final UserService userService;
    private final TeamService teamService;
    private final PlayerService playerService;

    private final List<User> userList = Arrays.asList(
            new User(null, "Araggorn", "masło", "zerelik@o2.pl", null, null),
            new User(null, "Olek", "wygasło", "zerelik@p2.pl", null, null),
            new User(null, "qba", "qbeczek", "kuboniszom@gmail.com", null, null),
            new User(null, "pinka", "malinka", "korniszonek@nba.com", null, null),
            new User(null, "Arek", "aserehe", "arekbezbarek@nba.com", null, null),
            new User(null, "Irenka", "beza", "beza@beza.beza", null, null),
            new User(null, "admin", "admin", "drednor@o2.pl", null, null),
            new User(null, "Buggs Bunny", "ali", "buckik@toons.pl", null, null),
            new User(null, "Donald Duck", "duckyduck", "dduck@kaczogrod.info", null, null)
    );

    @Autowired
    public UserFixture(UserService userService, TeamService teamService, PlayerService playerService) {
        this.userService = userService;
        this.playerService = playerService;
        this.teamService = teamService;
    }

    public void loadIntoDB() {
        List<Team> teams = teamService.findAllTeams();
        List<Player> players = playerService.findAllPlayers();
        Random rand = new Random();

        User useradmin = userList.get(1);
        User useradmin1 = userList.get(0);
        useradmin.setRole("ROLE_ADMIN");
        useradmin1.setRole("ROLE_ADMIN");

        for (User user : userList) {
            user.setTeam(teams.get(rand.nextInt(teams.size())));
            user.setPlayer(players.get(rand.nextInt(players.size())));
            userService.save(user);
        }

    }
}
