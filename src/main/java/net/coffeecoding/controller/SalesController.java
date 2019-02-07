package net.coffeecoding.controller;

import net.coffeecoding.entity.Sales;
import net.coffeecoding.service.SalesService;
import net.coffeecoding.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import static java.util.stream.Collectors.toList;

import javax.annotation.PostConstruct;
import javax.servlet.ServletContext;
import java.util.ArrayList;
import java.util.List;

@Controller
public class SalesController {

    @Autowired
    private SalesService salesService;
    @Autowired
    Utils utils;
    @Autowired
    private ServletContext servletContext;

    private SalesList salesListTotal;
    private SalesList salesListByItemTypeEquals;
    private SalesList salesListByCountryNameLike;
    private SalesList salesListByUnitsPriceLessThan;


    @PostConstruct
    private void init() {

        salesListByItemTypeEquals = new SalesList();
        salesListByItemTypeEquals.setSalesList(salesService.findAll());
        salesListByCountryNameLike = new SalesList();
        salesListByCountryNameLike.setSalesList(salesService.findAll());
        salesListByUnitsPriceLessThan = new SalesList();
        salesListByUnitsPriceLessThan.setSalesList(salesService.findAll());
    }

    @GetMapping("/demo")
    public String getDemo() {
        return "crm-form";
    }


    @RequestMapping(value = "/countryName", consumes = MediaType.TEXT_PLAIN_VALUE, method = RequestMethod.POST)
    public ResponseEntity<String> findByCountryNameLike(@RequestBody String countryName) {

        if (countryName.equals("all")) {
            salesListByCountryNameLike.setSalesList(salesService.findAll());
        } else {
            salesListByCountryNameLike.setSalesList(salesService.findByCountryNameLike(countryName));
        }
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @RequestMapping(value = "/itemTypes", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET)
    public ResponseEntity<List<String>> findDistinctByItemType() {
        List<String> itemTypes = salesService.findDistinctByItemType();
        return new ResponseEntity<>(itemTypes, HttpStatus.OK);
    }

    @RequestMapping(value = "/itemType", consumes = MediaType.TEXT_PLAIN_VALUE, method = RequestMethod.POST)
    public ResponseEntity<String> findByItemTypeEquals(@RequestBody String itemType) {
        if (itemType.equals("ALL")) {
            salesListByItemTypeEquals.setSalesList(salesService.findAll());
        } else {
            salesListByItemTypeEquals.setSalesList(salesService.findByItemTypeEquals(itemType));
        }
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @RequestMapping(value = "/price", consumes = MediaType.TEXT_PLAIN_VALUE, method = RequestMethod.POST)
    public ResponseEntity<String> findByUnitsPriceLessThan(@RequestBody String price) {
        salesListByUnitsPriceLessThan
                .setSalesList(salesService
                        .findByUnitsPriceLessThan(Double.parseDouble(price)));
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @RequestMapping(value = "/refresh", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET)
    public ResponseEntity<String> refresh() {

        List<Sales> salesListCsv = utils.readCsvData(servletContext.getRealPath("/WEB-INF/data/sample.csv"));

        for (Sales sales : salesService.findAll()) {
            salesService.deleteSales(sales);
        }
        for (Sales sales : salesListCsv) {
            salesService.saveSales(sales);
        }
        init();
        return new ResponseEntity<>("Successfully refreshed database! Number of records: " + salesListCsv.size(), HttpStatus.OK);
    }

    /**
     * HTTP GET - Get all countries
     */
    @RequestMapping(value = "/sales", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET)
    public ResponseEntity<SalesList> findAll() {

        salesListTotal = new SalesList();
        salesListTotal.setSalesList(salesService.findAll());

        List<Sales> common = new ArrayList<>();

        try {
            common = salesListTotal.getSalesList()
                    .stream()
                    .filter(salesListByItemTypeEquals.getSalesList()::contains)
                    .filter(salesListByCountryNameLike.getSalesList()::contains)
                    .filter(salesListByUnitsPriceLessThan.getSalesList()::contains)
                    .collect(toList());

        } catch (Exception e) {
        }

        salesListTotal.setSalesList(common);
        HttpHeaders headers = new HttpHeaders();
        headers.add("rowsNumberMessage", "Number of rows returned: " + common.size() + ".");
        return new ResponseEntity<>(salesListTotal, headers, HttpStatus.OK);
    }

    /**
     * HTTP POST - Create new sales
     */
    @RequestMapping(value = "/sales", consumes = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
    public ResponseEntity<String> createSales(@RequestBody Sales newSales) {
        newSales.setId(0);
        int id = salesService.saveSales(newSales);

        salesListByItemTypeEquals.setSalesList(salesService.findAll());
        salesListByCountryNameLike.setSalesList(salesService.findAll());
        salesListByUnitsPriceLessThan.setSalesList(salesService.findAll());

        HttpHeaders headers = new HttpHeaders();
        headers.add("message", "Successfully added new row with id = " + id + ".");

        return new ResponseEntity<>(headers, HttpStatus.CREATED);
    }

    /**
     * HTTP PUT - Update sales
     */
    @RequestMapping(value = "/sales/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.PUT)
    public ResponseEntity<Sales> updateSales(@PathVariable("id") int id, @RequestBody Sales sales) {

        Sales salesToUpdate = new Sales();
        try {
            salesToUpdate = getSalesById(id);
        } catch (Exception e) {
            System.out.println("Error fetching data");
        }

        if (salesToUpdate != null) {

            //salesToUpdate.setRegion(sales.getRegion());
            salesToUpdate.setCountry(sales.getCountry());
            salesToUpdate.setItemType(sales.getItemType());
            //salesToUpdate.setSalesChannel(sales.getSalesChannel());
            salesToUpdate.setOrderPriority(sales.getOrderPriority());
            //salesToUpdate.setOrderDate(sales.getOrderDate());
            //salesToUpdate.setOrderId(sales.getOrderId());
            //salesToUpdate.setShipDate(sales.getShipDate());
            salesToUpdate.setUnitsSold(sales.getUnitsSold());
            salesToUpdate.setUnitsPrice(sales.getUnitsPrice());
            //salesToUpdate.setUnitsCost(sales.getUnitsCost());
            //salesToUpdate.setTotalRevenue(sales.getTotalRevenue());
            salesToUpdate.setTotalCost(sales.getTotalCost());
            //salesToUpdate.setTotalProfit(sales.getTotalProfit());

            salesService.saveSales(salesToUpdate);

            HttpHeaders headers = new HttpHeaders();
            headers.add("message", "Successfully updated row with id = " + id + ".");
            return new ResponseEntity<>(salesToUpdate, headers, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }


    /**
     * HTTP DELETE - Delete sales
     */
    @RequestMapping(value = "/sales/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<String> deleteSales(@PathVariable("id") int id) {

        Sales salesToDelete;
        try {
            salesToDelete = getSalesById(id);
            if (salesToDelete != null) {
                salesService.deleteSales(salesToDelete);
                HttpHeaders headers = new HttpHeaders();
                headers.add("message", "Successfully deleted row with id = " + id + ".");
                return new ResponseEntity<>(headers, HttpStatus.OK);
            }
        } catch (Exception e) {
            System.out.println("Error fetching data");
        }


        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    private Sales getSalesById(int id) {
        for (Sales sales : salesListTotal.getSalesList()) {
            if (sales.getId() == id) {
                return sales;
            }
        }
        return null;
    }

}
