package ch.bbw.personenVerwaltung.controller;

import ch.bbw.personenVerwaltung.domain.Person;
import ch.bbw.personenVerwaltung.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class PersonController {
    private final PersonRepository personRepository;

    @Autowired
    public PersonController(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @GetMapping("/index")
    public String getAllPerson(Model model) {
        model.addAttribute("persons", personRepository.findAll());
        return "index";
    }

    @GetMapping("/signup")
    public String showSignUpForm(Person person) {
        return "new-person";
    }

    @PostMapping("/addperson")
    public String addPerson(@ModelAttribute Person person, Model model) {
        personRepository.save(person);
        return "redirect:/index";
    }

    @GetMapping("/edit/{id}")
    public String showUpdateForm(@PathVariable("id") long id, Model model) {
        Person person = personRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("User Id ist falsch: " + id));
        model.addAttribute("person", person);
        return "update-person";
    }

    @PostMapping("/update/{id}")
    public String updatePerson(@PathVariable("id") long id,@ModelAttribute Person person, Model model) {
        personRepository.save(person);
        return "redirect:/index";
    }

    @GetMapping("/delete/{id}")
    public String deletePerson(@PathVariable("id") long id, Model model) {
        Person person = personRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid person Id:" + id));
        personRepository.delete(person);

        return "redirect:/index";
    }
}
