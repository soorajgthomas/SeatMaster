package com.ibsplc.dao;

import java.util.List;

import org.json.JSONArray;

import com.ibsplc.entities.Icon;
import com.ibsplc.entities.JsonLayout;
import com.ibsplc.entities.SeatIcon;

public interface SeatIconDao {

	public int saveData(SeatIcon seatIcon);
	
	public void updateSeatIcon(SeatIcon seatIcon);
	
	public List<Icon> getAllSeatIcon();
	
	public Icon getSeatIconById(long id);
	
	public Long getSeatIconCount();
	
	
	public JSONArray getSeatIconJsonById(long icon_id);
}
