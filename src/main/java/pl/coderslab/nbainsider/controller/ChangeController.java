package pl.coderslab.nbainsider.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import pl.coderslab.nbainsider.app.SecurityUtils;
import pl.coderslab.nbainsider.dto.UserDto;
import pl.coderslab.nbainsider.entity.Team;
import pl.coderslab.nbainsider.entity.User;
import pl.coderslab.nbainsider.service.PlayerService;
import pl.coderslab.nbainsider.service.TeamService;
import pl.coderslab.nbainsider.service.UserService;

import java.util.List;

@Controller
public class ChangeController {
    TeamService teamService;
    PlayerService playerService;
    UserService userService;

    @Autowired
    public ChangeController(TeamService teamService, PlayerService playerService, UserService userService) {
        this.teamService = teamService;
        this.playerService = playerService;
        this.userService = userService;
    }




    @GetMapping("/change")
    public String changepreferences(Model model){
        List<Team> teams = teamService.findAllTeams();
        model.addAttribute("teams", teams);
        return "change";
    }
//    @PostMapping("/change")
//    public String changepreferences(User user) {
//        userService.getOne
//        String team.name  = SecurityContextHolder.getContext().getAuthentication();
//        return "redirect:/main";
//    }
}
