package pl.coderslab.nbainsider.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import pl.coderslab.nbainsider.dto.TeamLikeDto;
import pl.coderslab.nbainsider.service.TeamService;

import java.util.List;

@Controller
public class NotLikedTeamsController {

    TeamService teamService;

    public NotLikedTeamsController(TeamService teamService) {
        this.teamService = teamService;
    }

    @GetMapping("/leastlike")
    public String list(Model model) {
        List<TeamLikeDto> teams = teamService.findleastlikedteams();
        model.addAttribute("teams", teams);
        return "leastlike";
    }


}
