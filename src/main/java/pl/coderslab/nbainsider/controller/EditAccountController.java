package pl.coderslab.nbainsider.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import pl.coderslab.nbainsider.app.SecurityUtils;
import pl.coderslab.nbainsider.dto.UserDto;
import pl.coderslab.nbainsider.entity.User;
import pl.coderslab.nbainsider.service.UserService;

@Controller
public class EditAccountController {
    private final UserService userService;


    @Autowired
    public EditAccountController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/editaccount")
    public String edit(Model model) {
        User user1 = userService.getByLogin(SecurityUtils.username());
        UserDto user = new UserDto(user1.getId(), user1.getLogin(), user1.getPassword(), user1.getEmail());
        model.addAttribute("user", user);
        return "editaccount";
    }

    @PostMapping("/editaccount")
    public String addedit(UserDto user) {
        userService.update(user);
        return "redirect:/logout";
    }
}
