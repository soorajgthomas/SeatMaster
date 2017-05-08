package com.ibsplc.dao;

import java.util.List;

import com.ibsplc.entities.JsonLayout;

public interface JsonLayoutDao {
	
	public int saveData(JsonLayout jsonLayout);
	
	public void updateJsonLayout(JsonLayout jsonLayout);
	
	public List<JsonLayout> getAllJsonLayout();
	
	public JsonLayout getJsonLayoutById(long id);
	
	public Long getJsonLayoutCount();

}
