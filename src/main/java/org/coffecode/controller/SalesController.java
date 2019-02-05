package org.coffecode.controller;

import org.coffecode.entity.Sales;
import org.coffecode.service.SalesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import javax.annotation.PostConstruct;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@Controller
public class SalesController {

    @Autowired
    private SalesService salesService;

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
    }


    @RequestMapping(value = "/salesList", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET)
    public ResponseEntity<List<Sales>> getSalesList() {
        List<Sales> salesList = salesService.findAll();
        return new ResponseEntity<>(salesList, HttpStatus.OK);
    }

    @RequestMapping(value = "/distinctByItemType", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET)
    public ResponseEntity<List<String>> getDistinctByItemType() {
        List<String> itemTypes = salesService.findDistinctByItemType();
        return new ResponseEntity<>(itemTypes, HttpStatus.OK);
    }

    @RequestMapping(value = "/itemTypeEquals", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET)
    public ResponseEntity<List<Sales>> getByItemTypeEquals() {
        List<Sales> salesList = salesService.findByItemTypeEquals("Meat");
        return new ResponseEntity<>(salesList, HttpStatus.OK);
    }

    @RequestMapping(value = "/countryNameLike", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET)
    public ResponseEntity<List<Sales>> getByCountryNameLike() {
        List<Sales> salesList = salesService.findByCountryNameLike("pol");
        return new ResponseEntity<>(salesList, HttpStatus.OK);
    }

    @RequestMapping(value = "/unitsPriceLessThan", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET)
    public ResponseEntity<List<Sales>> getByUnitsPriceLessThan() {
        List<Sales> salesList = salesService.findByUnitsPriceLessThan(50);
        return new ResponseEntity<>(salesList, HttpStatus.OK);
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

                sales.setRegion(salesCsvLine[0]);
                sales.setCountry(salesCsvLine[1]);
                sales.setItemType(salesCsvLine[2]);
                sales.setSalesChannel(salesCsvLine[3]);
                sales.setOrderPriority(salesCsvLine[4]);
                sales.setOrderDate(new Timestamp(format.parse(salesCsvLine[5]).getTime()));
                sales.setOrderId(salesCsvLine[6]);
                sales.setShipDate(new Timestamp(format.parse(salesCsvLine[7]).getTime()));
                sales.setUnitsSold(Integer.parseInt(salesCsvLine[8]));
                sales.setUnitsPrice(Double.parseDouble(salesCsvLine[9]));
                sales.setTotalRevenue(Double.parseDouble(salesCsvLine[11]));
                sales.setTotalCost(Double.parseDouble(salesCsvLine[12]));
                sales.setTotalProfit(Double.parseDouble(salesCsvLine[13]));

                salesList.add(sales);

                objectCounter++;
            }

            System.out.println("Successfully created " + objectCounter + " objects.");

        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
        return salesList;
    }
}
