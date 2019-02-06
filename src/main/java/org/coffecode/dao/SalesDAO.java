package org.coffecode.dao;

import org.coffecode.entity.Sales;

import java.util.List;

public interface SalesDAO {

    public int saveSales(Sales sales);

    public List<Sales> findAll();

    public void deleteSales(Sales sales);

    public List<String> findDistinctByItemType();

    public List<Sales> findByItemTypeEquals(String itemType);

    public List<Sales> findByCountryNameLike(String country);

    public List<Sales> findByUnitsPriceLessThan(double unitsPrice);


}
