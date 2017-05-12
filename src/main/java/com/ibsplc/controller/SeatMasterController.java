package com.ibsplc.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ibsplc.dao.AirlineModelDao;
import com.ibsplc.entities.AirlineModel;

@Controller
public class SeatMasterController {
	
	@Autowired
	AirlineModelDao airlineModelDao;
	
	
	@PostMapping("/SeatMaster")
	protected ModelAndView displaySeatMaster(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String flight_model = (String)request.getParameter("flight").concat("_").concat((String)request.getParameter("model"));	
		
		ModelAndView model = new ModelAndView();		
		model.addObject("fly1", flight_model);
		
		AirlineModel airlineModel = airlineModelDao.getAirlineModelByFlightModel(flight_model);
		
		if(airlineModel != null && airlineModel.getLat() != null && airlineModel.getLon() !=null) {
			model.addObject("lat", airlineModel.getLat());
			model.addObject("lon", airlineModel.getLon());
			
			request.getSession().setAttribute("flight_model", flight_model);
			request.getSession().setAttribute("lat", model.getModel().get("lat"));
			request.getSession().setAttribute("lon", model.getModel().get("lon"));
			
			model.addObject("id", airlineModel.getId());
						
			if (request.getParameter("flight").contains("SAS")) {
				model.setViewName("home1");
			} else {
				model.setViewName("home");
			}
		}		
	
		
        return model;
	
	}
	
	@GetMapping("/SeatMaster")
	protected ModelAndView displaySeatMaster1(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ModelAndView model = new ModelAndView();
		
		String flight_model = (String) request.getSession().getAttribute("flight_model");
		System.out.println("flight_model" + flight_model);
		model.addObject("lat", request.getSession().getAttribute("lat"));
		model.addObject("lon", request.getSession().getAttribute("lon"));
		
		model.addObject("fly1", flight_model);
		if (flight_model.contains("SAS")) {
			model.setViewName("home1");
		} else {
			model.setViewName("home");
		}
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
