package collectionFramework;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ArrayListMain {
    public static void main(String[] args) {

        List<Integer> list = new ArrayList<>();

        // All method which can be applied on ArrayList
       /* list.add(1);    to add element
        list.remove(index);  to remove an element of specific index
        list.add(index, element);  to add an element on a specific index
        list.addAll(another list); // to add another list to the first list
        list.size();  // to get the size of list
        list.get(index) // to get the Value present at index
        list.contains(elements);  // return true or false, if element present in the list or not accordingly
        list.stream().mapToInt(Integer::intValue).toArray();// list to Array
        asList() method returns of fixed size list
        */
        List<String> list1 = Arrays.asList("vikas","wcw","sca");
        System.out.println(list1);
        list1.set(2,"vikas"); // We can add or remove Elements we can replace. like this
        System.out.println(list1);

       // Integer[] arr = {3,4,5,6,7,8};
        Integer[] arr1 = {3,4,5,6,7,8};
       // List<Integer> l1 = Arrays.asList(arr);
        List<Integer> l1 = Arrays.asList(3,4,5,6,7,8);
        List<Integer> l2 = Arrays.asList(arr1);
        System.out.println(l1);
        try{
            System.out.println(l1.addAll(l2));   // This addAll method will not work here because it creates a fixed size of l1

        }catch (Exception e){
            System.out.println("Exception message : "+e.getMessage());
        }

        List<Integer> list2 = new ArrayList<>();
        list2.add(2);
        list2.add(3);
        list2.add(5);
        List<Integer> list3 = new ArrayList<>();
        list3.add(2);
        list3.add(3);
        list3.add(5);
        list2.addAll(list3);
        Collections.sort(list2); // this is sorting method
        System.out.println(list2); // This will work fine because using ArrayList<> class we create dynamic list

        List<Integer> list4 = List.of(2,3,4,5,6,7); // this List.of() will not allow even replacement of any element.
        // It is also create fixed size list like Arrays.asList() but using Arrays.asList() we can do replace at least.


    }
}
