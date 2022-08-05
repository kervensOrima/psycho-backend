package com.helptek.spychobackend.utilities;


import java.util.Calendar;
import java.util.Date;

public class DateManipulationService {

    public static int calculAge(Date date) {
        Calendar now = Calendar.getInstance() ;
        Calendar dateRequest = Calendar.getInstance() ;

        now.setTime(new Date());
        dateRequest.setTime(date);

        return now.get(Calendar.YEAR) - dateRequest.get(Calendar.YEAR) ;
    }

    public static boolean checkAge(int age, int critere) {
        return age > critere ;
    }
}
