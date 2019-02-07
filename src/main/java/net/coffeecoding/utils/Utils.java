package net.coffeecoding.utils;

import net.coffeecoding.entity.Sales;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@Component
public class Utils {

    public List<Sales> readCsvData(String path) {

        List<Sales> salesList = new ArrayList<>();
        String line;
        String cvsSplitBy = ",";
        DateFormat format = new SimpleDateFormat("MM/dd/yyyy", Locale.ENGLISH);

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
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return salesList;
    }
}
