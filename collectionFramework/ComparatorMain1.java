package collectionFramework;

import java8features.useofFIandLambda.ComparatorMain;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ComparatorMain1 {
    public static void main(String[] args) {
        List<Student1> student1s = new ArrayList<>();
        student1s.add(new Student1(7.9,"Vikas"));
        student1s.add(new Student1(6.4,"Atul"));
        student1s.add(new Student1(7.2,"Anish"));
        student1s.add(new Student1(8.6,"Vishnu"));

        // Now I have print Students in Ascending order of their of gpa
        student1s.sort((a,b) -> (int) (a.getgpa() - b.getgpa()));
        for(Student1 i:student1s){
            System.out.println(i.getName()+" -> "+i.getgpa());
        }

        System.out.println();

        student1s.sort((a,b) -> {
            if(a.getgpa() - b.getgpa() < 0){
                return 1;
            }else if(a.getgpa() - b.getgpa() > 0){
                return -1;
            }else {
                return 0;
            }
        });
        for(Student1 s : student1s){
            System.out.println(s.getName()+" -> "+s.getgpa());
        }

        System.out.println("Using Comparator directly..");

        Comparator<Student1> comparing1 = Comparator.comparing(Student1::getgpa);
        student1s.sort(comparing1);
        for(Student1 s : student1s){
            System.out.println(s.getName()+" -> "+s.getgpa());
        }

        System.out.println();

        Comparator<Student1> reversed = Comparator.comparing(Student1::getgpa).reversed();
        student1s.sort(reversed);
        for(Student1 s : student1s){
            System.out.println(s.getName()+" -> "+s.getgpa());
        }

        System.out.println();
        // Now this will compare on the basis Of name also
        Comparator<Student1> thenCompare = Comparator.comparing(Student1::getgpa).reversed().thenComparing(Student1::getName);
        student1s.sort(thenCompare);
        for(Student1 s : student1s){
            System.out.println(s.getName()+" -> "+s.getgpa());
        }
    }
}

class Student1 {
    double gpa;
    String name;

    Student1(double gpa, String name){
        this.gpa = gpa;
        this.name = name;
    }

    public double getgpa(){
        return gpa;
    }
    public String getName(){
        return name;
    }
}