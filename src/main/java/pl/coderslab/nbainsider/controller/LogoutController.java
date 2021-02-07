package pl.coderslab.nbainsider.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import pl.coderslab.nbainsider.entity.User;
import pl.coderslab.nbainsider.service.UserService;

@Controller
public class LogoutController {

    private final UserService userService;

    @Autowired
    public LogoutController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping("/logout")
    public String form(Model model) {
        model.addAttribute("user", new User());
        return "redirect:/";
    }
}
