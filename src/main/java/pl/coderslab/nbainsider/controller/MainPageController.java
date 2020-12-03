package pl.coderslab.nbainsider.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.nbainsider.dto.TeamLikeDto;
import pl.coderslab.nbainsider.entity.Team;
import pl.coderslab.nbainsider.entity.User;
import pl.coderslab.nbainsider.service.TeamService;
import pl.coderslab.nbainsider.service.UserService;

import java.util.List;

@Controller
public class MainPageController {
    TeamService teamService;
    UserService userService;

    @Autowired
    public MainPageController(TeamService teamService, UserService userService) {
        this.teamService = teamService;
        this.userService = userService;
    }
    @GetMapping("/main")
    public String list(Model model) {
        List<TeamLikeDto> teams = teamService.find4mostlikedteams();
        model.addAttribute("teams", teams);
        return "main";
    }

//    @PostMapping("/main")
//    public String add(User user, Model model) {
//     //   userService.save(user);
//        return "redirect:/users";
//    }


}
