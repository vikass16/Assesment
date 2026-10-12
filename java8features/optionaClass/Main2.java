package java8features.optionaClass;

import java.util.Optional;


// We use Optional Class because it can String method can return null, So we have to Explicitly check Everytime. To overcome that Optional Class is Used

public class Main2 {
    public static void main(String[] args) {
        Optional<String> name = getName(1);
//        if(name.isPresent()){
//            System.out.println(name.get());
//        }

        // This one is more precise and readable
        name.ifPresent(System.out::println);

        String nameToBeUsed = name.orElse("NA"); // If name is Returning from other method then print name else print NA in case of ofNullable only [if Optional.of() then throw nullPointerException].
        System.out.println(nameToBeUsed);
    }
    public static Optional<String> getName(int id){
//        String name = null;
//        return Optional.of(name);

        // If we return String then Optional.of() is Okay but when we return a null String then it will throw exception like NullPointerException
        // To overcome this problem there is method to return names as Optional.ofNullable().

//        String name1 = "Vikas";
//        return Optional.ofNullable(name1);

        return Optional.ofNullable(null);
    }



    /*
    Optional is a class Which return methods like
    Optional.of() -> return nullPointerException if null String is Present
    Optional.ofNullable() -> return nothing if null String is present
    isPresent() -> return boolean if the Value is present or not
    ifPresent() -> a consumer which prints the value of String as it is passed.
    we access String using .get() method like [name.get()]
     */

    /*
     There is one more method used name orElse()
     Like
     1. String nameToBeUsed = if.Present() ? name.get() : "Name not Present";
     Instead of 1 we can use it like this
     String nameToBeUsed = name.orElse("Name not Present");
     Both has similar working but orElse() is more readable if name is Present return name else print Name not Present

     We can also use orElseGet(), orElseThrow() -> to Throw customException
     */
}
