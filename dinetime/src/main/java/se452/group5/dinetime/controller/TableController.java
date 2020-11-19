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
@RequestMapping("tableAvailability")
public class TableController {



    @Autowired
    private ITableService tableService;

    @Autowired
    private IRestaurantService restaurantService;


    private Integer uid;

    @GetMapping
    public ModelAndView showAccounts() {

      ModelAndView mv = new ModelAndView("list-tables");
      Restaurant r=restaurantService.findById(uid);
      System.out.println("Show in table controller !!!"+uid);
      mv.addObject("tables", r.getTableList());
    return mv;
  }

  @GetMapping("/add/{id}")
  public String showSignUpForm(@PathVariable("id") Integer id,TableAvailability table) {
      System.out.println("add in table" +id );
      uid=id;
      return "add-table";
  }

  @PostMapping
  public String add(@Valid TableAvailability table, BindingResult result, Model model) {
    if (result.hasErrors()) {
      return "add-table";
    }

    //use id to get the restaurant data, set table to restaurant
    Restaurant r = restaurantService.findById(uid);
    List<TableAvailability> tableList= r.getTableList();
    tableList.add(table);
  

    //set restaurant to table
    table.setRestaurant(r);
    //save
    tableService.update(table);
    restaurantService.update(r);


    model.addAttribute("table", r.getTableList());
    return "redirect:/tableAvailability";
  }

  @GetMapping("/show/{id}")
  public String show(@PathVariable("id") Integer id, Model model) {
      uid=id;
      return "redirect:/tableAvailability";
  }  




  @GetMapping("/delete/{id}")
  public String delete(@PathVariable("id") Integer id, Model model) {
      tableService.deleteById(id);
      System.out.println("delete");
      return "redirect:/tableAvailability";
  }  


  @GetMapping("/edit/{id}")
  public String showEdit(@PathVariable("id") Integer id, Model model) {
    TableAvailability table = tableService.findById(id);
   

    model.addAttribute("table", table);
    return "edit-table";  
  }


  
  @PostMapping("/edit")
  public String update(@Valid TableAvailability table, BindingResult result) {
    if (result.hasErrors()) {
      return "edit-table";
    }

    Restaurant r=restaurantService.findById(uid);
    table.setRestaurant(r);

    tableService.update(table);
    System.out.println("in table controller"+r.getTableList());
    System.out.println("in table controller"+r.getTableList().size());
  
  
    return "redirect:/tableAvailability";
  }




    
}
