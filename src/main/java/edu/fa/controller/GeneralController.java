package edu.fa.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class GeneralController {
	@RequestMapping("/")
	public String access(Model model) {
		return "redirect:/home";
	}
	
	@RequestMapping("/home")
	public String home(Model model) {
		return "home";
	}
}
