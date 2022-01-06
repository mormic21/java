package net.tfobz.kontoverwaltung;

import java.util.Calendar;

public class test {

	public static void main(String[] args) {
		/**
		Calendar calendar = Calendar.getInstance();
		int lastDate = calendar.getActualMaximum(Calendar.DATE);
		calendar.set(Calendar.DATE, lastDate);
		int lastDay = calendar.get(Calendar.DAY_OF_WEEK);
		System.out.println("Last Date: " + calendar.getTime());
		System.out.println("Last Day : " + lastDay);
		*/
//		
//		Calendar currentDay = Calendar.getInstance();
//		currentDay.set(2022, 6, 30);
//        Calendar lastDay = Calendar.getInstance();
////        lastDay.set(lastDay.getActualMaximum(Calendar.YEAR), 
////        		lastDay.getActualMaximum(Calendar.MONTH), 
////        		lastDay.getActualMaximum(Calendar.DATE), 
////        		lastDay.getActualMaximum(Calendar.HOUR), 
////        		lastDay.getActualMaximum(Calendar.MINUTE), 
////        		lastDay.getActualMaximum(Calendar.SECOND));
////        lastDay.set(Calendar.MONTH, 11);
////        lastDay.set(Calendar.DATE, 31);
////        lastDay.set(Calendar.HOUR_OF_DAY, 23);
////        lastDay.set(Calendar.MINUTE, 59);
////        lastDay.set(Calendar.SECOND, 59);
////        
////        //System.out.println(lastDay.getActualMaximum(Calendar.HOUR_OF_DAY));
////        int daysLeft = lastDay.get(Calendar.DAY_OF_YEAR) - currentDay.get(Calendar.DAY_OF_YEAR);
//        double zinssatz = 100;
//        double kontostand = 1000;
////        double faktor = lastDay.get(Calendar.DAY_OF_YEAR) / daysLeft;
////        zinssatz = zinssatz / faktor;
////        System.out.println(lastDay.get(Calendar.DAY_OF_YEAR));
////        System.out.println("zinssatz: "+zinssatz);
////        double ret = kontostand * (zinssatz / 100);
////        System.out.println(ret);
////        System.out.println("current: "+currentDay.getTime());
////        System.out.println("lastDay: " + lastDay.getTime());
////        System.out.println("left: "+daysLeft);
//        double ret = zinssatz * kontostand * ((1-currentDay.get(Calendar.DAY_OF_YEAR))/Calendar.DAY_OF_YEAR);
//        System.out.println(ret);
		
		int a = -4000;
		int b = -3000;
		System.out.println(a > b);
		
		
	}

}
