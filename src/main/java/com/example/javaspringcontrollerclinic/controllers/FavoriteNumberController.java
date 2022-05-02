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
@RequestMapping("/")
public class FavoriteNumberController {

  @GetMapping
  public String getIndex(Model model) {
    return "favoriteNumbers/index";
  }

  @GetMapping("/query-string")
  public String getShowByQueryString(@RequestParam(required = false) Integer number, Model model) {
    model.addAttribute("number", number);
    return "favoriteNumbers/show";
  }

  @GetMapping("/dynamic-with-bean/{number}")
  public String getShowDynamically2(@ModelAttribute FavoriteNumber favoriteNumber){
    return "favoriteNumbers/show-with-bean";
  }

  @GetMapping("/{number}")
  public String getShowDynamically(@PathVariable Integer number, Model model) {
    model.addAttribute("number", number);
    return "favoriteNumbers/show";
  }


}
