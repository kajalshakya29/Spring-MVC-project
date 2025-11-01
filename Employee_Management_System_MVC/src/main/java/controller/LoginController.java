package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import service.UserService;

@Controller
public class LoginController {

    @Autowired
    private UserService userService;

    @GetMapping("/")
    public String showLogin() {
        return "login";
    }

    @PostMapping("/login")
    public ModelAndView login(@RequestParam String username, @RequestParam String password) {
        ModelAndView mv = new ModelAndView();
        if (userService.checkLogin(username, password)) {
            mv.setViewName("redirect:/list");
        } else {
            mv.addObject("error", "Invalid Credentials");
            mv.setViewName("login");
        }
        return mv;
    }
}
