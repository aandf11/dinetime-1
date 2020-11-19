package se452.group5.dinetime.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import se452.group5.dinetime.model.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.List;

@Controller
@RequestMapping("rate")
public class RateController {

    @Autowired
    private IAccountServise accountServise;

    @Autowired
    private IRateService rateService;

    @Autowired
    private IReservationService reservationService;

    @Autowired
    private IRestaurantService restaurantService;

    private Integer rid;


//     @GetMapping
//     public ModelAndView showAccounts() {
//     ModelAndView mv = new ModelAndView("add-rate");

//     CustomerAccount c=accountServise.findById(uid);
    

//     mv.addObject("reservations", c.getReservationList());

//     mv.addObject("account", c);

    
//     return mv;
//   }

@GetMapping("/add/{id}")
public String showSignUpForm(Rate rate, @PathVariable("id") Integer id ) {
    System.out.println("add in reservation");
    rid=id;
    return "add-rate";
}




@PostMapping
  public String add(@Valid Rate rate, BindingResult result, Model model) {
    if (result.hasErrors()) {
     
      return "add-rate";
    }


    Reservation reservation = reservationService.findById(rid);
   
    CustomerAccount c=reservation.getUser_id();
    rate.setUser_id(c);
    List<Rate> r=c.getRateList();
    r.add(rate);

    Restaurant restaurant=reservation.getTable().getRestaurant();
    rate.setRestaurant(restaurant);


    accountServise.update(c);
    // rateService.update(rate);
    // model.addAttribute("rate", rateService.findAll());
    
    return "redirect:/reservation";
  }

    
}
