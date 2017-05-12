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

import com.ibsplc.dao.MetaDataDao;
import com.ibsplc.entities.MetaData;

@Repository
@Transactional
public class MetaDataDaoImpl implements MetaDataDao {

	@Autowired
	SessionFactory sessionFactory;
	
	@Override
	public int saveData(MetaData metaData) {
		Session session = sessionFactory.getCurrentSession();
		session.save(metaData);
		return metaData.getId().intValue();
	}
	
    @Override
    public void updateMetaData(MetaData metaData) {
        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.update(metaData);
    }
    

	@SuppressWarnings("unchecked")
	@Override
	public List<MetaData> getAllMetaData() {
		Criteria c = sessionFactory.getCurrentSession().createCriteria(MetaData.class);
		return c.list();
	}
	
	
    @Override
	public MetaData getMetaDataById(long id) {
    	MetaData metaData = new MetaData();
        try {
            Query q = sessionFactory.getCurrentSession().createQuery(
                    "from MetaData where id= :cod");
            q.setParameter("cod", id);
            metaData = (MetaData) q.uniqueResult();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return metaData;
    }
    
    
    @Override
    public Long getMetaDataCount() {
        Session session = sessionFactory.openSession();
        return (Long) session.createCriteria(MetaData.class).setProjection(Projections.rowCount()).uniqueResult();
    }

}
