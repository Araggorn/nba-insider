package pl.coderslab.nbainsider.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import pl.coderslab.nbainsider.app.SecurityUtils;
import pl.coderslab.nbainsider.dto.UserDto;
import pl.coderslab.nbainsider.dto.UserPrefDto;
import pl.coderslab.nbainsider.dto.UserPrefPlayerDto;
import pl.coderslab.nbainsider.entity.Player;
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
    public String changepreferences(Model model) {

        List<Team> teams = teamService.findAllTeams();
        model.addAttribute("teams", teams);
        UserPrefDto userPref = new UserPrefDto();
        if (userService.getByLogin(SecurityUtils.username()).getTeam() != null){
        userPref.setFavTeamId(userService.getByLogin(SecurityUtils.username()).getTeam().getId());}
        else userPref.setFavTeamId(null);
        model.addAttribute("userPref", userPref);

        List<Player> players = playerService.findAllPlayers();
        model.addAttribute("players", players);
        UserPrefPlayerDto userPrefPlayerDto = new UserPrefPlayerDto();
        if (userService.getByLogin(SecurityUtils.username()).getPlayer() != null){
        userPrefPlayerDto.setFavPlayerId(userService.getByLogin(SecurityUtils.username()).getPlayer().getId());}
        else userPrefPlayerDto.setFavPlayerId(null);
        model.addAttribute("userPrefPlayer", userPrefPlayerDto);
        return "change";
    }

    @PostMapping(path = "/change", params = {"favTeamId"})
    public String changepreferenc(UserPrefDto userPrefDto) {
        userService.updateTeam(userPrefDto.getFavTeamId());
        return "redirect:/change";
    }
    @PostMapping(path = "/change", params = {"favPlayerId"})
    public String changepreferences(UserPrefPlayerDto userPrefPlayerDto) {
        userService.updatePlayer(userPrefPlayerDto.getFavPlayerId());
        return "redirect:/change";
    }
}
