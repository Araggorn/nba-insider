package pl.coderslab.nbainsider.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.coderslab.nbainsider.entity.Player;
import pl.coderslab.nbainsider.repository.PlayerRepository;

import java.util.List;

@Service
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
}
