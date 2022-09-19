package controller;

import domain.Passenger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomePage {

    @RequestMapping("/home-page")
    public String display(Model model) {
        Passenger passenger = new Passenger();
        model.addAttribute("passenger", passenger);
        return "home-page-view";
    }
    @RequestMapping("/userLogin")
    public String userLogin(@ModelAttribute("passenger") Passenger passenger){
        System.out.println(passenger.getUserName());
        return "home-page-view";
    }

}
