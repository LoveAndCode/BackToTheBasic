package com.tistory.johnmark.datetime;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.Period;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class DateTImeTest {
	public static void main(String[] args) {
		System.out.println("------------------------------------------------------");
		System.out.println("Machine Date Time Handling...");
		System.out.println("------------------------------------------------------");

		/**
		 *  machine Date time handling
		 */
		Instant instant = Instant.now();
		System.out.println(instant); // GMT, UTC 기준 현재 시간

		// 현재 지역 기준 시간
		ZoneId zone = ZoneId.systemDefault();
		System.out.println(zone);
		ZonedDateTime zonedDateTime = instant.atZone(zone);
		System.out.println(zonedDateTime);

		/**
		 *  Human Date time handling
		 */

		System.out.println("------------------------------------------------------");
		System.out.println("Human Date Time Handling...");
		System.out.println("------------------------------------------------------");

		LocalDateTime now = LocalDateTime.now();
		System.out.println(now);
		LocalDateTime birthDay = LocalDateTime.of(1996, 1, 16, 0, 0, 0);
		System.out.println(birthDay);
		ZonedDateTime seoulNow = ZonedDateTime.now(ZoneId.of("Asia/Seoul"));
		System.out.println(seoulNow);

		System.out.println("------------------------------------------------------");
		System.out.println("Period Handling...");
		System.out.println("------------------------------------------------------");
		LocalDate nowDate = LocalDate.now();
		LocalDate nextYearBirthDay = LocalDate.of(2022, Month.JANUARY, 16);
		Period period = Period.between(nowDate, nextYearBirthDay);
		System.out.println("period = " + period.getMonths());

		Instant now2 = Instant.now();
		Instant plus = now2.plus(3, ChronoUnit.SECONDS);
		Duration duration = Duration.between(now2, plus);
		System.out.println("duration = " + duration.getSeconds());

		LocalDateTime now3 = LocalDateTime.now();
		System.out.println(now3);
		DateTimeFormatter MMddyyyy = DateTimeFormatter.ofPattern("MM/dd/yyyy");
		System.out.println(now3.format(MMddyyyy));

		LocalDate parseDate = LocalDate.parse("11/23/2022", MMddyyyy);
		System.out.println("parseDate = " + parseDate);
	}
}
