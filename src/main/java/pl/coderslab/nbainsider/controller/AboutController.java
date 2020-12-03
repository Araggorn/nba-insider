package pl.coderslab.nbainsider.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import pl.coderslab.nbainsider.entity.User;

@Controller
public class AboutController {
    @GetMapping("/about")
    public String about() {
        return "about";
    }
}
