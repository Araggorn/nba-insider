package pl.coderslab.nbainsider.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import pl.coderslab.nbainsider.dto.UserItemDto;
import pl.coderslab.nbainsider.entity.Contact;
import pl.coderslab.nbainsider.repository.ContactRepository;

import java.util.List;

@Controller
public class ContactListController {

    ContactRepository repository;

    public ContactListController(ContactRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/contactlist")
    public String list(Model model) {
        List<Contact> contact = repository.findAll();
        model.addAttribute("contact", contact);
        return "contactlist";
    }

    @GetMapping("/contactlist/delete/{id}")
    public String removeContact(@PathVariable Long id) {
        repository.deleteById(id);
        return "redirect:/contactlist";
    }
}
