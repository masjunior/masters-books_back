package com.example.masters_of_books;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
public class HomeController {

  @GetMapping("/")
  public String listar() {
  	System.out.println("PASSEI AQU na home");
  	return "OI CLIENTE";
  }
}
