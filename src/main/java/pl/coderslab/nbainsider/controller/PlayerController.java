package pl.coderslab.nbainsider.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import pl.coderslab.nbainsider.entity.Player;
import pl.coderslab.nbainsider.service.PlayerService;

import java.util.List;

@Controller
public class PlayerController {

    private static final String ADDED = "added";
    private final PlayerService playerService;

    @Autowired
    public PlayerController(PlayerService playerService) {
        this.playerService = playerService;
    }

    @GetMapping("/playerlist")
    public String list(Model model, @RequestParam( name = ADDED, required = false) Boolean added) {
        List<Player> players = playerService.findAllPlayers();
        model.addAttribute("players", players);
        model.addAttribute("player", new Player());
        model.addAttribute("addedGet", added);
        Long numberOfPlayers = playerService.countPlayers();
        model.addAttribute("numberOfPlayers", numberOfPlayers);
        return "playerlist";
    }

    @PostMapping("/playerlist")
    public String add(Player player, RedirectAttributes redirectAttributes) {
        boolean added = playerService.add(player);
        redirectAttributes.addAttribute(ADDED, added);
        return "redirect:/playerlist";
    }
}
