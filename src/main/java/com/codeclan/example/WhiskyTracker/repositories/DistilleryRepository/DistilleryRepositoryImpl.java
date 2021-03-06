package com.codeclan.example.WhiskyTracker.repositories.DistilleryRepository;

import com.codeclan.example.WhiskyTracker.models.Distillery;
import com.codeclan.example.WhiskyTracker.models.Whisky;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;


public class DistilleryRepositoryImpl implements DistilleryRepositoryCustom {
    @Autowired
    EntityManager entityManager;
    @Transactional
    public List<Distillery> findDistilleriesByRegion(String region){
        List<Distillery> result = null;

        Session session = entityManager.unwrap(Session.class);
        Criteria criteria = session.createCriteria(Distillery.class);
        criteria.add(Restrictions.eq("region",region));
        result = criteria.list();
        return result ;

    };
    @Transactional
        public List<Distillery> findDistilleriesByWhiskyAge(int age){
        List<Distillery> result = null;

        Session session = entityManager.unwrap(Session.class);
        Criteria criteria = session.createCriteria(Distillery.class);
        criteria.createAlias("whiskies", "whiskiesAlias");
        criteria.add(Restrictions.eq("whiskiesAlias.age",age));
        result = criteria.list();
        return result ;

    };
}
