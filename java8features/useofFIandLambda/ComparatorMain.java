package java8features.useofFIandLambda;

import java.util.*;

public class ComparatorMain {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(23);
        list.add(43);
        list.add(1);
        list.add(98);
        list.add(87);

        // Without Lambda Expression Using MyComparator (We need MyComparatorClass to implement this. We can only sort Asc or Dec Only one When we use Implementation class).

//        Collections.sort(list, new MyComparatorClass());
//        System.out.println(list);

        // With Lambda Expression (We don't need MyComparatorClass to implement these.

        System.out.println(list); // List as per insertion order
        Collections.sort(list, (a,b) -> b-a); // To print in Descending order
        System.out.println(list);
        Collections.sort(list, (a,b) -> a-b);  // To print in Ascending order
        System.out.println(list);



        // For an Example of Directly Implementation of Set Interface below (It has no other classes because we are using Interface Directly in Main Class)


        // This one is for Normal Implementation of Set Interface Without any other class or Lambda Expression
        Set<Integer> set = new TreeSet<>();
        set.add(22);
        set.add(33);
        set.add(99);
        set.add(66);
        System.out.println(set); // Before sorting (Tree will make set in Ascending order)


        // This and Above implementations are same btw because TreeSet will automatically sort it in Ascending order (Here I used Lambda Expression)
        Set<Integer> set1 = new TreeSet<>((a,b) -> a-b);
        set1.add(22);
        set1.add(77);
        set1.add(99);
        set1.add(66);
        System.out.println(set1);

        // I Sort it Using Lambda Expression [(a, b) -> b-a]
        Set<Integer> set2 = new TreeSet<>((a, b) -> b-a);
        set2.add(22);
        set2.add(77);
        set2.add(99);
        set2.add(66);
        System.out.println(set2);


    }
}
