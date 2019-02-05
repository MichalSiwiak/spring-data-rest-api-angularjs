package org.coffecode.dao;

import org.coffecode.entity.Sales;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository
public class SalesDAOImpl implements SalesDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void saveSales(Sales sales) {
        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.saveOrUpdate(sales);

    }
}
