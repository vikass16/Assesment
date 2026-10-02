package java8features.predicates;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class Main {

    // Predicate is an Interface which has an Abstract method of Boolean type (test) which works on Conditions (Like if else)
    // Provide results as True/False

    public static void main(String[] args) {
        Predicate<Integer> predicate = x -> x > 15000; // Here we check that x(number) is greater than 15000
        System.out.println(predicate.test(20000)); // We pass here value of x which is 20000 . So answer will be true.


        List<Integer> list = List.of(1,2,3,4,5,6,7,8,9,10);
        int sum = list.stream().filter(n -> n%2==0).mapToInt(n->n).sum();
        System.out.println(sum);
        // printing the Sum of All elements which is even in the list.

        Predicate<String> name = x -> x.toLowerCase().charAt(0) == 'v';
        System.out.println(name.test("Vikas"));



        // Default and Static Method in Predicate.

        Predicate<String> p1 = x -> x.toLowerCase().charAt(0) == 'V';  // name starts with
        Predicate<String> p2 = x -> x.toLowerCase().charAt(x.length()-1) == 's'; // name ends with

        Predicate<String> p3 = p1.and(p2);
        Predicate<String> p4 = p1.or(p3);
        Predicate<String> p5 = p1.negate();

        // Use of [and() : Both should be true] , [or() : Any one should be true] , & [negate() : use to Negate the Value]

        System.out.println(p3.test("vikas")+"  || "+p4.test("Vikas") +" || "+p5.test("Vikas"));

    }
}
