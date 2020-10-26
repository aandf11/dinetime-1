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
@RequestMapping("customerAccount")
public class CustomerAccountController {

    @Autowired
    private IAccountServise accountServise;

    @GetMapping
    public ModelAndView showAccounts() {
    ModelAndView mv = new ModelAndView("list-customers");
    mv.addObject("accounts", accountServise.findAll());
    return mv;
  }

  @GetMapping("/add")
  public String showSignUpForm(CustomerAccount account) {
      return "register";
  }



  @PostMapping
  public String add(@Valid CustomerAccount account, BindingResult result, Model model) {
    if (result.hasErrors()) {
     
      return "register";
    }
    accountServise.update(account);
    model.addAttribute("accounts", accountServise.findAll());
    return "redirect:/customerAccount";
  }



    @GetMapping("/delete/{id}")
  public String delete(@PathVariable("id") Integer id, Model model) {
      accountServise.deleteById(id);
      return "redirect:/customerAccount";
  }  



   @GetMapping("/edit/{id}")
  public String showEdit(@PathVariable("id") Integer id, Model model) {
    CustomerAccount customer = accountServise.findById(id);
    System.out.println("Show edit:"+ customer.getName());

    model.addAttribute("account", customer);
    return "edit-customers";  
  }


  
  @PostMapping("/edit")
  public String update(@Valid CustomerAccount customer, BindingResult result) {
    if (result.hasErrors()) {
      return "edit-customers";
    }

    System.out.println("after edit: "+ customer.getId()+ "NAME: "+customer.getName());
    accountServise.update(customer);
    System.out.println("size: "+ accountServise.findAll().size());
    return "redirect:/customerAccount";
  }
    
}
