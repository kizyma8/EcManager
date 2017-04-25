package com.springproject.controller;

import com.springproject.model.PurchasePanel;
import com.springproject.model.User;
import com.springproject.service.PurchaseService;
import com.springproject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Path;
import javax.validation.Valid;
import java.security.Principal;
import java.util.List;

@Controller
public class PurchaseController {
    private Path path;
    @Autowired
    private UserService userService;
    @Autowired
    private PurchaseService purchaseService;

    @RequestMapping("/result")
    public String viewResult(Model model, Principal activeUser) {
        User user = userService.getUserByUsername(activeUser.getName());
        List<PurchasePanel> purchasePanels = purchaseService.getPurchasePanelByUserId(user.getUserId());
        model.addAttribute("purchasPanelList", purchasePanels);
        return "resultBox";
    }

    @RequestMapping("/purchase")
    public String viewPurchase(Model model, Principal activeUser) {
        User user = userService.getUserByUsername(activeUser.getName());
        int currentBalance = user.getSalary() - user.getSum();
        model.addAttribute("sum", user.getSum());
        model.addAttribute("balance", currentBalance);
        return "index";
    }

    @RequestMapping(value = "/purchase", method = RequestMethod.POST)
    public String addPurchase(@Valid @ModelAttribute("purchasePanel") PurchasePanel purchasePanel,  HttpServletRequest request,
                              BindingResult result, Principal activeUser, final RedirectAttributes redirectAttributes) {

        if (result.hasErrors()) {
            redirectAttributes.addFlashAttribute("Error", "Ви не ввели ціну");
            return "redirect:/purchase";

        }
        User user = userService.getUserByUsername(activeUser.getName());
        purchasePanel.setUser(user);
        purchaseService.addPurchase(purchasePanel);
        List<PurchasePanel> purchasePanels = purchaseService.getPurchasePanelByUserId(user.getUserId());
        int sum = 0;
        for (PurchasePanel panel : purchasePanels) {
            sum += panel.getPurchasePrice();
        }
        user.setSum(sum);
        userService.editUser(user);
        return "redirect:/result";

    }
}
