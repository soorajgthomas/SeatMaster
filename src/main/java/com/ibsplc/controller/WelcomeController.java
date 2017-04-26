package com.ibsplc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class WelcomeController {

	
	@GetMapping("/")
	public ModelAndView test() {
		
		ModelAndView model = new ModelAndView();
        model.setViewName("test");
        return model;
	}
	
	
	@GetMapping("/streetView")
	public ModelAndView streetView() {
		
		ModelAndView model = new ModelAndView();
        model.setViewName("streetView");
        return model;
	}
}
