package org.coffecode.service;

import org.coffecode.dao.SalesDAO;
import org.coffecode.entity.Sales;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class SalesServiceImpl implements SalesService {

    @Autowired
    SalesDAO salesDAO;

    @Transactional
    @Override
    public void saveSales(Sales sales) {
        salesDAO.saveSales(sales);

    }
}
