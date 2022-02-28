package com.nate.peppermint.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import com.nate.peppermint.models.Budget;
import com.nate.peppermint.models.Goal;
import com.nate.peppermint.models.Investment;
import com.nate.peppermint.models.User;
import com.nate.peppermint.services.BudgetService;
import com.nate.peppermint.services.GoalService;
import com.nate.peppermint.services.InvestmentService;
import com.nate.peppermint.services.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
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
            List<Goal> goals = goalService.allGoals();
            model.addAttribute("goalsList",goals);
            List<Investment> investments = investmentService.allInvestments();
            model.addAttribute("investmentsList",investments);
            List<Budget> budgets = budgetService.allBudgets();
            model.addAttribute("budgetsList",budgets);
            return "dashboard.jsp";
        }
    }
    // Expense
    @GetMapping("/form/expenses")
    public String GoalForms(HttpSession sesh, Model model) {
        Long userId = (Long) sesh.getAttribute("user_id");
        if (userId == null) {
            return "redirect:/";
        } else {
            User loggedInUser = userService.findOne(userId);
            model.addAttribute("loggedInUser", loggedInUser);
            return "editExpenses.jsp";
        }
    }

    @GetMapping("/form/Goals")
    public String forms(HttpSession sesh, Model model) {
        Long userId = (Long) sesh.getAttribute("user_id");
        if (userId == null) {
            return "redirect:/";
        } else {
            User loggedInUser = userService.findOne(userId);
            model.addAttribute("loggedInUser", loggedInUser);
            return "editGoals.jsp";
        }
    }

    // GOALS
    @GetMapping("/goals/new")
    public String goals(Model model, @ModelAttribute("goal") Goal goal, HttpSession session){
        List<Goal> goals = goalService.allGoals();
        model.addAttribute("goals", goals);
        return "goalForm.jsp";
    }

    @PostMapping("/goals/submit")
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
    public String createBudget(@Valid @ModelAttribute("budget") Budget budget, BindingResult result, Model model, HttpSession session){
        if(result.hasErrors()){
            List<Budget> budgets = budgetService.allBudgets();
            model.addAttribute("budgets", budgets);
            return "budgetForm.jsp";
        } else {
            budgetService.createBudget(budget);
            return "redirect:/dashboard";
        }
    }
}
