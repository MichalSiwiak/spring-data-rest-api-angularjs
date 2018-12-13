package org.coffecode.dao;

import org.coffecode.entity.Country;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CountryDAOImpl implements CountryDAO {

    @Autowired
    private SessionFactory sessionFactory;


    @Override
    public void saveCountry(Country country) {
        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.saveOrUpdate(country);

    }

    @Override
    public void deleteCountry(Country country) {
        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.delete(country);
    }

    @Override
    public List<Country> findAll() {
        Session currentSession = sessionFactory.getCurrentSession();

        Query<Country> theQuery =
                currentSession.createQuery("SELECT c from Country c",
                        Country.class);
        List<Country> countries = theQuery.getResultList();
        return countries;
    }

    @Override
    public List<String> findDistinctContinents() {
        Session currentSession = sessionFactory.getCurrentSession();

        Query<String> theQuery =
                currentSession.createQuery("select DISTINCT(c.continent) from Country c",
                        String.class);
        List<String> countries = theQuery.getResultList();
        return countries;
    }

    @Override
    public List<Country> findByNameLike(String name) {
        Session currentSession = sessionFactory.getCurrentSession();

        Query<Country> theQuery =
                currentSession.createQuery("select c from Country c where lower(c.name) like lower(concat('%', :nameToFind,'%'))",
                        Country.class);
        theQuery.setParameter("nameToFind", name);
        List<Country> countries = theQuery.getResultList();
        return countries;
    }

    /*@Override
    public Integer findMaxPopulation() {
        Session currentSession = sessionFactory.getCurrentSession();

        Query<Integer> theQuery =
                currentSession.createQuery("SELECT c from Country c",
                        Integer.class);
        Integer maxPopulation = theQuery.getSingleResult();
        return maxPopulation;
    }*/

    @Override
    public List<Country> findByPopulationLessThan(int population) {
        Session currentSession = sessionFactory.getCurrentSession();

        Query<Country> theQuery =
                currentSession.createQuery("select c from Country c where c.population < :population ",
                        Country.class);
        theQuery.setParameter("population", population);
        List<Country> countries = theQuery.getResultList();
        return countries;
    }

    @Override
    public List<Country> findByContinentEquals(String continent) {
        Session currentSession = sessionFactory.getCurrentSession();

        Query<Country> theQuery =
                currentSession.createQuery("select c from Country c where c.continent = :continent ",
                        Country.class);
        theQuery.setParameter("continent", continent);
        List<Country> countries = theQuery.getResultList();
        return countries;
    }
}