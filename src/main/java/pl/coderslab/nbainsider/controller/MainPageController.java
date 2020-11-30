package pl.coderslab.nbainsider.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.nbainsider.entity.Team;
import pl.coderslab.nbainsider.entity.User;
import pl.coderslab.nbainsider.service.TeamService;
import pl.coderslab.nbainsider.service.UserService;

import java.util.List;

@Controller
@RequestMapping("/main")
public class MainPageController {
    TeamService teamService;
    UserService userService;

    @Autowired
    public MainPageController(TeamService teamService, UserService userService) {
        this.teamService = teamService;
        this.userService = userService;
    }
    @GetMapping("/login")
    public String list(Model model) {
        List<Team> teams3 = teamService.find3mostlikedteams();
        model.addAttribute("teams", teams3);
        User user = new User();
        model.addAttribute("user", user);
        return "main";
    }

    @PostMapping("/login")
    public String add(User user, Model model) {
        userService.add(user);
        return "redirect:/users";
    }


}
