package collectionFramework;

import java.util.SortedMap;
import java.util.TreeMap;

public class SortedMapMain {

    // TreeMap is a class Which implements SortedMap interface and SortedMap is an interface which extends Map Interface.

    // It sorts the Map on the basis of Key (according to key : if key is String then in a-z manner and if key in numeric then in 1-100 manner like this)
    public static void main(String[] args) {

       // SortedMap<Integer,String> sortedMap = new TreeMap<>();  // for Ascending (Natural) ordering
        SortedMap<Integer,String> sortedMap = new TreeMap<>((a,b) -> b-a);  // for Descending ordering
        sortedMap.put(12,"Vikas");
        sortedMap.put(2,"Vishnu");
        sortedMap.put(89,"Atul");
        sortedMap.put(78,"Anish");

        System.out.println(sortedMap);
        System.out.println(sortedMap.headMap(78)); // excludes head
        System.out.println(sortedMap.tailMap(78)); // includes head
        System.out.println(sortedMap.firstKey());
        System.out.println(sortedMap.lastKey());

        // NavigationMap is an Interface which extends SortedMap Which is also an Interface.
        // TreeMap extends NavigationMap
    }
}
