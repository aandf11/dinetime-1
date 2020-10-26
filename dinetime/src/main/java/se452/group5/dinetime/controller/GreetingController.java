package se452.group5.dinetime.controller;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class GreetingController {
    @Value( "${spring.profiles.active}" )
    private String greeting;

    @GetMapping("/aa")
    public ModelAndView showGreeting() {
        ModelAndView mv = new ModelAndView("greeting");
        mv.addObject("name", "Hello Dintime Test Page " + greeting);
        return mv;
    }

}