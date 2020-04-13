package com.example.javaspringcontrollerclinic.controllers;

import com.example.javaspringcontrollerclinic.models.FavoriteNumber;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class FavoriteNumberController {
  @GetMapping("/")
  public String getRoot(){
    return "favoriteNumbers/index";
  }

  @GetMapping("/favorite-number")
  public String getFavoriteNumber(@RequestParam Integer number, Model model) {
    model.addAttribute("number", number);
    return "favoriteNumbers/show";
  }

  @GetMapping("/favorite-number/{number}")
  public String getFavoriteNumberWithPath(@PathVariable Integer number, Model model){
    model.addAttribute("number", number);
    return "favoriteNumbers/show";
  }

  @GetMapping("favorite-number-bean/{number}")
  public String getFavoriteNumberBean(@PathVariable Integer number, @ModelAttribute FavoriteNumber favoriteNumber){
    return "favoriteNumbers/show";
  }
}
