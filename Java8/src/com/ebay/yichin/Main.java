package com.ebay.yichin;

import java.time.Clock;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

public class Main {

	public static void main(String[] args) {
		
		ZoneId zone = ZoneId.systemDefault();
		Clock clock = Clock.system(zone);
		System.out.println(clock);
		// SystemClock[America/Los_Angeles]
		
		LocalDate date = LocalDate.now();
		System.out.printf("%s-%s-%s\n",
			    date.getYear(), date.getMonthValue(), date.getDayOfMonth());
		// 2017-5-12
		Date date1 = new Date();
		System.out.printf("%s-%s-%s",
			    date1.getYear(), date1.getMonth(), date1.getDay());
		// 117-4-5

	}

}
