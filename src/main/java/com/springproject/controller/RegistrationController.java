package com.springproject.controller;

import com.springproject.model.User;
import com.springproject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Path;
import java.security.Principal;
import java.util.List;


@Controller
public class RegistrationController {
    private Path path;
    @Autowired
    private UserService userService;

    @RequestMapping("/register")
    public String registerCustomer(Model model, Principal activeUser) {

        String register;
        User user = new User();

        model.addAttribute("user", user);

        if (activeUser == null) {
            register = "register";
        } else {
            register = "redirect:/home";

        }

        return register;
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String registerCustomerPost(@ModelAttribute("user") User user, BindingResult result,
                                       HttpServletRequest request, Model model) {
        if (result.hasErrors()) {
            return "register";
        }
        List<User> userList = userService.getUserList();
        for (int i = 0; i < userList.size(); i++) {
            if (user.getUserEmail().equals(userList.get(i).getUserEmail())) {
                model.addAttribute("emailMsg", "Email already exists");
                return "register";
            }
            if (user.getUsername().equals(userList.get(i).getUsername())) {
                model.addAttribute("usernameMsg", "Username already exists");
                return "register";
            }
        }
        userService.addUser(user);
        return "redirect:/home";
    }

}