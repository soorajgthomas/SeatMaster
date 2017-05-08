package com.ibsplc.daoImpl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.springframework.beans.factory.annotation.Autowired;

import com.ibsplc.dao.AirlineModelDao;
import com.ibsplc.entities.AirlineModel;

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
    
    
    @Override
    public Long getAirlineModelCount() {
        Session session = sessionFactory.openSession();
        return (Long) session.createCriteria(AirlineModel.class).setProjection(Projections.rowCount()).uniqueResult();
    }
}
