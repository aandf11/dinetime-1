package se452.group5.dinetime.controller;

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



@Controller
@RequestMapping("reservation")
public class ReservationController {

    @Autowired
    private IReservationService reservationService;

    @Autowired
    private IAccountServise accountServise;

    @Autowired
    private ITableService tableService;

    private Integer uid;



    @GetMapping
    public ModelAndView showAccounts() {
    ModelAndView mv = new ModelAndView("list-reservations");

    CustomerAccount c=accountServise.findById(uid);
    

    mv.addObject("reservations", c.getReservationList());

    mv.addObject("account", c);

    mv.addObject("user", c);

    
    return mv;
  }




  @GetMapping("/add")
  public String showSignUpForm(Reservation reservation) {
      System.out.println("add in reservation");
      return "add-reservation";
  }

  @PostMapping
  public String add(@Valid Reservation reservation, BindingResult result, Model model) {
    if (result.hasErrors()) {
     
      return "add-reservation";
    }


    reservationService.update(reservation);
    model.addAttribute("reservation", reservationService.findAll());
    
    return "redirect:/reservation";
  }



  @Transactional
  @GetMapping("/delete/{id}")
  public String delete(@PathVariable("id") Integer id, Model model) {
      System.out.println("delete in reservation"+id);

      System.out.println("in delete Model"+ model);
      Reservation reservation = reservationService.findById(id);

      TableAvailability t= reservation.getTable();
      t.setReservation(null);

      reservation.setTable(null);
      tableService.update(t);

    

      CustomerAccount c=accountServise.findById(uid);
      c.removeReservation(reservation);
      accountServise.update(c);

      reservation.setUser_id(null);
      
      reservationService.deleteById(id);



      return "redirect:/reservation";
  }  





  

  @GetMapping("/show/{id}")
  public String show(@PathVariable("id") Integer id, Model model) {
      uid=id;
      System.out.println("show in reservation");
      return "redirect:/reservation";
  }  





  @GetMapping("/edit/{id}")
  public String showEdit(@PathVariable("id") Integer id, Model model) {
    Reservation reservation = reservationService.findById(id);
    System.out.println("in edit Model"+ model);
    model.addAttribute("reservation", reservation);
    return "edit-reservation";  
  }


  
  @PostMapping("/edit")
  public String update(@Valid Reservation reservation, BindingResult result) {
    if (result.hasErrors()) {
      return "edit-reservation";
    }

    reservation.setUser_id(accountServise.findById(uid));

  
    reservationService.update(reservation);
    System.out.println("size: "+ reservationService.findAll().size());
    return "redirect:/reservation";
  }



    
}
