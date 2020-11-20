package se452.group5.dinetime.controller;

import java.util.ArrayList;
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
@RequestMapping("restaurant")
public class RestaurantController {

    @Autowired
    private IRestaurantService restaurantService;

    @Autowired
    private IBAccountServise bAccountService;

    @Autowired
    private IReservationService reservationService;

    private Integer uid;

    private Integer cid;

    BusinessAccount businessAccount;

   

    @GetMapping
    public ModelAndView showAccounts() {
    ModelAndView mv = new ModelAndView("list-restaurants");
    businessAccount = bAccountService.findById(uid);
    System.out.println("Show restaurant !!!"+uid);
   
    mv.addObject("restaurants", businessAccount.getRestaurantList());
    mv.addObject("account", businessAccount);
    return mv;
  }

  @GetMapping("/add/{id}")
  public String showSignUpForm(@PathVariable("id") Integer id, Restaurant restaurant) {
      System.out.println("In restaurant add: !!!!"+id);
      uid=id;
      return "add-restaurant";
  }





  @PostMapping
  public String add(@Valid Restaurant restaurant, BindingResult result, Model model) {
    if (result.hasErrors()) {
      return "add-restaurant";
    }
    
    //get login business account
    BusinessAccount businessAccount = bAccountService.findById(uid);
    //set the new restaurant to the business's restaurant list
    List<Restaurant> restaurantList = businessAccount.getRestaurantList();
    restaurantList.add(restaurant);

    //set business account to the restaurant
    restaurant.setUser_id(businessAccount);

    //update two service
    restaurantService.update(restaurant);
    bAccountService.update(businessAccount);


    
    // get restaurantlist to show
    model.addAttribute("restaurants", businessAccount.getRestaurantList());
    model.addAttribute("account", businessAccount);
    
    return "redirect:/restaurant";
  }




  @GetMapping("/delete/{id}")
  public String delete(@PathVariable("id") Integer id, Model model) {
      restaurantService.deleteById(id);
      return "redirect:/restaurant";
  }  


  @GetMapping("/edit/{id}")
  public String showEdit(@PathVariable("id") Integer id, Model model) {
    Restaurant restaurant = restaurantService.findById(id);
    
    cid=id;
    System.out.println("Show edit:"+ restaurant.getName());
    System.out.println("in Restaurant edit!!: "+restaurant.getUser_id());

    model.addAttribute("restaurant", restaurant);
    return "edit-restaurant";  
  }


  @GetMapping("/showreservation/{id}")
  public ModelAndView showreservation(@PathVariable("id") Integer id, Model model) {
    Restaurant restaurant = restaurantService.findById(id);

    ModelAndView mv = new ModelAndView("list-reservations-r");
    List<Reservation> r = reservationService.findByRestaurant(restaurant.getName());

    mv.addObject("reservations", r);
    
    return mv; 
}

  
  @PostMapping("/edit")
  public String update(@Valid Restaurant restaurant, BindingResult result) {
    if (result.hasErrors()) {
      return "edit-restaurant";
    }

    BusinessAccount b=bAccountService.findById(uid);
    //** */
    restaurant.setUser_id(b);

    // restaurantService.deleteById(cid);
    restaurantService.update(restaurant);



    System.out.println("in Restaurant edit: "+restaurant.getUser_id());
  

    System.out.println("size: "+ restaurantService.findAll().size());
    return "redirect:/restaurant";
  }



    
}
