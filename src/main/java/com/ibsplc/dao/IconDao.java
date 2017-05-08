package com.ibsplc.dao;

import java.util.List;

import com.ibsplc.entities.Icon;

public interface IconDao {

	public int saveData(Icon icon);
	
	public void updateIcon(Icon icon);
	
	public List<Icon> getAllIcon();
	
	public Icon getIconById(long id);
	
	public Long getIconCount();
	
}
