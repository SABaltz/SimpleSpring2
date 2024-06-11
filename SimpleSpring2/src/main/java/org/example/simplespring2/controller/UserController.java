package org.example.simplespring2.controller;
import org.example.simplespring2.model.User;
import org.example.simplespring2.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("users", userRepository.findAll());
        return "index";
    }

    @PostMapping("/add")
    public String addUser(@RequestParam String name, @RequestParam String email) {
        User user = new User();
        user.setName(name);
        user.setEmail(email);
        userRepository.save(user);
        return "redirect:/";
    }
}
