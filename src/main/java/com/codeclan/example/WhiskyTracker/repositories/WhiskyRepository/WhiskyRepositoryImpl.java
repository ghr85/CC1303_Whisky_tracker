package com.codeclan.example.WhiskyTracker.repositories.WhiskyRepository;

import com.codeclan.example.WhiskyTracker.models.Distillery;
import com.codeclan.example.WhiskyTracker.models.Whisky;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;


public class WhiskyRepositoryImpl implements WhiskyRepositoryCustom {

    @Autowired
    EntityManager entityManager;

    @Transactional
    public List<Whisky> findWhiskiesByYear(int year){
        List<Whisky> result = null;

            Session session = entityManager.unwrap(Session.class);
            Criteria criteria = session.createCriteria(Whisky.class);
            criteria.add(Restrictions.eq("year",year));
            result = criteria.list();
            return result ;

    };

    @Transactional
    public List<Whisky> findWhiskyByDistilleryAndAge(String distillery,int age){
        List<Whisky> result = null;
        Session session = entityManager.unwrap(Session.class);
        Criteria criteria = session.createCriteria(Whisky.class);
        criteria.createAlias("distillery","distilleryAlias");
        criteria.add(Restrictions.eq("age",age)).add(Restrictions.eq("distilleryAlias.name",distillery));
        result = criteria.list();
        return result ;

    };


}
