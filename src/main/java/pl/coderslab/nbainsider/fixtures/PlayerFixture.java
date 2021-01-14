package pl.coderslab.nbainsider.fixtures;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import pl.coderslab.nbainsider.entity.Player;
import pl.coderslab.nbainsider.service.PlayerService;

import java.util.Arrays;
import java.util.List;

@Component
@Profile("local")
public class PlayerFixture {
    PlayerService playerService;

    public PlayerFixture(PlayerService playerService) {
        this.playerService = playerService;
    }

    private final List<Player> playerlist = Arrays.asList(
            new Player(null, "Michael", "Jordan"),
            new Player(null, "LeBron", "James"),
            new Player(null, "Stephen", "Curry"),
            new Player(null, "Kobe", "Bryant"),
            new Player(null, "Shaquille", "O'Neal"),
            new Player(null, "Baron", "Davis"),
            new Player(null, "Giannis", "Antetokounmpo"),
            new Player(null, "Klay", "Thompson"),
            new Player(null, "Scottie", "Pippen"),
            new Player(null, "John", "Stockton")
    );

    public void loadIntoDB() {
        for (Player player : playerlist) {
            playerService.add(player);
        }
    }
}
