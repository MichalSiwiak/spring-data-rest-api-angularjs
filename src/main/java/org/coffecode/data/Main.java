package org.coffecode.data;

import org.coffecode.dao.CountryDAO;
import org.coffecode.dao.SalesDAO;
import org.coffecode.dao.SalesDAOImpl;
import org.coffecode.entity.Sales;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.logging.Logger;

public class Main {



    private static SalesDAOImpl salesDAO = new SalesDAOImpl();

    private Logger logger = Logger.getLogger(getClass().getName());




    public static void main(String[] args) throws IOException {

        salesDAO.saveSales(new Sales());


        //File file = new File("sample.csv");
        //file.createNewFile();

        /*String csvFile = "sample.csv";
        String line = "";
        String cvsSplitBy = ",";
        DateFormat format = new SimpleDateFormat("MM/dd/yyyy", Locale.ENGLISH);

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            br.readLine(); // this will read the first line

            int i=0;

            while ((line = br.readLine()) != null) {

                sales sales = new sales();
                String[] salesCsv = line.split(cvsSplitBy);

                sales.setRegion(salesCsv[0]);
                sales.setCountry(salesCsv[1]);
                sales.setItemType(salesCsv[2]);
                sales.setSalesChannel(salesCsv[3]);
                sales.setOrderPriority(salesCsv[4]);
                sales.setOrderDate(new Timestamp(format.parse(salesCsv[5]).getTime()));
                sales.setOrderId(salesCsv[6]);
                sales.setShipDate(new Timestamp(format.parse(salesCsv[7]).getTime()));
                sales.setUnitsSold(Integer.parseInt(salesCsv[8]));
                sales.setUnitsPrice(Double.parseDouble(salesCsv[9]));
                sales.setTotalRevenue(Double.parseDouble(salesCsv[11]));
                sales.setTotalCost(Double.parseDouble(salesCsv[12]));
                sales.setTotalProfit(Double.parseDouble(salesCsv[13]));

                System.out.println(sales.toString());

                i++;
            }

            System.out.println(i);

        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
*/
    }
}
