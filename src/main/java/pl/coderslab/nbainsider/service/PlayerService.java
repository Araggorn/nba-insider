package pl.coderslab.nbainsider.service;

import pl.coderslab.nbainsider.entity.Player;
import pl.coderslab.nbainsider.entity.Team;

import java.util.List;

public interface PlayerService {
    List<Player> findAllPlayers();

    Player findById(Long id);
    void add(Player player);
}
