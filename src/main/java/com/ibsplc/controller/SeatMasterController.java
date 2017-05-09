package com.ibsplc.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SeatMasterController {
	
	@PostMapping("/SeatMaster")
	protected ModelAndView displaySeatMaster(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String flight_model = (String)request.getParameter("flight").concat("_").concat((String)request.getParameter("model"));	
		
		ModelAndView model = new ModelAndView();		
		model.addObject("fly1", flight_model);
		if (request.getParameter("flight").contains("SAS")) {
			model.addObject("lat", "55.6314668");
			model.addObject("lon", "12.6621834");
		} else {
			model.addObject("lat", "53.4228485");
			model.addObject("lon", "-6.2393878");
		}
		
		request.getSession().setAttribute("flight_model", flight_model);
		request.getSession().setAttribute("flight_model", model.getModel().get("lat"));
		request.getSession().setAttribute("flight_model", model.getModel().get("lon"));
		
        model.setViewName("home");
        return model;
	
	}
	
	@GetMapping("/SeatMaster")
	protected ModelAndView displaySeatMaster1(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ModelAndView model = new ModelAndView();
		
		String flight_model = (String) request.getSession().getAttribute("fly1");
		model.addObject("lat", request.getSession().getAttribute("lat"));
		model.addObject("lon", request.getSession().getAttribute("lon"));
		
		model.addObject("fly1", flight_model);
        model.setViewName("home");
        return model;
	
	}
	
	
	@GetMapping("/Economy")
	public ModelAndView displayEconomy() {		
		ModelAndView model = new ModelAndView();
        model.setViewName("Economy");
        return model;
	}
	
	@GetMapping("/Business")
	public ModelAndView displayBusiness() {		
		ModelAndView model = new ModelAndView();
        model.setViewName("Business");
        return model;
	}
	
	@GetMapping("/First")
	public ModelAndView displayFirst() {		
		ModelAndView model = new ModelAndView();
        model.setViewName("First");
        return model;
	}

}
