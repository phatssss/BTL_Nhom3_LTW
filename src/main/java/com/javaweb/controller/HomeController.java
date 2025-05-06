package com.javaweb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

  @GetMapping("/index")
  public ModelAndView home() {
    ModelAndView modelAndView = new ModelAndView("index"); // Trả về index.jsp trong /WEB-INF/views/
    return modelAndView;
  }
}
