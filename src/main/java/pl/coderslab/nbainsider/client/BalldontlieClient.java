package pl.coderslab.nbainsider.client;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import pl.coderslab.nbainsider.client.dto.Page;
import pl.coderslab.nbainsider.client.dto.Player;
import pl.coderslab.nbainsider.client.dto.PlayerPage;

@Component
public class BalldontlieClient {

    private final RestTemplate restTemplate = new RestTemplate();

    public Page<Player> getPlayers() {
        return restTemplate.getForObject("https://www.balldontlie.io/api/v1/players", PlayerPage.class);
    }
}

