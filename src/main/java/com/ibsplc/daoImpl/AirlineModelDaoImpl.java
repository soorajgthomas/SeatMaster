package com.ibsplc.daoImpl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ibsplc.dao.AirlineModelDao;
import com.ibsplc.entities.AirlineModel;
import com.ibsplc.entities.JsonLayout;

@Repository
@Transactional
public class AirlineModelDaoImpl implements AirlineModelDao {

	@Autowired
	SessionFactory sessionFactory;
	

	@Override
	public int saveData(AirlineModel airlineModel) {
		Session session = sessionFactory.getCurrentSession();
		session.save(airlineModel);
		return airlineModel.getId().intValue();
	}
	
	
    @Override
    public void updateAirlineModel(AirlineModel airlineModel) {
        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.update(airlineModel);
    }
    

	@SuppressWarnings("unchecked")
	@Override
	public List<AirlineModel> getAllAirlineModel() {
		Criteria c = sessionFactory.getCurrentSession().createCriteria(AirlineModel.class);
		return c.list();
	}
	
	
    @Override
	public AirlineModel getAirlineModelById(long id) {
    	AirlineModel airlineModel = new AirlineModel();
        try {
            Query q = sessionFactory.getCurrentSession().createQuery(
                    "from AirlineModel where id= :cod");
            q.setParameter("cod", id);
            airlineModel = (AirlineModel) q.uniqueResult();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return airlineModel;
    }
    
//    @Override
//	public JsonLayout getJsonLayoutByAirlineModel(JsonLayout jsonLayout) {
//    	
//    	System.out.println("JsonLayout : "+ jsonLayout.getId());
//    	int id 
//    	
//    	JsonLayout jsonLayout1 = new JsonLayout();
//        try {
//            Query q = sessionFactory.getCurrentSession().createQuery(
//                    "from AirlineModel where JsonLayout= :cod");
//            q.setParameter("cod", jsonLayout);
//            jsonLayout1 = (JsonLayout) q.uniqueResult();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        
//        //System.out.println("AirlineModel : "+ airlineModel.getAirlineModel());
//        System.out.println("jsonString : "+ jsonLayout.getJsonString());
//        
//        return jsonLayout;
//    }
    
    
    @Override
	public AirlineModel getAirlineModelByFlightModel(String flightModel) {
    	AirlineModel airlineModel = new AirlineModel();
        try {
            Query q = sessionFactory.getCurrentSession().createQuery(
                    "from AirlineModel where airlineModel= :cod");
            q.setParameter("cod", flightModel);
            airlineModel = (AirlineModel) q.uniqueResult();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return airlineModel;
    }
    
    
    @Override
    public Long getAirlineModelCount() {
        Session session = sessionFactory.openSession();
        return (Long) session.createCriteria(AirlineModel.class).setProjection(Projections.rowCount()).uniqueResult();
    }


}
