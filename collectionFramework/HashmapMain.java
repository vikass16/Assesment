package collectionFramework;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class HashmapMain {
    public static void main(String[] args) {
        Map<Student, String> map1 = new HashMap<>();
        Student s1 = new Student("Vikas",1);
        Student s2 = new Student("Vipin",2);
        Student s3 = new Student("Vikas",1);

        // Putting Marks of Each student. (Without overriding hashCode and equals method)
//        map1.put(s1,"Engineer");  // hashCode1 --> index1
//        map1.put(s2,"HR");  // hashCode2 --> index2
//        map1.put(s3,"Manager");  // hashCode3 --> index3

        // After overriding hashCode and equals method this will check for equals keys
        map1.put(s1,"Engineer");  // hashCode1 --> index1
        map1.put(s2,"HR");  // hashCode2 --> index2
        map1.put(s3,"Manager");  // hashCode3 --> index3 --> equals --> replace (Engineer with manager)[s1 and s3 will be one]

        System.out.println(s1);


        System.out.println(map1.size());
        System.out.println("Value of s1 : "+map1.get(s1));
        System.out.println("Value of s3 : "+map1.get(s3));
        //for the same Student "Vikas" with same id = 1, there will different index
        //because Object is stored in memory and each new object has its own index

        Map<String, Integer> map2 = new HashMap<>();
        map2.put("Vikas",1); // hashCode1 --> index1
        map2.put("Vipin",2); // hashCode2 --> index2
        map2.put("Vikas",3); // hashCode1 --> index1 --> equals --> replace
        // here key is same for both,
        // and it is not Object it is String hence it will override the id and for "Vikas" id will be 3.
        System.out.println(map2);
    }

}

class Student{
    String name;
    int id;

    Student(String name, int id){
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)  // Checking on same object
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        Student student = (Student) obj;
        return id == student.id && Objects.equals(name, student.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, id);
    }
}


/*
Here is a quick breakdown of exactly how map.put() uses your overridden methods to achieve this:

1. Finding the Bucket (hashCode)

When you pass a key into map.put(key, value), the map immediately calls key.hashCode().
• Without your override: The two objects generate different hash codes and go to completely different buckets. The map thinks they are totally unrelated and stores both.
• With your override: Both objects generate the exact same hash code, directing the map to the exact same bucket.

2. Checking for Duplicates (equals)

Once the map arrives at the correct bucket, it looks at the keys already sitting inside that bucket. It uses existingKey.equals(newKey) to see if your new key matches any old key.
• Without your override: Java compares their memory addresses, decides they are different, and adds a duplicate entry to the map.
• With your override: Java compares their actual values (like ID or name), sees they match (true), and overwrites the old value with the new value.

💻 A Quick Visual Example

Imagine a custom Employee class where you did override both methods:
java

HashMap<Employee, String> map = new HashMap<>();

Employee emp1 = new Employee(101, "Alex");
Employee emp2 = new Employee(101, "Alex"); // Same Key data!

map.put(emp1, "Desk 1");
map.put(emp2, "Desk 2"); // This will OVERWRITE "Desk 1"

System.out.println(map.size()); // Output: 1 (No duplicate space wasted!)
Use code with caution.
Because you overrode the methods, the map is smart enough to know emp2 is logically the same as emp1. It safely updates the value to "Desk 2" and keeps the map size at 1.
 */


