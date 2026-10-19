package collectionFramework;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;


class StringLengthComparator implements Comparator<String>{

    @Override
    public int compare(String o1, String o2) {
        return o1.length() - o2.length();
    }
    // o1 comes before when o1 < o2 (-)( means ascending order of length)
    // o2 comes first when o2 > o1 (+)(means descending order of length)

}
public class ComparatorMain {
    public static void main(String[] args) {

        // Comparator is an Interface.It sorts values in natural order

        List<Integer> list = Arrays.asList(2,1,4,2);
        list.sort(null);
        System.out.println(list);

        List<String> list1 = Arrays.asList("Banana", "Apple", "date");
        // for natural sorting I have to use comparator like this on the basis of Character which comes first like a,b then d
        list1.sort(null);
        System.out.println(list1);

        // But for custom sorting, We used StringLengthComparator class which implements Comparator interface
        list1.sort(new StringLengthComparator());
        System.out.println(list1);


        List<String> list2 = Arrays.asList("Mango","Papaya","Grapes","Kiwi","pea");
        // We can sort list or list2 without using Implementation class using Lambda Expression, like this
        list2.sort((a,b) -> a.length() - b.length()); // It will actually sort in ascending without even using Lambda Expression (only using null)
        list2.sort((a,b) -> b.length() - a.length()); // this will sort in Descending order is Custom sorting
        System.out.println(list2+" in Descending order");


    }
}
