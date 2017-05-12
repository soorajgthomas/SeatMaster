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

import com.ibsplc.dao.JsonLayoutDao;
import com.ibsplc.entities.AirlineModel;
import com.ibsplc.entities.JsonLayout;

@Repository
@Transactional
public class JsonLayoutDaoImpl implements JsonLayoutDao {

	@Autowired
	SessionFactory sessionFactory;

	@Override
	public int saveData(JsonLayout jsonLayout) {
		Session session = sessionFactory.getCurrentSession();
		session.save(jsonLayout);
		return jsonLayout.getId().intValue();
	}
	
	@Override
    public void updateJsonLayout(JsonLayout jsonLayout) {
        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.update(jsonLayout);
    }
    

	@SuppressWarnings("unchecked")
	@Override
	public List<JsonLayout> getAllJsonLayout() {
		Criteria c = sessionFactory.getCurrentSession().createCriteria(JsonLayout.class);
		return c.list();
	}
	
	
    @Override
	public JsonLayout getJsonLayoutById(long id) {
    	JsonLayout jsonLayout = new JsonLayout();
        try {
            Query q = sessionFactory.getCurrentSession().createQuery(
                    "from JsonLayout where id= :cod");
            q.setParameter("cod", id);
            jsonLayout = (JsonLayout) q.uniqueResult();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jsonLayout;
    }       
    
    
    @Override
    public Long getJsonLayoutCount() {
        Session session = sessionFactory.openSession();
        return (Long) session.createCriteria(JsonLayout.class).setProjection(Projections.rowCount()).uniqueResult();
    }

}
