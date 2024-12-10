package application.controller;

import application.model.User;
import application.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/users")

public class UsersController {

    @Autowired
    private UserService userService;

    @GetMapping
    public String users(ModelMap model) {
        List<User> users = userService.findAll();
        model.addAttribute("users", users);
        return "users";
    }

    @PostMapping
    public String addUser(@ModelAttribute("user") User user) {
        userService.create(user);
        return "redirect:/users";
    }

    @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable("id") long id) {
        userService.delete(id);
        return "redirect:/users";
    }

    @GetMapping("/edit/{id}")
    public String editUser(@PathVariable("id") long id, ModelMap model) {
        User user = userService.findById(id);
        model.addAttribute("user", user);
        return "usersEdit";
    }

    @PatchMapping("/update")
    public String updateUser(@ModelAttribute User user) {
        userService.create(user);
        return "redirect:/users";
    }
}
