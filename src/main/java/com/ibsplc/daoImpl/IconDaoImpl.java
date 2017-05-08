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

import com.ibsplc.dao.IconDao;
import com.ibsplc.entities.Icon;

@Repository
@Transactional
public class IconDaoImpl implements IconDao{

    @Autowired
    SessionFactory sessionFactory;
	
	@Override
	public int saveData(Icon icon) {
		Session currentSession = sessionFactory.getCurrentSession();
        currentSession.save(icon);
        return icon.getId().intValue();
	}
	
    @Override
    public void updateIcon(Icon icon) {
        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.update(icon);
    }
    

	@SuppressWarnings("unchecked")
	@Override
	public List<Icon> getAllIcon() {
		Criteria c = sessionFactory.getCurrentSession().createCriteria(Icon.class);
		return c.list();
	}
	
	
    @Override
	public Icon getIconById(long id) {
    	Icon icon = new Icon();
        try {
            Query q = sessionFactory.getCurrentSession().createQuery(
                    "from Icon where id= :cod");
            q.setParameter("cod", id);
            icon = (Icon) q.uniqueResult();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return icon;
    }
    
    
    @Override
    public Long getIconCount() {
        Session session = sessionFactory.openSession();
        return (Long) session.createCriteria(Icon.class).setProjection(Projections.rowCount()).uniqueResult();
    }

}
