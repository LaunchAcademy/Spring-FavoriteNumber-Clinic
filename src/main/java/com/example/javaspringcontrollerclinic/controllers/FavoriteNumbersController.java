package com.example.javaspringcontrollerclinic.controllers;

import com.example.javaspringcontrollerclinic.models.FavoriteNumber;
import java.util.Map;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/favorite-numbers")
public class FavoriteNumbersController {

  @GetMapping
  public String getIndex() {
    return "favoriteNumbers/index";
  }

  // when we use a query string, we use @RequestParam
  @GetMapping("/query-string")
  public String getShowWithQueryString(@RequestParam Integer number, Model model) {
    model.addAttribute("number", number);
    return "favoriteNumbers/show";
  }

//  @GetMapping("/query-string")
//  public String getShowWithQueryString(@RequestParam Map<String, String> params, Model model) {
//    model.addAttribute("number", params.get("number");
//    return "favoriteNumbers/show";
//  }

  // when we use a dynamic path, we use @PathVariable
  @GetMapping("/{number}")
  public String getShowWithDynamicPath(@PathVariable Integer number, Model model) {
    model.addAttribute("number", number);
    return "favoriteNumbers/show";
  }

  @GetMapping("/use-model-attribute/{number}")
  public String getShowWithModelAttribute(@ModelAttribute FavoriteNumber favoriteNumber) {
    return "favoriteNumbers/show";
  }

  @GetMapping("/use-model-and-view/{number}")
  public ModelAndView getShowWithModelAndView(@ModelAttribute FavoriteNumber favoriteNumber) {
    ModelAndView modelAndView = new ModelAndView("favoriteNumbers/show");
    modelAndView.addObject("favoriteNumber", favoriteNumber);
    return modelAndView;
  }
}
