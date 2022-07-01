package ch.bbw.personenVerwaltung.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonController {

    @GetMapping("/")
    public String getAllPerson(Model model) {
        model.addAttribute("model", model);
        return "";
    }
}
