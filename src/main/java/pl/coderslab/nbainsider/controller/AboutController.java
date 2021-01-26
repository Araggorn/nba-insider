package pl.coderslab.nbainsider.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import pl.coderslab.nbainsider.dto.UserDto;
import pl.coderslab.nbainsider.entity.Contact;
import pl.coderslab.nbainsider.entity.Player;
import pl.coderslab.nbainsider.entity.User;
import pl.coderslab.nbainsider.repository.ContactRepository;

import javax.validation.Valid;
import java.util.List;

@Controller
public class AboutController {

    private final ContactRepository repository;

    public AboutController(ContactRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/about")
    public String about(Model model) {
        Long numberOfContacts = repository.count();
        model.addAttribute("numberOfMesseges", numberOfContacts);
        model.addAttribute("contact", new Contact());
        return "about";
    }

    @PostMapping("/about")
    public String add(@Valid @ModelAttribute("contact") Contact contact, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {return "about";}
        repository.save(contact);
        return "redirect:/main";
}}
