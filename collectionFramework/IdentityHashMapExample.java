package collectionFramework;

import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.Map;

class IdentityMapExample {
    public static void main(String[] args) {
        // Creating two distinct object instances with identical content
        String key1 = new String("Java");
        String key2 = new String("Java");

        // 1. Standard HashMap Behavior
        Map<String, String> hashMap = new HashMap<>();
        hashMap.put(key1, "Version 21");
        hashMap.put(key2, "Version 22"); // This overwrites key1's value because key1.equals(key2) is true

        System.out.println("HashMap Size: " + hashMap.size()); // Prints 1

        // 2. IdentityHashMap Behavior
        Map<String, String> identityMap = new IdentityHashMap<>();
        identityMap.put(key1, "Version 21");
        identityMap.put(key2, "Version 22"); // Added as a separate entry because key1 == key2 is false

        System.out.println("IdentityHashMap Size: " + identityMap.size()); // Prints 2
        System.out.println("Key1 Value: " + identityMap.get(key1)); // Prints "Version 21"
    }
}
