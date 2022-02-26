package com.nate.peppermint.controllers;

import javax.servlet.http.HttpSession;

import com.nate.peppermint.models.User;
import com.nate.peppermint.services.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PeppermintController {

    @Autowired
    private UserService userService;

    @GetMapping("/dashboard")
    public String dashboard(HttpSession sesh, Model model) {
        // retrieve from DB the session id
        Long userId = (Long) sesh.getAttribute("user_id");
        // check if userID !null
        if (userId == null) {
            return "redirect:/";
        } else {
            User loggedInUser = userService.findOne(userId);
            model.addAttribute("loggedInUser", loggedInUser);
            return "dashboard.jsp";
        }
    }
    // Expense
    @GetMapping("/form/expenses")
    public String investmentForms(HttpSession sesh, Model model) {
        Long userId = (Long) sesh.getAttribute("user_id");
        if (userId == null) {
            return "redirect:/";
        } else {
            User loggedInUser = userService.findOne(userId);
            model.addAttribute("loggedInUser", loggedInUser);
            return "editExpenses.jsp";
        }
    }

    @GetMapping("/form/investments")
    public String forms(HttpSession sesh, Model model) {
        Long userId = (Long) sesh.getAttribute("user_id");
        if (userId == null) {
            return "redirect:/";
        } else {
            User loggedInUser = userService.findOne(userId);
            model.addAttribute("loggedInUser", loggedInUser);
            return "editInvestments.jsp";
        }
    }
}
