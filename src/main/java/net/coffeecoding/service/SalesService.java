package net.coffeecoding.service;

import net.coffeecoding.entity.Sales;

import java.util.List;

public interface SalesService {

    public int saveSales(Sales sales);

    public List<Sales> findAll();

    public void deleteSales(Sales sales);

    public List<String> findDistinctByItemType();

    public List<Sales> findByItemTypeEquals(String itemType);

    public List<Sales> findByCountryNameLike(String country);

    public List<Sales> findByUnitsPriceLessThan(double unitsPrice);
}
