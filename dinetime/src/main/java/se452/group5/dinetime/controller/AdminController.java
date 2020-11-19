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
@RequestMapping("admin")
public class AdminController {

    @Autowired
    private IAccountServise caccountServise;


    @Autowired
    private IBAccountServise baccountServise;


  @GetMapping("/CustomerAccount")
  public ModelAndView showCustomer() {
    ModelAndView mv = new ModelAndView("list-customers");
    mv.addObject("accounts", caccountServise.findAll());
    return mv;
  }  

  @GetMapping("/BusinessAccount")
  public ModelAndView showBusiness() {
    ModelAndView mv = new ModelAndView("list-business");
    mv.addObject("accounts", baccountServise.findAll());
    return mv;
  }  





    
}
