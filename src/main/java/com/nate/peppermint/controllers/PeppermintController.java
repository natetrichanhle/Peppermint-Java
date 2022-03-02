package com.nate.peppermint.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import com.nate.peppermint.models.Budget;
import com.nate.peppermint.models.Goal;
import com.nate.peppermint.models.Investment;
import com.nate.peppermint.models.SavingsAccount;
import com.nate.peppermint.models.User;
import com.nate.peppermint.services.BudgetService;
import com.nate.peppermint.services.GoalService;
import com.nate.peppermint.services.InvestmentService;
import com.nate.peppermint.services.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class PeppermintController {

    @Autowired
    private UserService userService;

    @Autowired
    private GoalService goalService;

    @Autowired
    private InvestmentService investmentService;

    @Autowired
    private BudgetService budgetService;

    @GetMapping("/dashboard/id")
    public String dashboard(HttpSession sesh, Model model) {
        // retrieve from DB the session id
        Long userId = (Long) sesh.getAttribute("user_id");
        // check if userID !null
        if (userId == null || !moth.getUser().getId().equals(userId)) {
            return "redirect:/";
        } else {
            User loggedInUser = userService.findOne(userId);
            model.addAttribute("loggedInUser", loggedInUser);
            List<Goal> goals = goalService.allGoals();
            model.addAttribute("goalsList",goals);
            List<Investment> investments = investmentService.allInvestments();
            model.addAttribute("investmentsList",investments);
            List<Budget> budgets = budgetService.allBudgets();
            model.addAttribute("budgetsList",budgets);
            return "dashboard.jsp";
        }
    }

    // GOALS
    @GetMapping("/goals/new")
    public String goals(Model model, @ModelAttribute("goal") Goal goal, HttpSession session){
        // Route Guard
        Long userId = (Long) session.getAttribute("user_id");
        // check if userId is null
        if(userId == null){
            return "redirect:/";
        } else {
            User thisLoggedInUser = userService.findOne(userId);
            model.addAttribute("thisLoggedInUser",thisLoggedInUser);
            List<Goal> goals = goalService.allGoals();
            model.addAttribute("goals", goals);
            return "goalForm.jsp";
        }
    }

    @PostMapping("/goals/submit")
    public String createGoal(@Valid @ModelAttribute("goal") Goal goal, BindingResult result, Model model, HttpSession session){
        if(result.hasErrors()){
            // grab the user again
            Long userId = (Long) session.getAttribute("user_id");
            User thisLoggedInUser = userService.findOne(userId);
            model.addAttribute("thisLoggedInUser",thisLoggedInUser);
            // All the Goals
            List<Goal> goals = goalService.allGoals();
            model.addAttribute("goals", goals);
            return "goalForm.jsp";
        } else {
            goalService.createGoal(goal);
            return "redirect:/dashboard";
        }
    }

    @DeleteMapping("/goals/{id}")
	public String destroyGoal(@PathVariable("id") Long id) {
		goalService.deleteGoal(id);
		return "redirect:/dashboard";
	}

    // INVESTMENTS
    @GetMapping("/investments/new")
    public String investments(Model model, @ModelAttribute("investment") Investment investment, HttpSession session){
        List<Investment> investments = investmentService.allInvestments();
        model.addAttribute("investments", investments);
        return "investmentForm.jsp";
    }

    @PostMapping("/investments/submit")
    public String createInvestment(@Valid @ModelAttribute("investment") Investment investment, BindingResult result, Model model, HttpSession session){
        if(result.hasErrors()){
            List<Investment> investments = investmentService.allInvestments();
            model.addAttribute("investments", investments);
            return "investmentForm.jsp";
        } else {
            investmentService.createInvestment(investment);
            return "redirect:/dashboard";
        }
    }

    // BUDGETS
    @GetMapping("/budgets/new")
    public String budgets(Model model, @ModelAttribute("budget") Budget budget, HttpSession session){
        List<Budget> budgets = budgetService.allBudgets();
        model.addAttribute("budgets", budgets);
        return "budgetForm.jsp";
    }

    @PostMapping("/budgets/submit")
    public String createBudget(@Valid @ModelAttribute("budget") Budget budget,SavingsAccount savingsAccount, BindingResult result, Model model, HttpSession session){
        if(result.hasErrors()){
            List<Budget> budgets = budgetService.allBudgets();
            model.addAttribute("budgets", budgets);
            return "budgetForm.jsp";
        } else {
            budgetService.createBudget(budget, savingsAccount);
            return "redirect:/dashboard";
        }
    }

    @DeleteMapping("/budgets/{id}")
	public String destroyBudget(@PathVariable("id") Long id, SavingsAccount savingsAccount) {
		budgetService.deleteBudget(id, savingsAccount);
		return "redirect:/dashboard";
	}
}
