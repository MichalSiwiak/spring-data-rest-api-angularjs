package net.coffeecoding.dao;

import net.coffeecoding.entity.Sales;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class SalesDAOImpl implements SalesDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public int saveSales(Sales sales) {
        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.saveOrUpdate(sales);
        return sales.getId();
    }

    @Override
    public List<Sales> findAll() {
        Session currentSession = sessionFactory.getCurrentSession();
        Query<Sales> query =
                currentSession.createQuery("SELECT c from Sales c",
                        Sales.class);
        List<Sales> salesList = query.getResultList();

        return salesList;
    }

    @Override
    public void deleteSales(Sales sales) {
        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.delete(sales);
    }

    @Override
    public List<String> findDistinctByItemType() {
        Session currentSession = sessionFactory.getCurrentSession();

        Query<String> query =
                currentSession.createQuery("select DISTINCT(s.itemType) from Sales s",
                        String.class);
        List<String> itemsType = query.getResultList();
        return itemsType;
    }

    @Override
    public List<Sales> findByItemTypeEquals(String itemType) {

        Session currentSession = sessionFactory.getCurrentSession();
        Query<Sales> query =
                currentSession.createQuery("select s from Sales s where s.itemType = :itemType ",
                        Sales.class);
        query.setParameter("itemType", itemType);
        List<Sales> salesList = query.getResultList();

        return salesList;
    }

    @Override
    public List<Sales> findByCountryNameLike(String country) {

        Session currentSession = sessionFactory.getCurrentSession();
        Query<Sales> query =
                currentSession.createQuery("select s from Sales s where lower(s.country) like lower(concat('%', :country,'%'))",
                        Sales.class);
        query.setParameter("country", country);
        List<Sales> salesList = query.getResultList();
        return salesList;

    }

    @Override
    public List<Sales> findByUnitsPriceLessThan(double unitsPrice) {

        Session currentSession = sessionFactory.getCurrentSession();

        Query<Sales> query =
                currentSession.createQuery("select s from Sales s where s.unitsPrice < :unitsPrice ",
                        Sales.class);
        query.setParameter("unitsPrice", unitsPrice);
        List<Sales> salesList = query.getResultList();
        return salesList;
    }
}
