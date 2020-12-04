package pl.coderslab.nbainsider.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.coderslab.nbainsider.app.SecurityUtils;
import pl.coderslab.nbainsider.dto.PlayerLikeDto;
import pl.coderslab.nbainsider.dto.TeamLikeDto;
import pl.coderslab.nbainsider.entity.Player;
import pl.coderslab.nbainsider.entity.Team;
import pl.coderslab.nbainsider.repository.PlayerRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class PlayerServiceImpl implements PlayerService {

    PlayerRepository playerRepository;

    @Autowired
    public PlayerServiceImpl(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    @Override
    public List<Player> findAllPlayers() {
        return playerRepository.findAll();
    }

    @Override
    public Player findById(Long id) {
        return playerRepository.getOne(id);
    }

    @Override
    public void add(Player player) {
        playerRepository.save(player);
    }

    @Override
    public List<PlayerLikeDto> find4mostlikedplayers() {
        return  playerRepository.findmostlikedplayers()
                .stream()
                .map(player -> new PlayerLikeDto(player.getCounter(), player.getId(), player.getFirstName(), player.getLastName()))
                .collect(Collectors.toList());
    }
public String getPlayerByUser() {return playerRepository.getPlayerByUser(SecurityUtils.username());}

}
