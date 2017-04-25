package com.springproject.controller;

import com.springproject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.Principal;

@Controller
public class LogController {
    @Autowired
    private UserService userSeervice;

    @RequestMapping("/")
    public String index() {
        return "redirect:/home";
    }


    @RequestMapping("/home")
    public String doneJSP() {
        return "redirect:/purchase";
    }

    @RequestMapping("/login")
    public String loginPage(@RequestParam(value = "error", required = false) String error,
                            @RequestParam(value = "logout", required = false) String logout, Model model, Principal activeUser) {

        String login;
        if (error != null) {
            model.addAttribute("error", "Invalid username or password");
        }
        if (logout != null) {
            model.addAttribute("msg", "You have been logout succesfully");
        }
        if (activeUser == null) {
            login = "login";
        } else {
            login = "redirect:/home";

        }
        return login;
    }

}
