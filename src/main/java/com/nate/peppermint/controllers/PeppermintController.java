package com.nate.peppermint.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import com.nate.peppermint.models.Goal;
import com.nate.peppermint.models.User;
import com.nate.peppermint.services.GoalService;
import com.nate.peppermint.services.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PutMapping;

@Controller
public class PeppermintController {

    @Autowired
    private UserService userService;

    @Autowired
    private GoalService goalService;

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

    // GOALS
    @GetMapping("/goals/new")
    public String goals(Model model, @ModelAttribute("goal") Goal goal, HttpSession session){
        List<Goal> goals = goalService.allGoals();
        model.addAttribute("goals", goals);
        return "goalForm.jsp";
    }

    @PutMapping("/goals/submit")
    public String createGoal(@Valid @ModelAttribute("goal") Goal goal, BindingResult result, Model model, HttpSession session){
        if(result.hasErrors()){
            List<Goal> goals = goalService.allGoals();
            model.addAttribute("goals", goals);
            return "goalForm.jsp";
        } else {
            goalService.createGoal(goal);
            return "redirect:/dashboard";
        }
    }

    // INVESTMENTS
    @GetMapping("/investments/new")
    public String investments(){
        return "investmentForm.jsp";
    }

    // BUDGETS
    @GetMapping("/budgets/new")
    public String budgets(){
        return "budgetForm.jsp";
    }
}
