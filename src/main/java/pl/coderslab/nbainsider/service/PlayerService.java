package pl.coderslab.nbainsider.service;

import pl.coderslab.nbainsider.dto.PlayerLikeDto;
import pl.coderslab.nbainsider.dto.TeamLikeDto;
import pl.coderslab.nbainsider.entity.Player;
import pl.coderslab.nbainsider.entity.Team;

import java.util.List;

public interface PlayerService {
    List<Player> findAllPlayers();

    Player findById(Long id);
    boolean add(Player player);

    List<PlayerLikeDto> find4mostlikedplayers();

    String getPlayerByUser();
    Player getPlayerFullInfoByUser();
    Long countPlayers();

    Long countUsersThatLikeMyFavouritePlayer(Long id);


}
