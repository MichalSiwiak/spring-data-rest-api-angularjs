package org.coffecode.controller;

import org.coffecode.entity.Sales;
import org.coffecode.service.SalesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Controller;

import javax.annotation.PostConstruct;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.logging.Logger;

@Controller
public class SalesController {

    @Autowired
    private SalesService salesService;

    @Value("classpath:sample.csv")
    Resource resourceFile;

    @PostConstruct
    void init() throws IOException, URISyntaxException {
       File file = new File("dddd.txt");
       file.createNewFile();

        System.out.println(file.getAbsolutePath());
    }


    public List<Sales> readCsvData(String path) {

        List<Sales> salesList = new ArrayList<>();
        String line = "";
        String cvsSplitBy = ",";
        DateFormat format = new SimpleDateFormat("MM/dd/yyyy", Locale.ENGLISH);

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            br.readLine(); // this will read the first line
            int i = 0;
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

                i++;
            }

            System.out.println("Successfully added " + i + " records.");

        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }

        return salesList;
    }
}
