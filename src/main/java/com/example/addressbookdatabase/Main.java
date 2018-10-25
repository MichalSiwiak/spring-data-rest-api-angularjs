package com.example.addressbookdatabase;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) throws IOException {

        Document document = Jsoup.connect("https://www.bankier.pl/gielda/notowania/akcje").timeout(6000)
                .get();
        Elements nameList = document.select("td.colWalor.textNowrap");
        Elements lastPriceList = document.select("td.colKurs.change");
        Elements changeInNumberList = document.select("td.colZmiana.change");
        Elements changeInPercentList = document.select("td.colZmianaProcentowa.change");
        Elements numberOfTransactionsList = document.select("td.colLiczbaTransakcji");
        Elements turnoverList = document.select("td.colObrot");
        Elements timeList = document.select("td.colAktualizacja");

        List<Value> valueList = new ArrayList<>();

        for (int i = 0; i < nameList.size(); i++) {

            Value value = new Value();
            value.setName(nameList.get(i).text());

            value.setLastPrice(new ChangeableString(lastPriceList.get(i).text()).convert());
            value.setLastPrice(new ChangeableString(changeInNumberList.get(i).text()).convert());
            value.setLastPrice(new ChangeableString(changeInPercentList.get(i).text()).convert());
            value.setLastPrice(new ChangeableString(numberOfTransactionsList.get(i).text()).convert());
            value.setLastPrice(new ChangeableString(turnoverList.get(i).text()).convert());

            value.setTime(timeList.get(i).text());

            valueList.add(value);
        }

        Map<String, String> sectors;

        try {
            FileInputStream fileIn = new FileInputStream("sectors.map");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            sectors = (Map<String, String>) in.readObject();
            in.close();
            fileIn.close();
        } catch (IOException i) {
            i.printStackTrace();
            return;
        } catch (ClassNotFoundException c) {
            System.out.println("File not found");
            c.printStackTrace();
            return;
        }

        for (Value value : valueList) {
            value.setSector(sectors.get(value.getName()));
            System.out.println(value.toString());

        }

       /* for (Value value : valueList) {
            String url = "https://www.bankier.pl/gielda/notowania/akcje/" + value.getName() + "/podstawowe-dane";
            System.out.println(url);
            Document sector = Jsoup.connect(url).timeout(6000)
                    .get();
            String sectorName = sector.select("div#boxBasicData div.boxContent.boxTable td:not(.textBold.textNowrap)").get(2).text();
            sectors.put(value.getName(), sectorName);
        }*/

        /*try {
            FileOutputStream fileOut =
                    new FileOutputStream("sectors.map");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(sectors);
            out.close();
            fileOut.close();
            System.out.printf("Serialized data is saved in /tmp/employee.ser");
        } catch (IOException i) {
            i.printStackTrace();
        }*/

       /* System.out.println(nameList.size());
        System.out.println(lastPriceList.size());
        System.out.println(changeInNumberList.size());
        System.out.println(changeInPercentList.size());
        System.out.println(numberOfTransactionsList.size());
        System.out.println(turnoverList.size());
        System.out.println(openingPriceList.size());
        System.out.println(maxList.size());
        System.out.println(minList.size());
        System.out.println(timeList.size());*/
    }
}
