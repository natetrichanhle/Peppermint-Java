package com.nate.peppermint.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import com.nate.peppermint.models.Budget;
import com.nate.peppermint.models.Goal;
import com.nate.peppermint.models.Investment;
import com.nate.peppermint.models.Month;
import com.nate.peppermint.models.SavingsAccount;
import com.nate.peppermint.models.User;
import com.nate.peppermint.services.BudgetService;
import com.nate.peppermint.services.GoalService;
import com.nate.peppermint.services.InvestmentService;
import com.nate.peppermint.services.MonthService;
import com.nate.peppermint.services.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

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

    @Autowired
    private MonthService monthService;

    @GetMapping("/landing")
    public String landing(HttpSession sesh, Model model) {
        Long userId = (Long) sesh.getAttribute("user_id");
        // check if userID
        if (userId == null ) {
            return "redirect:/";
        }else {
            User loggedInUser = userService.findOne(userId);
            model.addAttribute("loggedInUser", loggedInUser);
            return "landing.jsp";
        }
    }

    @GetMapping("/dashboard/{id}")
    public String dashboard(HttpSession sesh, Model model, @PathVariable("id") Long id) {
        // retrieve from DB the session id
        Long userId = (Long) sesh.getAttribute("user_id");
        sesh.setAttribute("monthId", id);
        // check if userID !null
        Month month = monthService.findMonth(id);
        model.addAttribute("month", month);
        if (userId == null || !month.getUser().getId().equals(userId)) {
            return "redirect:/landing";
        } else {
            User loggedInUser = userService.findOne(userId);
            model.addAttribute("loggedInUser", loggedInUser);
            double monthlyTotal = (double) month.getMonthlyTotal();
            int roundedTotal = (int) monthlyTotal;
            model.addAttribute("monthlyTotal", roundedTotal);
            double savingsTotal = (double) month.getSavings().getTotal();
            int roundedSavingsTotal = (int) savingsTotal;
            model.addAttribute("savingsTotal", roundedSavingsTotal);
            double investmentTotal = (double) month.getInvestment().getTotalInvestments();
            int roundedInvestmentTotal = (int) investmentTotal;
            model.addAttribute("investmentTotal", roundedInvestmentTotal);
            double utilitiesTotal = (double) (month.getSavings().getTotal()
            - month.getInvestment().getTotalInvestments());
            int roundedUtilitiesTotal = (int) utilitiesTotal;
            model.addAttribute("utilitiesTotal", roundedUtilitiesTotal);
            double rothIraTotal = (double) (month.getInvestment().getTotalInvestments() * month.getInvestment().getRothIraAmount()) / 100 ;
            int roundedRothIraTotal = (int) rothIraTotal;
            model.addAttribute("rothIraTotal", roundedRothIraTotal);
            double cryptoTotal = (double) (month.getInvestment().getTotalInvestments() * month.getInvestment().getCryptoAmount()) / 100 ;
            int roundedCryptoTotal = (int) cryptoTotal;
            model.addAttribute("cryptoTotal", roundedCryptoTotal);
            double stocksTotal = (double) (month.getInvestment().getTotalInvestments() * month.getInvestment().getStocksAmount()) / 100 ;
            int roundedStocksTotal = (int) stocksTotal;
            model.addAttribute("stocksTotal", roundedStocksTotal);
            return "dashboard.jsp";
        }
    }

    // GOALS -------------------------------------------------------
    @GetMapping("/goals/new/")
    public String goals(Model model, @ModelAttribute("goal") Goal goal, HttpSession session){
        // Route Guard
        Long userId = (Long) session.getAttribute("user_id");
        // check if userId is null
        if(userId == null){
            return "redirect:/";
        } else {
            User thisLoggedInUser = userService.findOne(userId);
            model.addAttribute("thisLoggedInUser",thisLoggedInUser);
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
            return "redirect:/dashboard/" + session.getAttribute("monthId");
        }
    }

    @DeleteMapping("/goals/{id}")
	public String destroyGoal(@PathVariable("id") Long id, HttpSession session) {
		goalService.deleteGoal(id);
		return "redirect:/dashboard/" + session.getAttribute("monthId");
	}

    // INVESTMENTS -------------------------------------------------------
    @GetMapping("/investments/new")
    public String investments(Model model, HttpSession session){
        // Route Guard
        Long userId = (Long) session.getAttribute("user_id");
        // check if userId is null
        if(userId == null){
            return "redirect:/";
        } else {
            Long monthId = (Long) session.getAttribute("monthId");
            Month thisMonth = monthService.findMonth(monthId);
            model.addAttribute("thisMonth", thisMonth);
            model.addAttribute("monthId",monthId);
            Investment thisInvestmentAccount = investmentService.findInvestment(monthId);
            model.addAttribute("investment", thisInvestmentAccount);
            User thisLoggedInUser = userService.findOne(userId);
            model.addAttribute("thisLoggedInUser",thisLoggedInUser);
            return "investmentForm.jsp";
        }
    }

    @PutMapping("/investments/submit/{id}")
    public String createInvestment(@Valid @ModelAttribute("investment") Investment investment, BindingResult result, Model model, HttpSession session){
        if(investment.getRothIraAmount() + investment.getStocksAmount() + investment.getCryptoAmount() != 100){
			result.addError(new ObjectError("stocksAmount", "Values must equal 100"));
		}
        if(result.hasErrors()){
            Long userId = (Long) session.getAttribute("user_id");
            User thisLoggedInUser = userService.findOne(userId);
            model.addAttribute("thisLoggedInUser",thisLoggedInUser);
            // All investments
            List<Investment> investments = investmentService.allInvestments();
            model.addAttribute("investments", investments);
            System.out.println(result);
            return "investmentForm.jsp";
        } else {
            investmentService.createInvestment(investment);
            return "redirect:/dashboard/" + session.getAttribute("monthId");
        }
    }

    // BUDGETS -------------------------------------------------------
    @GetMapping("/budgets/new")
    public String budgets(Model model, @ModelAttribute("budget") Budget budget, HttpSession session){
        // Route Guard
        Long userId = (Long) session.getAttribute("user_id");
        // check if userId is null
        if(userId == null){
            return "redirect:/";
        } else {
            User thisLoggedInUser = userService.findOne(userId);
            model.addAttribute("thisLoggedInUser",thisLoggedInUser);
            return "budgetForm.jsp";
        }
    }

    @PostMapping("/budgets/submit")
    public String createBudget(@Valid @ModelAttribute("budget") Budget budget, BindingResult result, Model model, HttpSession session){
        if(result.hasErrors()){
            Long userId = (Long) session.getAttribute("user_id");
            User thisLoggedInUser = userService.findOne(userId);
            model.addAttribute("thisLoggedInUser",thisLoggedInUser);
            // All Budgets
            List<Budget> budgets = budgetService.allBudgets();
            model.addAttribute("budgets", budgets);
            return "budgetForm.jsp";
        } else {
            Long monthId = (Long) session.getAttribute("monthId");
            Month month = monthService.findMonth(monthId);
            SavingsAccount thisSavingsAccount = month.getSavings();
            System.out.println(thisSavingsAccount);
            budgetService.createBudget(budget, thisSavingsAccount);
            return "redirect:/dashboard/" + session.getAttribute("monthId");
        }
    }

    @DeleteMapping("/budgets/{id}")
	public String destroyBudget(@PathVariable("id") Long id, HttpSession session) {
        Long monthId = (Long) session.getAttribute("monthId");
        Month month = monthService.findMonth(monthId);
		budgetService.deleteBudget(id, month.getSavings());
		return "redirect:/dashboard/" + session.getAttribute("monthId");
	}
}
