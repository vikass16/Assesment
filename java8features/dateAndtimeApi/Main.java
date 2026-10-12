package java8features.dateAndtimeApi;

import java.time.*;

public class Main {
    public static void main(String[] args) {

        // Issue with Date and Calendar classes before Java 8
        // Mutable, Confusing, Limited(zones, difference)
        // There are 8 classes in Java 8+ in Date and Time API
        // 1. LocalDate, 2. LocalTime, 3. LocalDateTime, 4. ZoneDateTime, 5. Instant, 6. Period, 7.Duration, 8. DateTimeFormatter

        // 1. LocalDate return current Date from System
        LocalDate date = LocalDate.now();
        LocalDate customDate = LocalDate.of(2003,10,16);
        System.out.println(date+"    "+customDate);
        System.out.println();
        int dayOfMonth = date.getDayOfMonth();
        Month month = date.getMonth();
        int year = date.getYear();
        DayOfWeek dayOfWeek = date.getDayOfWeek();
        System.out.println(dayOfMonth+" "+month+" "+year+" "+dayOfWeek);
        System.out.println("10 year ago on same Date the Day was : "+date.minusYears(10).getDayOfWeek());

        LocalDate date1 = date.minusDays(2);
        LocalDate date2 = date.minusYears(10);
        System.out.println("Two days before date was : "+date1+" || 10 years before date was : "+date2);


        // LocalTime
        LocalTime localTime = LocalTime.now();
        LocalTime customLocalTime = LocalTime.of(14, 28, 12);
        System.out.println(localTime+"  "+customLocalTime);
        LocalTime parseTime = LocalTime.parse("13:43:32");
        System.out.println(parseTime);


        // LocalDateTime
        LocalDateTime now = LocalDateTime.now();
        System.out.println(now);

        // ZonedDateTime
        ZonedDateTime now1 = ZonedDateTime.now();
        System.out.println(now1);
       // Set<String> availableZones = ZoneId.getAvailableZoneIds();
        //availableZones.forEach(System.out::println);
        ZonedDateTime newYorkTime = ZonedDateTime.now(ZoneId.of("America/New_York"));
        System.out.println(newYorkTime);
    }
}
