
Why we need Java 8 features
1. Concise and Minimal code
2. Functional Programming was missing in benefit of OOPs nature.
3. To enable parallel Programming, More compatible code for multiple processor


Feature of Java 8
1. Lambda Expression - Lambda Expression are similar to the method, but they don't need a name they can be implemented right in the body of a method.
   (x,y) -> x+y
2. Stream API - Java Stream API for bulk Data Operation On Collections.
3. Date and Time API 
4. Base64 Encode and Decode
5. Method reference and constructor reference (:: operator)
6. public static method in Interface
7. Functional Interface - It is an Interface which has Exactly one abstract method to designate an interface as a Functional Interface, we don't need to use the @FunctionalInterface annotation.
8. Optional class


1. Lambda Expression 
   -Lambda Expression is an anonymous function.
    1. Not having any name
    2. Not having any return type
    3. Not having modifier
     
  - Steps to make any function as lambda expression
    1. Remove Modifier
    2. Remove return type
    3. Remove method name
    4. Place Arrow
     
  - Characteristics / Properties of lambda Expression
    1. if body has just one statement then we can remove curly brackets {}.
    2. Use type inference, compiler guess the situation or context.


       private void add(int a, int b){
         System.out.println(a+b);
       }

    Converted to
       (int a, int b) -> { System.out.println(a+b);}

    Converted to (By Compiler)
       (a,b) -> { System.out.println(a+b);} // Here Compiler will automatically understand that the arguments are of int type So we don't need to Explicitly Specify.


    3. No Return keyword

       private int getStringlength(String str){
         return str.length();
       }
    Converted to
       (String str) -> {return str.length();}
    Converted to
       (str) -> str.length();

    4. If only one param remove small brackets

       (str) -> str.length();
    Converted to 
        str -> str.length();
   


  - Benefits of Lambda Expression
    1. To enable functional programming in java
    2. To make code more readable, maintainable and concise code
    3. To enable parallel processing
    4. JAR file size reduction
    5. Elimination of shadow variables

2. Functional Interface
   - Interface having exactly single abstract method but can have any number of defaults and static methods. We can invoke lambda expression by using functional interface.

   - Advantages of the Interface to be a functional annotation
     1. It restricts the interface to be a Functional Interface
     2. So if People have already used some lambda expression and show new team member added another abstract method on the Interface all lambda expression will have errors.
   - A functional Interface can have a child interface they both can have Same abstract method but not different abstract method.
   
 Default method in Interface
   - Till Java 1.7 only public abstract can be defined in Interface but After Java 8 we can have concrete method inside Interface as well.
   - Similarly public static final variable are allowed.
 static method in Interface
   - static method in Interface is defined with 'static' keyword.
   - static method contains complete definition of the function.
   - cannot be overridden or changed in the implementation class.
   - We can also write psvm method insider an Interface.
 
 Runnable and Comparator are Functional Interface
 We don't need a Implementation class for a Functional Interface, We can directly use those functional interface in Main class using Lambda Expression.
 

********************************************* IMPORTANT *************************************

 1. We can use directly Lambda Expression (Without class Implementation) for a Functional Interface Because a Functional Interface can have only one Abstract method.
 2. And We can have Multiple implementation of a single Abstract method of a functional Interface as well Directly Using Lambda Expression.(We can implement 
  like this (We have two different Implementation of Same abstract method (getName()) of Employee Interface ).

           Employee employee = () -> "Software Engineer!!";
           System.out.println(employee.getName());

           Employee editor = () -> "Editor hu bhai..";
           System.out.println(editor.getName());
  )

 3. And for Normal Interface which have more than one Abstract method We have to use Anonymous inner class for that instead of Lambda Expression.


  4. For a single Abstract class --> Lambda Expression
  5. for more than one abstract class --> Anonymous inner class
