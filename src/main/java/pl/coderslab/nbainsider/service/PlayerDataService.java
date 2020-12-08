package pl.coderslab.nbainsider.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.coderslab.nbainsider.client.BalldontlieClient;
import pl.coderslab.nbainsider.client.dto.Meta;
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

        Integer nextPage = 1;
        while (nextPage != null) {
            Page<Player> page = balldontlieClient.getPlayers(lastname, nextPage);
            log.info("Players: {}", page);
            for (Player player : page.getData()) {
                if (player.getFirst_name().equals(firstname) && player.getLast_name().equals(lastname)) {
                    return true;
                }
            }
            nextPage = page.getMeta().getNext_page();
        }
        return false;
    }

}
