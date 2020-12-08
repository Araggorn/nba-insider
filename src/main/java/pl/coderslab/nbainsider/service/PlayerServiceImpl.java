package pl.coderslab.nbainsider.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.coderslab.nbainsider.app.SecurityUtils;
import pl.coderslab.nbainsider.dto.PlayerLikeDto;
import pl.coderslab.nbainsider.entity.Player;
import pl.coderslab.nbainsider.repository.PlayerRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@Slf4j
public class PlayerServiceImpl implements PlayerService {

    private final PlayerRepository playerRepository;
    private final PlayerDataService playerDataService;

    @Autowired
    public PlayerServiceImpl(PlayerRepository playerRepository, PlayerDataService playerDataService) {
        this.playerRepository = playerRepository;
        this.playerDataService = playerDataService;
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
        if (playerDataService.checkIfPlayerExists(player.getFirstName(), player.getLastName())) {
            playerRepository.save(player);
        } else {
            log.info("Player not found");
        }
    }

    @Override
    public List<PlayerLikeDto> find4mostlikedplayers() {
        return playerRepository.findmostlikedplayers()
                .stream()
                .map(player -> new PlayerLikeDto(player.getCounter(), player.getId(), player.getFirstName(), player.getLastName()))
                .collect(Collectors.toList());
    }

    public String getPlayerByUser() {
        return playerRepository.getPlayerByUser(SecurityUtils.username());
    }

    @Override
    public Player getPlayerFullInfoByUser() {
        return playerRepository.getPlayerFullInfoByUser(SecurityUtils.username());
    }

}
