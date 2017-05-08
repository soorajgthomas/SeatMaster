package com.ibsplc.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ibsplc.dao.IconDao;
import com.ibsplc.entities.Icon;
import com.ibsplc.util.ImageUtils;

@Controller
public class WelcomeController {

	
	@Autowired
	IconDao iconDao;
	
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
