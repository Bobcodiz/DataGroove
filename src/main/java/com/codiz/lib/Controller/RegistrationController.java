package com.codiz.lib.Controller;

import com.codiz.lib.Model.User;
import com.codiz.lib.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RegistrationController {

    @Autowired
    private UserService userService;

    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("user", new User());
        return "registration";
    }

    @PostMapping("/register")
    public String registerUser(User user) {
        // Set the role based on your logic, e.g., based on user input
        user.setRole("USER");

        userService.createUser(user);
        return "redirect:/login";
    }
}
