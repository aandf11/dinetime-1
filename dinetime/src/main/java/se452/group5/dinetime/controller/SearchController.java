package se452.group5.dinetime.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.servlet.ModelAndView;
import se452.group5.dinetime.model.*;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("search")
public class SearchController {

    private CustomerAccount user;
    private Integer uid;

    @Autowired
    private IAccountServise customerAccountService;

    @Autowired
    private ITableService tableService;

    @Autowired
    private IReservationService reservationService;

    @GetMapping
    public ModelAndView showAccounts() {
    ModelAndView mv = new ModelAndView("search-table");
    System.out.println("in new search");

    return mv;

  }


  //get the table to add reservation
  @GetMapping("/booking/{id}")
  public ModelAndView showEdit(@PathVariable("id") Integer id, Model model) {
    TableAvailability table = tableService.findById(id);
    user=customerAccountService.findById(uid);

   
      System.out.println("Booking success!");
      Reservation newR=new Reservation();

      
      newR.setRestaurant(table.getRestaurant().getName());
      newR.setCustomer_id(user.getName());
      newR.setTable_id(Integer.toString(table.getId()));
      newR.setTime(table.getTime());
      newR.setDate(table.getDate());
      newR.setSeats(table.getSeats());




      newR.setUser_id(user);

      table.setReservation(newR);
      table.setAvailable(false);

        
      newR.setTable(table);
      reservationService.update(newR);
      user.addReservation(newR);
      customerAccountService.update(user);      
      tableService.update(table);




  
    



    // // //return success html
    ModelAndView mv3 = new ModelAndView("booking-success");


    return mv3;  
  }



  @GetMapping("/add/{id}")
  public String showSignUpForm(Search search, @PathVariable("id") Integer id ) {
      System.out.println("add!!!!!!!!!!!!!!!!"+id);
      uid=id;
      user=customerAccountService.findById(id);
       return "search-table";
      // return "search-result";
  }

  //search table to fit the standard
  @PostMapping
  public ModelAndView add(@Valid Search search, BindingResult result, Model model) {
    if (result.hasErrors()) {
      ModelAndView mv1 = new ModelAndView("search-table");
      return mv1;
    }





    List<Date> dateList=new ArrayList<>();
    dateList.add(search.getDate());

    //get string and convert it to integer
    List<Integer> seatList= new ArrayList<>();
    seatList.add(Integer.parseInt(search.getSeats()));

    System.out.println("add search: "+search.getSeats());
    System.out.println("add search time: "+search.getDate());
    System.out.println("add search table: "+ tableService.findBySeatsInAndDateIn(seatList, dateList));

    ModelAndView mv = new ModelAndView("list-search-tables");
   
    
    List<Boolean> available=new ArrayList<>();
    available.add(true);

    List<TableAvailability> T= tableService.findBySeatsInAndDateInAndAvailableIn(seatList, dateList, available);
    mv.addObject("tables", T);
   
    return mv;
  }
  




    
}
