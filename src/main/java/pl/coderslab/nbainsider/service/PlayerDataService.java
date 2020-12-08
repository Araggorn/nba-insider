package pl.coderslab.nbainsider.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.coderslab.nbainsider.client.BalldontlieClient;
import pl.coderslab.nbainsider.client.dto.Page;
import pl.coderslab.nbainsider.client.dto.Player;

@Service
@Slf4j
public class PlayerDataService {

    private final BalldontlieClient balldontlieClient;

    @Autowired
    public PlayerDataService(BalldontlieClient balldontlieClient) {
        this.balldontlieClient = balldontlieClient;
    }


    public boolean checkIfPlayerExists(String firstname, String lastname) {
        Page<Player> players = balldontlieClient.getPlayers();
        log.info("Players: {}", players);
        return true;
    }

}
