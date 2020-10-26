package se452.group5.dinetime.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import se452.group5.dinetime.model.*;


@Controller
@RequestMapping("businessAccount")
public class BusinessAccountController {
    @Autowired
    private IBAccountServise accountServise;

    @GetMapping
    public ModelAndView showAccounts() {
    ModelAndView mv = new ModelAndView("list-business");
    mv.addObject("accounts", accountServise.findAll());
    return mv;
  }

  @GetMapping("/add")
  public String showSignUpForm(BusinessAccount account) {
      return "register-business";
  }

  @PostMapping
  public String add(@Valid BusinessAccount account, BindingResult result, Model model) {
    if (result.hasErrors()) {
     
      return "register-business";
    }
    accountServise.update(account);
    model.addAttribute("accounts", accountServise.findAll());
    return "redirect:/businessAccount";
  }



  @GetMapping("/delete/{id}")
  public String delete(@PathVariable("id") Integer id, Model model) {
      accountServise.deleteById(id);
      return "redirect:/businessAccount";
  }  



   @GetMapping("/edit/{id}")
  public String showEdit(@PathVariable("id") Integer id, Model model) {
    BusinessAccount business = accountServise.findById(id);
    System.out.println("Show edit:"+ business.getName());

    model.addAttribute("account", business);
    return "edit-business";  
  }


  
  @PostMapping("/edit")
  public String update(@Valid BusinessAccount business, BindingResult result) {
    if (result.hasErrors()) {
      return "edit-business";
    }

    System.out.println("after edit: "+ business.getId()+ "NAME: "+business.getName());
    accountServise.update(business);
    System.out.println("size: "+ accountServise.findAll().size());
    return "redirect:/businessAccount";
  }

}
