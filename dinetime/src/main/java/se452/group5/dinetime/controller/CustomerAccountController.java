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

import java.util.List;

@Controller
@RequestMapping("customerAccount")
public class CustomerAccountController {

    @Autowired
    private IAccountServise accountServise;

    @Autowired
    private IReservationService reservationService;

    private CustomerAccount loginUser;

    private Integer uid;

    private CustomerAccount customer;

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


  @GetMapping("/show")
  public String show() {
  return "redirect:/reservation/show/"+uid;
}


  @PostMapping
  public ModelAndView add(@Valid CustomerAccount account, BindingResult result, Model model) {
    if (result.hasErrors()) {
      ModelAndView mv = new ModelAndView("list-customers");
      mv.addObject("accounts", accountServise.findAll());
      return mv;
    }
    //put new account into database
    loginUser=account;
    
    accountServise.update(account);
    uid=account.getId();
   

    //get the list should be null
    List<Reservation> r1 = account.getReservationList();


    ModelAndView mv1 = new ModelAndView("list-reservations");
    //add reservation list
    mv1.addObject("reservations", r1);
    //add account
    mv1.addObject("account", account);

    mv1.addObject("user", account);

    

    return mv1;
  }

  



    @GetMapping("/delete/{id}")
  public String delete(@PathVariable("id") Integer id, Model model) {
      accountServise.deleteById(id);
      return "redirect:/customerAccount";
  }  



   @GetMapping("/edit/{id}")
  public String showEdit(@PathVariable("id") Integer id, Model model) {
     customer = accountServise.findById(id);


    System.out.println("Show edit:"+ customer.getName());

    model.addAttribute("account", customer);
    return "edit-customers";  
  }




  @PostMapping("/edit")
  public String update(@Valid CustomerAccount customer1, BindingResult result) {
    if (result.hasErrors()) {
  
    }
    accountServise.update(customer1);    
    return "redirect:/reservation/show/"+customer1.getId();
  }



    
}
