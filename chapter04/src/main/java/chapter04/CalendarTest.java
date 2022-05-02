package chapter04;

import java.util.Calendar;

public class CalendarTest {

	public static void main(String[] args) {
		
		Calendar cal = Calendar.getInstance();
		
		cal.set(Calendar.YEAR,  2022);
		cal.set(Calendar.MONTH, 11); // 12 (Month + 1)
		cal.set(Calendar.DATE, 25);
		printDate(cal);
		
		cal.set(1999, 5, 14); // 1999/06/14
		cal.add(Calendar.DATE, 100);
		printDate(cal);
	}
	
	private static void printDate(Calendar cal) {
		final String[] DAYS = {"Sun","Mon","Tues","Wed","Thurs","Fri","Sat"};
		
		int year = cal.get(Calendar.YEAR);
		int month = cal.get(Calendar.MONTH); // 0~11, +1
		int date = cal.get(Calendar.DATE);
		int day = cal.get(Calendar.DAY_OF_WEEK); // 1(Sun) ~ 7(Sat)
		int hour = cal.get(Calendar.HOUR);
		int minute = cal.get(Calendar.MINUTE);
		int seconds = cal.get(Calendar.SECOND);
		
		
		System.out.println(
				year + "-" +
				((month < 10) ? "0" : "") + (month + 1) + "-" +
				((date < 10) ? "0" : "") + date + " " +
				DAYS[day-1] + " " +
				hour + "h " +
				minute + "m " +
				seconds + "s");
	}

}
