package org.coffecode.controller;

import org.coffecode.entity.Sales;

import java.util.List;

public class SalesList {

    private List<Sales> salesList;

    public List<Sales> getSalesList() {
        return salesList;
    }

    public void setSalesList(List<Sales> salesList) {
        this.salesList = salesList;
    }

    @Override
    public String toString() {
        return "SalesList{" +
                "salesList=" + salesList +
                '}';
    }
}
