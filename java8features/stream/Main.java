package java8features.stream;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.Arrays.stream;

public class Main {
    public static void main(String[] args) {

        // Imperative approach
        int[] arr = {1, 2, 3, 4, 5};
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 2 == 0) {
                sum += arr[i];
            }
        }
        System.out.println(sum);


        // Declarative approach
        int[] arr1 = {1, 2, 3, 4, 5, 6};
        int sum2 = stream(arr1).filter(n -> n % 2 == 0).sum();
        int sum3 = stream(arr1).sum();
        System.out.println(sum2 + "  " + sum3);


        // CREATING STREAMS

        // List to stream
        List<Integer> list = List.of(1, 2, 3, 4);
        Stream<Integer> listStream = list.stream();
        System.out.println(listStream);

        // Array to stream
        Integer[] arr4 = {1, 2, 3, 4, 5, 6};
        Stream<Integer> arrayStream = Arrays.stream(arr4);
        System.out.println(arrayStream);

        // creating stream
        Stream<String> stringStream = Stream.of("vikas", "kumar", "Btech");
        System.out.println(stringStream);

        // creating sum up stream
        Stream<Integer> limitStream = Stream.iterate(0, n -> n + 1).limit(15);
        System.out.println(limitStream);

        // Generating random stream
        Stream<Integer> randomStream = Stream.generate(() -> (int) Math.random() * 100).limit(3);


        // Operations on Streams

        // 1. filter() is used as Predicate(condition based) while map() is used as function(Operation based)

        List<Integer> list1 = List.of(2, 3, 4, 5, 6, 7, 8, 9,0,2,1,32, 10, 11, 12, 34);
        List<Integer> filteredList = list1.stream().filter(x -> x % 2 == 0).collect(Collectors.toList());
        // collect(Collectors.toList()) is used to get back into List format from Stream
        System.out.println(filteredList);
        List<Integer> mappedList = filteredList.stream().map(n -> n / 2).collect(Collectors.toList());
        System.out.println(mappedList);
        // collect(Collectors.toSet()) is used to provide unique values in List
        Set<Integer> filteredSet = list1.stream().filter(n -> n % 2 == 0).collect(Collectors.toSet());
        System.out.println(filteredSet);

        List<Integer> distinctList = list1.stream().distinct().sorted().collect(Collectors.toList());
        System.out.println(distinctList);
        Set<Integer> withoutFilteredList = list1.stream().collect(Collectors.toSet());
        System.out.println(withoutFilteredList);



        List<Integer> list2 = list1
                .stream()             // Converts list into stream
                .filter(n -> n%2==0)  // filter out values as I need or want
                .map(n -> n/2)         // Apply required operation on those values
                .sorted((a,b) -> (b-a))  // sort in descending order
                .limit(4)      // apply limit as per need of requirement
                .skip(1)           // skip according as want
                .collect(Collectors.toList()); // collect back those streamed elements into List
        System.out.println(list2);    // Prints that list


    }
}

