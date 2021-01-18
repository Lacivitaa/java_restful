package com.lacivita.di.factories;

import com.lacivita.di.loggers.TimeLogger;

import javax.enterprise.inject.Produces;
import java.lang.annotation.Target;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class TimeLoggerFactory {

    @Produces
    public TimeLogger getTimeLogger(){
        return new TimeLogger(new SimpleDateFormat("HH:mm"), Calendar.getInstance());
    }
}
