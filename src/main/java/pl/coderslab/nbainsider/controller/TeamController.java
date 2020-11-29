package pl.coderslab.nbainsider.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import pl.coderslab.nbainsider.entity.Team;
import pl.coderslab.nbainsider.entity.User;
import pl.coderslab.nbainsider.service.TeamService;

import java.util.List;

@Controller
public class TeamController {
    private TeamService teamService;

    @Autowired
    public TeamController(TeamService teamService) {
        this.teamService = teamService;
    }

//    @GetMapping("/teamlist")
//    public String list(Model model) {
//        List<Team> teams = teamService.findAllTeams();
//        model.addAttribute("teams", teams);
//        return "teamlist";
//    }
}
