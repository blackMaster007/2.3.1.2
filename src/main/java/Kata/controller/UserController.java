package Kata.controller;

import Kata.models.User;
import Kata.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller

public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }


    @PostMapping("/users")
    public String createNewUser(@ModelAttribute("user") User user) {
        userService.add(user);
        return "redirect:/users";
    }

    @GetMapping("/users/new")
    public String newUser(@ModelAttribute("user") User user) {
        return "/new";
    }

    @GetMapping("/users")
    public String showUsers(Model model) {
        model.addAttribute("users", userService.listUsers());
        return "/users";
    }

    @GetMapping(value = "/users/{id}")
    public String showUser(Model model, @PathVariable("id") Long id) {
        model.addAttribute("user", userService.showUser(id));
        return "/user";
    }

    @GetMapping("/users/{id}/edit")
    public String edit(Model model, @PathVariable("id") Long id) {
        model.addAttribute("user", userService.showUser(id));
        return "/edit";
    }

    @DeleteMapping("/users/{id}")
    public String delete(@PathVariable("id") Long id) {
        userService.remove(id);
        return "redirect:/users";
    }

    @PatchMapping("/users/{id}")
    public String update(@ModelAttribute("user") User user, @PathVariable("id") Long id) {
        userService.update(id, user);
        return "redirect:/users";
    }

}
