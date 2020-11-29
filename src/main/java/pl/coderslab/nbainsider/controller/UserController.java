package pl.coderslab.nbainsider.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.nbainsider.entity.User;
import pl.coderslab.nbainsider.service.UserService;

import java.util.List;

@Controller
public class UserController {
    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/userslist")
    public String list(Model model) {
        List<User> users = userService.findAllUsers();
        model.addAttribute("users", users);
        return "list";
    }

    @GetMapping("/registration")
    public String form(Model model) {
        model.addAttribute("user", new User());
        return "registration";
    }

    @PostMapping("/registration")
    public String add(User user, Model model) {
        userService.add(user);
        return "redirect:/users";
    }

    @GetMapping("/form/{id}")
    public String updateBook(@PathVariable Long id, Model model) {
        User user = userService.findById(id);
        model.addAttribute(user);
        return "form";
    }


    @GetMapping("/delete/{id}")
    public String removeBook(@PathVariable Long id) {
        userService.delete(id);
        return "redirect:/user";
    }
}
