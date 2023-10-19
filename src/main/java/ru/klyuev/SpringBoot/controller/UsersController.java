package ru.klyuev.SpringBoot.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.klyuev.SpringBoot.model.User;
import ru.klyuev.SpringBoot.service.UserService;



@Controller
@RequestMapping("/users")
public class UsersController {

    private final UserService userService;

    @Autowired
    public UsersController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping()
    public String index(Model model) {
        model.addAttribute("users", userService.index());
        return "users";
    }

    @GetMapping("/show")
    public String show(@RequestParam("id") long id, Model model) {
        model.addAttribute("user", userService.show(id));
        return "show";
    }

    @GetMapping("/new")
    public String newUser(@ModelAttribute("user") User user) {
        return "new";
    }

    @PostMapping("/create")
    public String create(@ModelAttribute("user") @Valid User user,
                         BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "new";
        }

        userService.save(user);
        return "redirect:/users";
    }

    @GetMapping("/edit")
    public String edit(Model model, @RequestParam("id") long id) {
        model.addAttribute("user", userService.show(id));
        return "edit";
    }

    @PatchMapping("/update")
    public String update(@ModelAttribute("user") @Valid User user, BindingResult bindingResult,
                         @RequestParam("id") long id) {
        if (bindingResult.hasErrors()) {
            return "edit";
        }

        userService.update(id, user);
        return "redirect:/users";
    }

    @DeleteMapping("/delete")
    public String delete(@RequestParam("id") long id) {
        userService.delete(id);
        return "redirect:/users";
    }
}