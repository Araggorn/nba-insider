package pl.coderslab.nbainsider.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import pl.coderslab.nbainsider.dto.PlayerLikeDto;
import pl.coderslab.nbainsider.dto.TeamLikeDto;
import pl.coderslab.nbainsider.service.PlayerService;
import pl.coderslab.nbainsider.service.TeamService;

import java.util.List;

@Controller
public class TopController {
    TeamService teamService;
    PlayerService playerService;

    @Autowired
    public TopController(TeamService teamService, PlayerService playerService) {
        this.teamService = teamService;
        this.playerService = playerService;
    }

    @GetMapping("/top")
    public String list(Model model) {
        List<TeamLikeDto> teams = teamService.find4mostlikedteams();
        model.addAttribute("teams", teams);
        List<PlayerLikeDto> players = playerService.find4mostlikedplayers();
        model.addAttribute("players", players);
        return "top";
    }
}
