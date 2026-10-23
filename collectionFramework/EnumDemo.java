package collectionFramework;

import java.util.EnumMap;
import java.util.HashMap;
import java.util.Map;


// Internal Arrays size same as enum
// No hashing, ordinal/index is used.
// Faster than HashMap, memory efficient
public class EnumDemo {
    public static void main(String[] args) {
        Map<Day, String> map = new EnumMap<>(Day.class);
        map.put(Day.SATURDAY,"Nothing");
        System.out.println(Day.SATURDAY.ordinal());
    }
}

enum Day{
    MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY
}

// Enum is a class that directly implements Map interface
// It direct remember the index on enum