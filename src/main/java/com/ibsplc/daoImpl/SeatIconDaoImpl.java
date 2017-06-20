package com.ibsplc.daoImpl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ibsplc.dao.IconDao;
import com.ibsplc.dao.SeatIconDao;
import com.ibsplc.entities.Icon;
import com.ibsplc.entities.JsonLayout;
import com.ibsplc.entities.SeatIcon;

@Repository
@Transactional
public class SeatIconDaoImpl implements SeatIconDao{

    @Autowired
    SessionFactory sessionFactory;

	@Override
	public int saveData(SeatIcon seatIcon) {
		Session currentSession = sessionFactory.getCurrentSession();
        currentSession.save(seatIcon);
        return seatIcon.getId().intValue();
	}

	@Override
	public void updateSeatIcon(SeatIcon seatIcon) {
		Session currentSession = sessionFactory.getCurrentSession();
        currentSession.update(seatIcon);
		
	}

	@Override
	public List<Icon> getAllSeatIcon() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Icon getSeatIconById(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Long getSeatIconCount() {
		// TODO Auto-generated method stub
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public JSONArray getSeatIconJsonById(long icon_id) {
		
		
		JSONArray returnJson=new JSONArray();
		
		SeatIcon seaticon = new SeatIcon();
        try {
            Query q = sessionFactory.getCurrentSession().createQuery(
                    "from SeatIcon where icon=1 ");
           // q.setParameter("cod", icon_id);
            
			List<SeatIcon> seatIconList=q.list();         
           
			if(seatIconList.size() > 10) {
				JSONObject jsonObj;
				for (int i=0; i< 10; i++){     
				/*	jsonObj=new JSONObject();
					jsonObj.put("sequenceNo", seatIconList.get(i).getSequenceno());
					jsonObj.put("image", seatIconList.get(i).getSeatimage());*/
					returnJson.put(new JSONObject(tojsonObj(seatIconList.get(i))));
				}
			} else {
				for (SeatIcon seatIcon : seatIconList){
					returnJson.put(tojsonObj(seatIcon));
				}
			}
			                            
            
        } catch (Exception e) {
            e.printStackTrace();
        }
		return returnJson;
	}
	


	
	private String tojsonObj(SeatIcon seatIcon) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            String value = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(seatIcon);
            return value;
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return null;
        }
    }
	  
	


}
