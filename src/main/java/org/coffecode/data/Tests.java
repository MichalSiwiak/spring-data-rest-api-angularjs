package org.coffecode.data;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class Tests {

    public static void main(String[] args) throws ParseException {

        String string = "10/18/2014";
        DateFormat format = new SimpleDateFormat("MM/dd/yyyy", Locale.ENGLISH);
        Date date = format.parse(string);
        System.out.println(date);


        Timestamp timestamp = new Timestamp(date.getTime());


        System.out.println(timestamp);

    }
}
