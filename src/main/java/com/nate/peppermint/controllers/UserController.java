package com.nate.peppermint.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import com.nate.peppermint.models.LoginUser;
import com.nate.peppermint.models.User;
import com.nate.peppermint.services.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {
    
    @Autowired
    private UserService userService;

    // implement a welcome page later
    @GetMapping("/")
    public String welcome(){
        return "welcomePage.jsp";
    }
    // Login
    @GetMapping("/loginReg")
    public String loginReg(Model model){
        model.addAttribute("newUser", new User());
        model.addAttribute("newLogin", new LoginUser());
        return "userForm.jsp";
    }

    // Register new user
    @PostMapping("/register")
    public String register(@Valid @ModelAttribute("newUser") User newUser, BindingResult result, Model model, HttpSession session){
        // executing service
        userService.register(newUser, result);
        // then check errors
        if(result.hasErrors()){
            model.addAttribute("newLogin", new LoginUser());
            return "userForm.jsp";
        } else {
            session.setAttribute("user_id", newUser.getId());
            return "redirect:/landing";
        }
    }

    // login
    @PostMapping("/login")
    public String login(@Valid @ModelAttribute("newLogin") LoginUser newLogin, BindingResult result, Model model, HttpSession session){
        User user = userService.login(newLogin, result);
        if(result.hasErrors()){
            model.addAttribute("newUser", new User());
            return "userForm.jsp";
        } else {
            session.setAttribute("user_id", user.getId());
            return "redirect:/landing";
        }
    }

    @GetMapping("/logout")
    public String logout(HttpSession session){
        session.invalidate();
        return "redirect:/loginReg";
    }

}


