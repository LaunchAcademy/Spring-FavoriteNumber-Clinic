package com.example.javaspringcontrollerclinic.controllers;

import com.example.javaspringcontrollerclinic.models.FavoriteNumber;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/favorite-numbers")
public class FavoriteNumbersController {
  @GetMapping
  public String getRoot(){
    return "favoriteNumbers/index";
  }
  @GetMapping("/favorite")
  public String getFavoriteNumber(@RequestParam Integer number, Model model){
    model.addAttribute("number", number);
    return "favoriteNumbers/show";
  }
  @GetMapping("/favorite/{number}")
  public String getFavoriteNumberWithPath(@PathVariable Integer number, Model model){
    model.addAttribute("number", number);
    return "favoriteNumbers/show";
  }
  
  @GetMapping("/number-with-bean/{number}")
  public String getFavoriteWithBean(@PathVariable Integer number, @ModelAttribute FavoriteNumber favoriteNumber){
    return "favoriteNumbers/show";
  }
}
