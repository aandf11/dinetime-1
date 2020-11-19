package se452.group5.dinetime.controller;

import java.util.List;

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
@RequestMapping("loginCustomer")
public class LoginCustomerController {
    @Autowired
    private ILoginCustomerService accountServise;

    @Autowired
    private IAccountServise customerAccountServise;

    @Autowired
    private IReservationService reservationService;

    @GetMapping
    public ModelAndView showAccounts() {
    ModelAndView mv = new ModelAndView("login-customer");
    mv.addObject("accounts", accountServise.findAll());
    return mv;
  }

  @GetMapping("/add")
  public String showSignUpForm(LoginCustomer logincustomer) {
      return "login-customer";
  }


  @PostMapping
  public ModelAndView add(@Valid LoginCustomer account, BindingResult result, Model model) {
    if (result.hasErrors()) {
      ModelAndView mv = new ModelAndView("login-customer");
      mv.addObject("accounts", accountServise.findAll());
      return mv;
      // return "login-customer";
    }

    List<CustomerAccount> login = customerAccountServise.findByUserId(account.getUserId());
    if(login.size()!=0){
      System.out.println("Get customer!!!!!");

      CustomerAccount user=login.get(0);
      String cPassword = user.getPassword();
      String iPassword = account.getPassword();
      if(cPassword.equals(iPassword)){
        System.out.println("passward correct, login!!");
        // return "redirect:/customerAccount/add";
        ModelAndView mv1 = new ModelAndView("list-reservations");
        List<Reservation> r1 = user.getReservationList();
        //add reservation list
        mv1.addObject("reservations", r1);
        //add account
        mv1.addObject("account", account);

        mv1.addObject("user", user);
        return mv1;
      }
    }



    //user id and password is incorrect return the same page
    System.out.println("passward incorrect, login!!");
    // return "login-customer";
    ModelAndView mv = new ModelAndView("login-customer");
    mv.addObject("accounts", accountServise.findAll());
    return mv;

  }


  

}
