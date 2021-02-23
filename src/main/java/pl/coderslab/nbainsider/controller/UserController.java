package pl.coderslab.nbainsider.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import pl.coderslab.nbainsider.dto.UserDto;
import pl.coderslab.nbainsider.dto.UserItemDto;
import pl.coderslab.nbainsider.entity.User;
import pl.coderslab.nbainsider.service.UserService;

import javax.validation.Valid;
import java.util.List;

@Controller
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/userlist")
    public String list(Model model) {
        List<UserItemDto> users = userService.find2all();
        model.addAttribute("users", users);
        return "userslist";
    }

    @GetMapping("/registration")
    public String form(Model model) {
        model.addAttribute("user", new UserDto());
        return "registration";
    }

    @PostMapping("/registration")
    public String add(@Valid @ModelAttribute("user") UserDto user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "registration";
        }
        userService.add(user);
        return "redirect:/login";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Long id, Model model) {
        User user1 = userService.findById(id);
        UserDto user = new UserDto(user1.getId(), user1.getLogin(), user1.getPassword(), user1.getEmail());
        model.addAttribute("user", user);
        return "edit";
    }

    @PostMapping("/edit")
    public String addedit(UserDto user) {
        userService.update(user);
        return "redirect:/userlist";
    }


    @GetMapping("/user/delete/{id}")
    public String removeUser(@PathVariable Long id) {
        userService.delete(id);
        return "redirect:/userlist";
    }
}
