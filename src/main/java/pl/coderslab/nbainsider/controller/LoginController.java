package pl.coderslab.nbainsider.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import pl.coderslab.nbainsider.entity.User;
import pl.coderslab.nbainsider.service.UserService;

@Controller
public class LoginController {
    private UserService userService;

    @Autowired
    public LoginController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping("/login")
    public String form(Model model) {
        model.addAttribute("user", new User());
        return "login";
    }
    @PostMapping("/login")
    public String formx(Model model) {
        return "redirect:/teamlist";
    }
}
