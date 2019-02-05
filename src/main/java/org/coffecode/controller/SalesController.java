package org.coffecode.controller;

import org.coffecode.entity.Sales;
import org.coffecode.service.SalesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import static java.util.stream.Collectors.toList;

import javax.annotation.PostConstruct;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@Controller
public class SalesController {

    @Autowired
    private SalesService salesService;

    private SalesList salesListTotal;
    private SalesList salesListByItemTypeEquals;
    private SalesList salesListByCountryNameLike;
    private SalesList salesListByUnitsPriceLessThan;


    @PostConstruct
    void init() {

        System.out.println("Starting creating objects ... ");
        List<Sales> salesList = readCsvData("C:\\Users\\msiwiak\\IdeaProjects\\projects\\spring-data-rest-api-angularjs\\src\\main\\resources\\sample.csv");

        List<Sales> all = salesService.findAll();
        for (Sales sales : all) {
            salesService.deleteSales(sales);
        }

        for (Sales sales : salesList) {
            salesService.saveSales(sales);
        }

        salesListByItemTypeEquals = new SalesList();
        salesListByItemTypeEquals.setSalesList(salesService.findAll());
        salesListByCountryNameLike = new SalesList();
        salesListByCountryNameLike.setSalesList(salesService.findAll());
        salesListByUnitsPriceLessThan = new SalesList();
        salesListByUnitsPriceLessThan.setSalesList(salesService.findAll());

    }

    @GetMapping("/demo")
    public String getDemo(){
        return "crm-form2";
    }


   /* @RequestMapping(value = "/salesList", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET)
    public ResponseEntity<List<Sales>> findAll() {
        List<Sales> salesList = salesService.findAll();
        return new ResponseEntity<>(salesList, HttpStatus.OK);
    }*/

    @RequestMapping(value = "/distinctByItemType", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET)
    public ResponseEntity<List<String>> findDistinctByItemType() {
        List<String> itemTypes = salesService.findDistinctByItemType();
        return new ResponseEntity<>(itemTypes, HttpStatus.OK);
    }

    @RequestMapping(value = "/itemTypeEquals", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET)
    public ResponseEntity<List<Sales>> findByItemTypeEquals() {
        List<Sales> salesList = salesService.findByItemTypeEquals("Meat");
        return new ResponseEntity<>(salesList, HttpStatus.OK);
    }

    @RequestMapping(value = "/countryNameLike", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET)
    public ResponseEntity<List<Sales>> findByCountryNameLike() {
        List<Sales> salesList = salesService.findByCountryNameLike("pol");
        return new ResponseEntity<>(salesList, HttpStatus.OK);
    }

    @RequestMapping(value = "/unitsPriceLessThan", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET)
    public ResponseEntity<List<Sales>> findByUnitsPriceLessThan() {
        List<Sales> salesList = salesService.findByUnitsPriceLessThan(50);
        return new ResponseEntity<>(salesList, HttpStatus.OK);
    }

    private Sales getSalesById(int id) {
        for (Sales sales : salesListTotal.getSalesList()) {
            if (sales.getId() == id) {
                return sales;
            }
        }
        return null;
    }

    /**
     * HTTP GET - Get all countries
     */
    @RequestMapping(value = "/demo/sales", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET)
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

        return new ResponseEntity<>(salesListTotal, HttpStatus.OK);
    }

    /**
     * HTTP POST - Create new sales
     */
    @RequestMapping(value = "/demo/sales", consumes = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
    public ResponseEntity<String> createSales(@RequestBody Sales newSales) {
        newSales.setId(salesListTotal.getSalesList().size() + 1);
        salesService.saveSales(newSales);

        salesListByItemTypeEquals.setSalesList(salesService.findAll());
        salesListByCountryNameLike.setSalesList(salesService.findAll());
        salesListByUnitsPriceLessThan.setSalesList(salesService.findAll());

        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    /**
     * HTTP PUT - Update sales
     */
    @RequestMapping(value = "/demo/sales/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.PUT)
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
            return new ResponseEntity<>(salesToUpdate, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }


    /**
     * HTTP DELETE - Delete sales
     */
    @RequestMapping(value = "/demo/sales/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<String> deleteSales(@PathVariable("id") int id) {

        Sales salesToDelete;
        try {
            salesToDelete = getSalesById(id);
            if (salesToDelete != null) {
                salesService.deleteSales(salesToDelete);
                return new ResponseEntity<>(HttpStatus.OK);
            }
        } catch (Exception e) {
            System.out.println("Error fetching data");
        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }


    private List<Sales> readCsvData(String path) {

        List<Sales> salesList = new ArrayList<>();
        String line = "";
        String cvsSplitBy = ",";
        DateFormat format = new SimpleDateFormat("MM/dd/yyyy", Locale.ENGLISH);
        int objectCounter = 0;

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            br.readLine(); // this will read the first line
            while ((line = br.readLine()) != null) {

                Sales sales = new Sales();
                String[] salesCsvLine = line.split(cvsSplitBy);

                //sales.setRegion(salesCsvLine[0]);
                sales.setCountry(salesCsvLine[1]);
                sales.setItemType(salesCsvLine[2]);
                //sales.setSalesChannel(salesCsvLine[3]);
                sales.setOrderPriority(salesCsvLine[4]);
                //sales.setOrderDate(new Timestamp(format.parse(salesCsvLine[5]).getTime()));
                //sales.setOrderId(salesCsvLine[6]);
                //sales.setShipDate(new Timestamp(format.parse(salesCsvLine[7]).getTime()));
                sales.setUnitsSold(Integer.parseInt(salesCsvLine[8]));
                sales.setUnitsPrice(Double.parseDouble(salesCsvLine[9]));
                //sales.setUnitsCost(Double.parseDouble(salesCsvLine[10]));
                //sales.setTotalRevenue(Double.parseDouble(salesCsvLine[11]));
                sales.setTotalCost(Double.parseDouble(salesCsvLine[12]));
                //sales.setTotalProfit(Double.parseDouble(salesCsvLine[13]));

                salesList.add(sales);

                objectCounter++;
            }

            System.out.println("Successfully created " + objectCounter + " objects.");

        } catch (IOException e) {
            e.printStackTrace();
        }
        return salesList;
    }
}
