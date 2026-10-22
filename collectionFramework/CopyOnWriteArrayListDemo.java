package collectionFramework;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class CopyOnWriteArrayListDemo {
    public static void main(String[] args) {

        List<String> stringList = new ArrayList<>();
        stringList.add("Milk");
        stringList.add("Eggs");
        stringList.add("Bread");
        System.out.println("Initial Shopping List "+stringList);

//        for(String item : stringList){
//            System.out.println(item);
//            if(item.equals("Eggs")){
//                stringList.add("Butter");
//                System.out.println("Added butter while reading list");
//            }
//        }
       // System.out.println("List Updated after butter added "+stringList); // I got ConcurrentModification Exception here

        CopyOnWriteArrayList<String> shoppingList = new CopyOnWriteArrayList<>();
        shoppingList.add("Milk");
        shoppingList.add("Eggs");
        shoppingList.add("Bread");
        System.out.println("Initial Shopping List "+shoppingList);

        for(String item : shoppingList){
            System.out.println(item);
            if(item.equals("Eggs")){
                shoppingList.add("Butter");
                System.out.println("Added butter while reading list"); // Here we will not get ConcurrentModificationException because we have used CopyOnWriteArrayList as class
            }
        }
        System.out.println("List Updated after butter added "+shoppingList);
    }
}
