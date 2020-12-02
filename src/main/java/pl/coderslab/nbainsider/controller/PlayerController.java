package pl.coderslab.nbainsider.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import pl.coderslab.nbainsider.entity.Player;
import pl.coderslab.nbainsider.entity.User;
import pl.coderslab.nbainsider.service.PlayerService;

import java.util.List;

@Controller
public class PlayerController {

    PlayerService playerService;

    @Autowired
    public PlayerController(PlayerService playerService) {
        this.playerService = playerService;
    }

    @GetMapping("/playerlist")
    public String list(Model model) {
        List<Player> players = playerService.findAllPlayers();
        model.addAttribute("players", players);
        model.addAttribute("player", new Player());
        return "playerlist";
    }

    @PostMapping("/playerlist")
    public String add(Player player) {
        playerService.add(player);
        return "redirect:/playerlist";
    }
}
