package com.ibsplc.dao;

import java.util.List;

import com.ibsplc.entities.MetaData;

public interface MetaDataDao {

	public int saveData(MetaData metaData);
	
	public void updateMetaData(MetaData metaData);
	
	public List<MetaData> getAllMetaData();
	
	public MetaData getMetaDataById(long id);
	
	public Long getMetaDataCount();
	
}
