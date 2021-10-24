package exam231.employee.controller;

import exam231.employee.model.User;
import exam231.employee.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.security.Principal;

@Controller
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @RequestMapping(value = "login", method = RequestMethod.GET)
    public String loginPage() {
        return "login";
    }

    @GetMapping("user")
    public String user(Model model, Principal principal) {
        User user = userService.findByUsername(principal.getName());
        model.addAttribute("user", user);
        return "user";
    }

}
