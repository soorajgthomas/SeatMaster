package com.ibsplc.dao;

import java.util.List;

import com.ibsplc.entities.AirlineModel;
import com.ibsplc.entities.JsonLayout;

public interface AirlineModelDao {

	public int saveData(AirlineModel airlineModel);
	
	public void updateAirlineModel(AirlineModel aAirlineModel);
	
	public List<AirlineModel> getAllAirlineModel();
	
	public AirlineModel getAirlineModelById(long id);
	
//	public JsonLayout getJsonLayoutByAirlineModel(JsonLayout jsonLayout) ;
	
	public AirlineModel getAirlineModelByFlightModel(String flightModel);
	
	public Long getAirlineModelCount();
	
}
