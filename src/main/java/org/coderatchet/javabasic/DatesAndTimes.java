package org.coderatchet.javabasic;
import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.time.Year;
import java.time.format.DateTimeFormatter;
import java.time.temporal.Temporal;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;
import java.util.Date;

public class DatesAndTimes {
	public static void main(String[] args) {
		
		//using standard date classes
		Date date = new Date();
		System.out.println(date);
		SimpleDateFormat format = new SimpleDateFormat("E yyyy.MM.dd 'at' hh:mm:ss a zzz");
		System.out.println("using SimpleDateFormat: " + format.format(date));
		System.out.printf("using printf %tc", date);
		
		// using LocalDate classes
		Month month = null;
	    LocalDate date2 = null;
	    DateTimeFormatter formatter;
	    String out = null;

	    month = Month.valueOf("May".toUpperCase());
	    date2 = Year.now().atMonth(month).atDay(12);

	    LocalDate nextPayday = date2.with(new PaydayAdjuster());

	    formatter = DateTimeFormatter.ofPattern("yyyy MMM d");
	    out = date2.format(formatter);
	    System.out.printf("\n\nGiven the date:  %s%n", out);
	    out = nextPayday.format(formatter);
	    System.out.printf("the next payday: %s%n", out);
	}
	
	public static class PaydayAdjuster implements TemporalAdjuster {
	    
	    /**
	     * The adjustInto method accepts a Temporal instance
	     * and returns an adjusted LocalDate. If the passed in
	     * parameter is not a LocalDate, then a DateTimeException is thrown.
	     */
	    public Temporal adjustInto(Temporal input) {
	        LocalDate date = LocalDate.from(input);
	        int day;
	        if (date.getDayOfMonth() < 15) {
	            day = 15;
	        } else {
	            day = date.with(TemporalAdjusters.lastDayOfMonth()).getDayOfMonth();
	        }
	        date = date.withDayOfMonth(day);
	        if (date.getDayOfWeek() == DayOfWeek.SATURDAY ||
	            date.getDayOfWeek() == DayOfWeek.SUNDAY) {
	            date = date.with(TemporalAdjusters.previous(DayOfWeek.FRIDAY));
	        }

	        return input.with(date);
	    }
	}
}

