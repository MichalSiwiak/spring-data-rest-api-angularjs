package org.coffecode.service;

import org.coffecode.dao.SalesDAO;
import org.coffecode.entity.Sales;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class SalesServiceImpl implements SalesService {

    @Autowired
    SalesDAO salesDAO;

    @Transactional
    @Override
    public void saveSales(Sales sales) {
        salesDAO.saveSales(sales);

    }

    @Transactional
    @Override
    public List<Sales> findAll() {
        return salesDAO.findAll();
    }

    @Transactional
    @Override
    public void deleteSales(Sales sales) {
        salesDAO.deleteSales(sales);
    }

    @Override
    @Transactional
    public List<String> findDistinctByItemType() {
        return salesDAO.findDistinctByItemType();
    }

    @Override
    @Transactional
    public List<Sales> findByItemTypeEquals(String itemType) {
        return salesDAO.findByItemTypeEquals(itemType);
    }

    @Override
    @Transactional
    public List<Sales> findByCountryNameLike(String country) {
        return salesDAO.findByCountryNameLike(country);
    }

    @Override
    @Transactional
    public List<Sales> findByUnitsPriceLessThan(double unitsPrice) {
        return salesDAO.findByUnitsPriceLessThan(unitsPrice);
    }
}
