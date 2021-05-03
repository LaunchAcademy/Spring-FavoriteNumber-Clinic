package com.example.javaspringcontrollerclinic.controller;

import com.example.javaspringcontrollerclinic.models.FavoriteNumber;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/numbers")
public class FavoriteNumberController {

    @GetMapping("/")
    public String getRoot(){
        return "favoriteNumbers/index.html";
    }

    @GetMapping("/favNumQueryString")
    public String getFavNumWithQuery(@RequestParam Integer number, Model model){
        model.addAttribute("favoriteNumber", number);
        return "favoriteNumbers/show.html";
    }

    @GetMapping("/favNumPathVariable/{number}")
    public String getFavNumWithPathVar(@PathVariable Integer number, Model model){
        model.addAttribute("favoriteNumber", number);
        return "favoriteNumbers/show.html";
    }

    @GetMapping("/favNumWithModelAttribute/{number}")
    public String getFavNumWithModelAttribute(@PathVariable Integer number, @ModelAttribute FavoriteNumber favoriteNumber) {
        return "favoriteNumbers/show.html";
    }


    @GetMapping("/favNumWithModelAndView/{number}")
    public ModelAndView getDefaultGreeting(@PathVariable Integer number, @ModelAttribute FavoriteNumber favoriteNumber) {
        ModelAndView modelAndView = new ModelAndView("favoriteNumbers/show.html");
        modelAndView.addObject("favoriteNumber", favoriteNumber);
        return modelAndView;
    }

}
