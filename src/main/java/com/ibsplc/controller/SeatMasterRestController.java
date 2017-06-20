package com.ibsplc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ibsplc.dao.AirlineModelDao;
import com.ibsplc.dao.JsonLayoutDao;
import com.ibsplc.entities.AirlineModel;
import com.ibsplc.entities.JsonLayout;

@RestController
public class SeatMasterRestController {

	
	@Autowired
	AirlineModelDao airlineModelDao;
	
	@Autowired
	JsonLayoutDao jsonLayoutDao;
	
	
	@GetMapping("/getSeatLayout")
	public String  getSeatLayout(@RequestParam(value="id") Long input) {
		System.out.println("\n\n /getSeatLayout : "+input);
		//AirlineModel airlineModel = airlineModelDao.getJsonLayoutByAirlineModel(new JsonLayout(Long.valueOf(1)));
		
		JsonLayout jsonLayout = jsonLayoutDao.getJsonLayoutById(input);
		
		return jsonLayout.getJsonString();
	}
	
	
	private String toJson(JsonLayout employee) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            String value = mapper.writeValueAsString(employee);
            return value;
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return null;
        }
    }
}
