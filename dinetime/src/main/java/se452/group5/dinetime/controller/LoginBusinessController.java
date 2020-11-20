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
@RequestMapping("loginBusiness")
public class LoginBusinessController {
    @Autowired
    private ILoginBusinessService accountServise;

    @Autowired
    private IBAccountServise businessAccountService;

    @GetMapping
    public ModelAndView showAccounts() {
    ModelAndView mv = new ModelAndView("login-business");
    mv.addObject("accounts", accountServise.findAll());
    return mv;
  }

  @GetMapping("/add")
  public String showSignUpForm(LoginBusiness loginBusiness) {
      return "login-business";
  }

 
  @PostMapping
  public ModelAndView add(@Valid LoginBusiness account, BindingResult result, Model model) {
    if (result.hasErrors()) {
      ModelAndView mv = new ModelAndView("login-business");
      mv.addObject("accounts", accountServise.findAll());
      return mv;
      
    }

    List<BusinessAccount> login = businessAccountService.findByUserId(account.getUserId());

    if(login.size()!=0){
      System.out.println("Get customer!!!!!");

      BusinessAccount user=login.get(0);

      String cPassword = user.getPassword();
      String iPassword = account.getPassword();
      if(cPassword.equals(iPassword)){
        System.out.println("passward correct, login!!");
       
        ModelAndView mv1 = new ModelAndView("list-restaurants");
        
        List<Restaurant> r1 = user.getRestaurantList();
      
        mv1.addObject("restaurants", r1);
        
        mv1.addObject("account", user);
        System.out.println("account!!"+user.getId());
       
        return mv1;
      }
    }
   
        //user id and password is incorrect return the same page
        System.out.println("passward incorrect, login!!");
   
        ModelAndView mv = new ModelAndView("login-business");
        mv.addObject("accounts", accountServise.findAll());
        
        return mv;



  }
    
}
