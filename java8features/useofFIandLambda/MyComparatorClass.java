package java8features.useofFIandLambda;

import java.util.Comparator;

public class MyComparatorClass implements Comparator<Integer> {

    @Override
    public int compare(Integer a, Integer b) {
        //return a-b;  // for ascending Order
        return b-a; // for descending order
    }
}
