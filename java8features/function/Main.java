package java8features.function;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;


// Function is an Interface which has only abstract method named 'apply()'
public class Main {
    public static void main(String[] args) {
        Function<String, Integer> function = x -> x.length();
        System.out.println(function.apply("Vikas"));

        Function<String, String> function1 = x -> x.substring(0, 3);

        Function<Integer,Integer> fun1 = x -> x * 2;
        Function<Integer,Integer> fun2 = x -> x * x * x;

        System.out.println(fun1.andThen(fun2).apply(3)); // 216
        System.out.println(fun2.andThen(fun1).apply(3)); // 54

        Function<List<Student>, List<Student>> studentsWithPrefixAsVip = x -> {
            List<Student> students = new ArrayList<>();
            for (Student s : x) {
                if (Boolean.parseBoolean(function1.apply(String.valueOf(s.getName().equalsIgnoreCase("vip"))))) {
                    students.add(s);
                }
            }
            return students;
        };

        Student s1 = new Student("vikas", 1);
        Student s2 = new Student("vipin", 3);
        Student s3 = new Student("Vipul", 9);
        Student s4 = new Student("Virat", 8);
        List<Student> st = Arrays.asList(s1, s2, s3, s4);
        List<Student> filteredStudents = studentsWithPrefixAsVip.apply(st);
        System.out.println(filteredStudents);


    }

    public static class Student {
        String name;
        int id;

        public Student(String name, int id) {
            this.name = name;
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        @Override
        public String toString() {
            return "Student{" +
                    "name='" + name + '\'' +
                    ", id=" + id +
                    '}';
        }
    }
}
