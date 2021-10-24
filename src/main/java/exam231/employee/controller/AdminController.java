package exam231.employee.controller;

import exam231.employee.model.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import exam231.employee.model.User;
import exam231.employee.service.UserService;

import java.security.Principal;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Controller
@RequestMapping("/admin")
public class AdminController {

    private final UserService userService;

    public AdminController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String allUsers(Model model) {
        List<User> users = userService.allUsers();
        List<Role> roles = userService.allRoles();
        model.addAttribute("usersList", users);
        model.addAttribute("roles", roles);
        return "users";
    }

    @GetMapping("/add")
    public String createUser(Model model) {
        model.addAttribute("user", new User());
        model.addAttribute("roleAdmin", null);
        return "createUser";
    }

    @PostMapping
    public String addUser(@ModelAttribute(value = "roleAdmin") String roleAdmin,
                          @ModelAttribute("user") User user) {
        Set<Role> setRole = new HashSet<>();
        if (roleAdmin.contains("on")) {
            setRole.add(userService.allRoles().get(1));
            setRole.add(userService.allRoles().get(0));
        } else {
            setRole.add(userService.allRoles().get(1));
        }
        user.setRoles(setRole);
        userService.addUser(user);
        return "redirect:/admin";
    }

    @GetMapping("/edit/{id}")
    public String editPage(Model model, @PathVariable("id") int id) {
        User user = userService.getById(id);
        model.addAttribute("user", user);
        return "editPage";
    }

    @PatchMapping
    public String editUser(@ModelAttribute("user") User user) {
        userService.editUser(user);
        return "redirect:/admin";
    }

    @PostMapping("/delete/{id}")
    public String deleteUser(@PathVariable("id") int id) {
        userService.removeUser(id);
        return "redirect:/admin";
    }
}