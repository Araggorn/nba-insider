package pl.coderslab.nbainsider.fixtures;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.coderslab.nbainsider.entity.Player;
import pl.coderslab.nbainsider.entity.Team;
import pl.coderslab.nbainsider.service.PlayerService;
import pl.coderslab.nbainsider.service.TeamService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class PlayerFixture {
    PlayerService playerService;

    public PlayerFixture(PlayerService playerService) {
        this.playerService = playerService;
    }

    private List<Player> playerlist = Arrays.asList(
            new Player(null, "Michael", "Jordan"),
            new Player(null, "Lebron", "James"),
            new Player(null, "Steph", "Curry"),
            new Player(null, "Kobe", "Bryant"),
            new Player(null, "Shaquille", "O'Neal")
    );

    public void loadIntoDB() {
        for (Player player : playerlist) {
            playerService.add(player);
        }
    }
}
