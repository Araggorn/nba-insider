package pl.coderslab.nbainsider.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import pl.coderslab.nbainsider.entity.Player;
import pl.coderslab.nbainsider.entity.Team;
import pl.coderslab.nbainsider.service.PlayerService;
import pl.coderslab.nbainsider.service.TeamService;
import pl.coderslab.nbainsider.service.UserService;

@Controller
public class MainPageController {
    TeamService teamService;
    PlayerService playerService;
    UserService userService;

    @Autowired
    public MainPageController(UserService userService, TeamService teamService, PlayerService playerService) {
        this.teamService = teamService;
        this.playerService = playerService;
        this.userService = userService;
    }
    @GetMapping("/main")
    public String list(Model model) {
//        List<TeamLikeDto> teams = teamService.find4mostlikedteams();
//        model.addAttribute("teams", teams);
//        List<PlayerLikeDto> players = playerService.find4mostlikedplayers();
//        model.addAttribute("players", players);
        Team favteam = teamService.getTeamByUsers();
        model.addAttribute("favteam", favteam);
        String favplaya = playerService.getPlayerByUser();
        Player player = playerService.getPlayerFullInfoByUser();
        model.addAttribute("favplaya", favplaya);
        Long howmany = teamService.count(favteam.getId());
        model.addAttribute("howmany", howmany);
        Long howManyP = playerService.countUsersThatLikeMyFavouritePlayer(player.getId());
        model.addAttribute("howmanyP", howManyP);
        return "main";
    }

//    @PostMapping("/main")
//    public String add(User user, Model model) {
//     //   userService.save(user);
//        return "redirect:/users";
//    }


}
